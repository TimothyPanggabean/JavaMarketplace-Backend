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
    Product create(
            @PathVariable int accountId,
            @PathVariable String name,
            @PathVariable int weight,
            @PathVariable double price,
            @PathVariable double discount,
            @PathVariable boolean conditionUsed,
            @PathVariable ProductCategory category,
            @PathVariable byte shipmentPlans
        )
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
    List<Product> getProductByStore(@PathVariable int id, int page, int pageSize)
    {

            Predicate<Product> pred = product -> product.accountId == id;
            return Algorithm.paginate(this.getJsonTable().iterator(), page, pageSize, pred);
    }

    @GetMapping("/getFiltered")
    List<Product> getProductFiltered(int page, int pageSize, int accountId, String search,
                                     int minPrice, int maxPrice, ProductCategory category)
    {
        return null;
    }
}
