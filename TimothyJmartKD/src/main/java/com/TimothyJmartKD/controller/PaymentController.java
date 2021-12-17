/**
 * Class yang mengatur semua hal yang berkaitan dengan pembayaran,
 * yaitu: accept, cancel, create, dan submit
 */
package com.TimothyJmartKD.controller;

import com.TimothyJmartKD.*;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import static com.TimothyJmartKD.controller.AccountController.accountTable;
import static com.TimothyJmartKD.controller.ProductController.productTable;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    public static long DELIVERED_LIMIT_MS = 200;
    public static long ON_DELIVERY_LIMIT_MS = 300;
    public static long ON_PROGRESS_LIMIT_MS = 300;
    public static long WAITING_CONF_LIMIT_MS = 200;

    @JsonAutowired(filepath = "C:/Users/Timothy/Desktop/Kuliah/Semester_5/OOP/Praktikum/Modul 9/paymentTable.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;

    public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<>(PaymentController::paymentTimekeeper);

    /**
     * Menerima pesanan dan menunggu pembayaran
     * @param id id dari transaksi yang dilakukan
     */
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

    /**
     * Membatalkan pembayaran
     * @param id id dari transaksi yang dilakukan
     */
    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id)
    {
        Predicate<Payment> findPayment = paymentFound -> paymentFound.id == id;
        Algorithm.find(paymentTable, findPayment);
        Payment payment = Algorithm.find(paymentTable, findPayment);

        if(Algorithm.exists(paymentTable, findPayment) &&
                payment.history.get(payment.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION)
        {
            payment.history.add(new Payment.Record(Invoice.Status.CANCELLED, "Cancelled"));
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Melakukan pembayaran
     * @param buyerId id dari akun yang membayar
     * @param productId id dari produk yang dibeli
     * @param productCount jumlah produk yang dibeli
     * @param shipmentAddress alamat pembeli
     * @param shipmentPlan jenis pengiriman produk
     */
    @PostMapping("/create")
    Payment create (@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount,
            @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan)
    {
        Payment pay = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
        Account acc = Algorithm.<Account>find(AccountController.accountTable,
                account -> account.id == buyerId);
        Product prod = Algorithm.<Product>find(ProductController.productTable,
                product -> product.id == productId);
        if(Algorithm.<Account>exists(AccountController.accountTable, acc)
                && Algorithm.<Product>exists(ProductController.productTable, prod)
                && pay.getTotalPay(prod) <= acc.balance && pay.shipment.cost == 0 && pay.shipment.receipt == null) {
            acc.balance -= pay.getTotalPay(prod) * productCount;
            pay.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "Waiting for confirmation"));
            getJsonTable().add(pay);
            poolThread.add(pay);
            return pay;
        }
        return null;
    }

    public JsonTable<Payment> getJsonTable()
    {
        return paymentTable;
    }

    /**
     * Mengirimkan pembayaran dan memulai pengiriman
     * @param id id dari transaksi yang dilakukan
     * @param receipt struk yang dihasilkan
     */
    @PostMapping("/{id}/submit")
    boolean submit(@PathVariable int id, @RequestParam String receipt)
    {
        Predicate<Payment> findPayment = paymentFound -> paymentFound.id == id;
        Algorithm.find(paymentTable, findPayment);
        Payment payment = Algorithm.find(paymentTable, findPayment);

        if (Algorithm.exists(paymentTable, findPayment) &&
                payment.history.get(payment.history.size()-1).status == Invoice.Status.ON_PROGRESS &&
                !receipt.isBlank())
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

    /**
     * Mengubah status pembayaran ketika selesai dilakukan
     * @param payment pembayaran yang dilakukan
     */
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