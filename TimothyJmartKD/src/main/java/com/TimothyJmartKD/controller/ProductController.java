package com.TimothyJmartKD.controller;

import com.TimothyJmartKD.*;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.TimothyJmartKD.controller.AccountController.accountTable;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
    @JsonAutowired(value = Product.class, filepath = "C:/Users/Timothy/Desktop/Kuliah/Semester_5/OOP/Praktikum/Modul 9/productTable.json")
    public static JsonTable<Product> productTable;

    @PostMapping("/create")
    Product create(@RequestParam int accountId, @RequestParam String name, @RequestParam int weight,
                   @RequestParam boolean conditionUsed, @RequestParam double price, @RequestParam double discount,
                   @RequestParam ProductCategory category, @RequestParam byte shipmentPlans) {
        Predicate<Account> predicates = acc -> acc.id == accountId;
        Predicate<Account> storePredicate = sp -> sp.store != null;
        if(Algorithm.exists(accountTable, predicates) && Algorithm.exists(accountTable, storePredicate)){
            Product product = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
            productTable.add(product);
            return product;
        }
        else {
            return null;
        }
    }

    public JsonTable<Product> getJsonTable() {
        return productTable;
    }

    @GetMapping("/{id}/store")
    List<Product> getProductByStore(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize) {
        Predicate<Product> predicates = prod -> true;
        List<Product> list = new ArrayList<>();

        for(Product product : getJsonTable()) {
            list.add(product);
        }

        return Algorithm.<Product>paginate(list, page, pageSize, predicates);
    }

    @GetMapping("/getFiltered")
    List<Product> getProductFiltered(@RequestParam int page, @RequestParam int pageSize, @RequestParam int accountId,
                                     @RequestParam String search, @RequestParam int minPrice, @RequestParam int maxPrice,
                                     @RequestParam ProductCategory category) {
        Predicate<Product> filter = filtered -> filtered.accountId == accountId &&
                filtered.name.toLowerCase().contains((search.toLowerCase())) &&
                filtered.price >= minPrice &&
                filtered.price <= maxPrice &&
                filtered.category.equals(category);

        List<Product> list = new ArrayList<>();
        for(Product product : getJsonTable()) {
            list.add(product);
        }

        return Algorithm.paginate(list, page, pageSize, filter);
    }
}
