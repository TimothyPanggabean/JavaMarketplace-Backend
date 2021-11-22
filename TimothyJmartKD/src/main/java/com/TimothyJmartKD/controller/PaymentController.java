package com.TimothyJmartKD.controller;

import com.TimothyJmartKD.ObjectPoolThread;
import com.TimothyJmartKD.Payment;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    public static long DELIVERED_LIMIT_MS = 200;
    public static long ON_DELIVERY_LIMIT_MS = 300;
    public static long ON_PROGRESS_LIMIT_MS = 300;
    public static long WAITING_CONF_LIMIT_MS = 200;

    @JsonAutowired(filepath = "C:/Users/Timothy/Desktop/Kuliah/Semester 5/OOP/Praktikum/Modul 8", value = Payment.class)
    public static JsonTable<Payment> paymentTable;

    public static ObjectPoolThread<Payment> poolThread;

    @PostMapping("/{id}/accept")
    boolean accept(int id) { return false; }

    @PostMapping("/{id}/cancel")
    boolean cancel(int id)
    {
        return false;
    }

    @PostMapping("/create")
    Payment create(int buyerId, int productId, String shipmentAddress, byte shipmentPlan)
    {
       return null;
    }

    public JsonTable<Payment> getJsonTable()
    {
        return paymentTable;
    }

    @PostMapping("/{id}/submit")
    boolean submit(int id, String receipt)
    {
        return false;
    }

    private static boolean timekeeper (Payment payment)
    {
        return false;
    }
}