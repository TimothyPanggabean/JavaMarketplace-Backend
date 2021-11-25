package com.TimothyJmartKD.controller;

import com.TimothyJmartKD.*;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController
{
    @JsonAutowired(filepath = "C:/Users/Timothy/Desktop/Kuliah/Semester 5/OOP/Praktikum/Modul 8", value = Product.class)
    public static JsonTable<Product> productTable;

    @PostMapping("/create")
    Product create(@RequestParam int accountId, @RequestParam String name, @RequestParam int weight,
                   @RequestParam double price, @RequestParam double discount, @RequestParam boolean conditionUsed,
                   @RequestParam ProductCategory category, @RequestParam byte shipmentPlans)
    {
        Predicate<Account> predId = account -> account.id == accountId;
        Predicate<Account> predStore = account -> account.store != null;

        if(Algorithm.exists(AccountController.accountTable.iterator(), predId) &&
                Algorithm.exists(AccountController.accountTable.iterator(), predStore))
        {
            Product product = new Product(accountId, name, weight, conditionUsed,
                    price, discount, category, shipmentPlans);
            productTable.add(product);
            return product;
        }
        return null;
    }

    public JsonTable<Product> getJsonTable()
    {
        return productTable;
    }

    @GetMapping("/{id}/store")
    List<Product> getProductByStore(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize)
    {

            Predicate<Product> pred = product -> product.accountId == id;
            return Algorithm.paginate(this.getJsonTable().iterator(), page, pageSize, pred);
    }

    @GetMapping("/getFiltered")
    List<Product> getProductFiltered(@RequestParam int page, @RequestParam int pageSize,
                                     @RequestParam int accountId, @RequestParam String search,
                                     @RequestParam int minPrice, @RequestParam int maxPrice,
                                     @RequestParam ProductCategory category)
    {
        Predicate<Product> accountIdFilter = accFilter -> accFilter.accountId == accountId;
        Predicate<Product> searchContain = contained -> contained.name.toLowerCase().contains(search.toLowerCase());
        Predicate<Product> minPriceFilter = minFiltered -> minFiltered.price >= minPrice;
        Predicate<Product> maxPriceFilter = maxFiltered -> maxFiltered.price <= maxPrice;
        Predicate<Product> categoryFilter = catFiltered -> catFiltered.category == category;
        Predicate<Product> filter = filtered -> Algorithm.exists(getJsonTable(), accountIdFilter) &&
                Algorithm.exists(getJsonTable(), searchContain) &&
                Algorithm.exists(getJsonTable(), minPriceFilter) &&
                Algorithm.exists(getJsonTable(), maxPriceFilter) &&
                Algorithm.exists(getJsonTable(), categoryFilter);

        return Algorithm.paginate(getJsonTable(), page, pageSize, filter);
    }
}
