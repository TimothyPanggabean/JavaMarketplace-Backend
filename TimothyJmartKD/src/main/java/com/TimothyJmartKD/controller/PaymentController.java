package com.TimothyJmartKD.controller;

import com.TimothyJmartKD.*;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import static com.TimothyJmartKD.controller.AccountController.accountTable;
import static com.TimothyJmartKD.controller.ProductController.productTable;

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
    boolean accept(@PathVariable int id)
    {
        Predicate<Payment> findPayment = paymentFound -> paymentFound.id == id;
        Algorithm.find(paymentTable, findPayment);
        Payment payment = Algorithm.find(paymentTable, findPayment);

        if(Algorithm.exists(paymentTable, findPayment) && payment.history.get(payment.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION)
        {
            payment.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "On Progress"));
            return true;
        }
        else
        {
            return false;
        }
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id)
    {
        Predicate<Payment> findPayment = paymentFound -> paymentFound.id == id;
        Algorithm.find(paymentTable, findPayment);
        Payment payment = Algorithm.find(paymentTable, findPayment);

        if(Algorithm.exists(paymentTable, findPayment) &&
                payment.history.get(payment.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @PostMapping("/create")
    Payment create (@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount,
                    @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan)
    {
        Predicate<Account> findAccount = accFind -> accFind.id == buyerId;
        Predicate<Product> findProduct = prodFind -> prodFind.id == productId;

        Product product = Algorithm.find(productTable, findProduct);
        Account account = Algorithm.find(accountTable, findAccount);
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> product.id == buyerId && account.id == buyerId);

        Shipment shipment = new Shipment(shipmentAddress, 0, shipmentPlan, null);
        payment.shipment = shipment;

        if(Algorithm.<Account>exists(accountTable, findAccount) && Algorithm.exists(productTable, findProduct)
            && account.balance >= product.price * productCount)
        {
            account.balance -= payment.getTotalPay(product) * productCount;
            payment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "Waiting for Comfirmation"));
            getJsonTable().add(payment);
            poolThread.add(payment);
        }
        else
        {
            return null;
        }
        return payment;
    }

    public JsonTable<Payment> getJsonTable()
    {
        return paymentTable;
    }

    @PostMapping("/{id}/submit")
    boolean submit(@PathVariable int id, @RequestParam String receipt)
    {
        Predicate<Payment> findPayment = paymentFound -> paymentFound.id == id;
        Algorithm.find(paymentTable, findPayment);
        Payment payment = Algorithm.find(paymentTable, findPayment);

        if (Algorithm.exists(paymentTable, findPayment) &&
                payment.history.get(payment.history.size()-1).status == Invoice.Status.ON_PROGRESS &&
                !payment.shipment.receipt.isBlank())
        {
            payment.shipment.receipt = receipt;
            payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "On Delivery"));
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean paymentTimekeeper(Payment payment)
    {
        long elapsedTime = (new java.util.Date()).getTime() - payment.history.get(payment.history.size()-1).date.getTime();

        if(payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.WAITING_CONFIRMATION) && elapsedTime > WAITING_CONF_LIMIT_MS)
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Transaction Failed"));

        else if(payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.ON_PROGRESS) && elapsedTime > ON_PROGRESS_LIMIT_MS)
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Transaction Failed"));

        else if(payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.ON_DELIVERY) && elapsedTime > ON_DELIVERY_LIMIT_MS)
            payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "Package has been delivered"));

        else if(payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.DELIVERED) && elapsedTime > DELIVERED_LIMIT_MS)
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "Payment has been finished"));

        for(Payment.Record element: payment.history) {
            if(element.status == Invoice.Status.FINISHED || element.status == Invoice.Status.FAILED) payment.history.remove(element);
        }

        return payment.history.isEmpty();
    }
}