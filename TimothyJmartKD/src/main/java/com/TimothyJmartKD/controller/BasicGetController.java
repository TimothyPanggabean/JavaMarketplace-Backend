/**
 * Class yang mengatur pengambilan data,
 * yaitu: page, id
 */
package com.TimothyJmartKD.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.TimothyJmartKD.Algorithm;
import com.TimothyJmartKD.Predicate;
import com.TimothyJmartKD.dbjson.JsonTable;
import com.TimothyJmartKD.dbjson.Serializable;

@RestController
public interface BasicGetController<T extends Serializable> {
    /**
     * Mengambil page dengan pagination
     * @param page nilai halaman tempat informasi disimpan
     * @param pageSize banyak entri dalam 1 halaman
     */
    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {
        Predicate<T> pred = element -> true;
        List<T> list = Algorithm.collect(getJsonTable(), pred);
        return Algorithm.<T>paginate(list, page, pageSize, pred);
    }

    /**
     * Mengambil data dengan id yang ditentukan
     * @param id id dari data yang ingin diakses
     */
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        Predicate<T> pred = element -> element.id == id;
        return Algorithm.find(getJsonTable().iterator(), pred);
    }

    public abstract JsonTable<T> getJsonTable(); /**Abstract class untuk mengambil tabel yang terkait*/
}