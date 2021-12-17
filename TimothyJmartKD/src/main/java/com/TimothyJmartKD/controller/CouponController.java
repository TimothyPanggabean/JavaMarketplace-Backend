/**
 * Class yang mengatur semua hal yang berkaitan dengan sebuah kupon,
 * yaitu: bisa apply atau tidak dan get coupon
 */
package com.TimothyJmartKD.controller;

import com.TimothyJmartKD.Algorithm;
import com.TimothyJmartKD.Coupon;
import com.TimothyJmartKD.Predicate;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>
{
    @JsonAutowired(filepath = "C:/Users/Timothy/Desktop/Kuliah/Semester_5/OOP/Praktikum/Modul 9/couponTable.json", value = Coupon.class)
    public static JsonTable<Coupon> couponTable;

    /**
     * Mengecek aplikabilitas dari kupon
     * @param id id dari kupon yang ingin diakses
     * @param price harga dari barang yang ingin digunakan kupon
     * @param discount diskon yang diberikan kupon
     */
    @GetMapping("/{id}/canApply")
    boolean canApply(@PathVariable int id, @RequestParam double price, @RequestParam double discount)
    {
        Predicate<Coupon> couponPredicate = applicable -> applicable.id == id;
        return Objects.requireNonNull(Algorithm.find(getJsonTable(), couponPredicate)).canApply(price, discount);
    }

    /**
     * Mengambil kupon yang tersedia
     * @param page index halaman data
     * @param pageSize jumlah data dalam 1 halaman
     */
    @GetMapping("/getAvailable")
    List<Coupon> getAvailable(@RequestParam int page, @RequestParam int pageSize)
    {
        Predicate<Coupon> couponPredicate = available -> available.isUsed();
        return Algorithm.paginate(getJsonTable(), page, pageSize, couponPredicate);
    }

    /**
     *  Mengambil data dari file json
     */
    public JsonTable<Coupon> getJsonTable()
    {
        return couponTable;
    }

    /**
     *  Mengubah status aplikabilitas kupon setelah digunakan
     *  @param id id dari kupon yang ingin diakses
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id)
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
