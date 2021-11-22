package com.TimothyJmartKD.controller;

import com.TimothyJmartKD.Algorithm;
import com.TimothyJmartKD.Coupon;
import com.TimothyJmartKD.Predicate;
import com.TimothyJmartKD.Treasury;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CoupunController implements BasicGetController<Coupon>
{
    @JsonAutowired(filepath = "C:/Users/Timothy/Desktop/Kuliah/Semester 5/OOP/Praktikum/Modul 8", value = Coupon.class)
    public static JsonTable<Coupon> couponTable;

    @GetMapping("/{id}/canApply")
    boolean canApply(int id, double price, double discount)
    {
        for(Coupon coupon : couponTable)
        {
            if(coupon.id == id)
            {
                return coupon.canApply(price, discount);
            }
        }
        return false;
    }

    @GetMapping("/getAvailable")
    List<Coupon> getAvailable(@RequestParam int page, @RequestParam int pageSize)
    {
        Predicate<Coupon> couponPredicate = available -> available.isUsed();
        return Algorithm.paginate(getJsonTable(), page, pageSize, couponPredicate);
    }

    public JsonTable<Coupon> getJsonTable()
    {
        return couponTable;
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(int id)
    {
        for(Coupon coupon : couponTable)
        {
            if(coupon.id == id)
            {
                return coupon.isUsed();
            }
        }
        return false;
    }
}
