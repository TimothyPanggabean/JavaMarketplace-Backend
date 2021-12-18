package com.TimothyJmartKD;

import java.util.*;

/**
 * Class Payment
 * isi: constructor untuk inisiasi, mengambil harga total dari sebuah transaksi, dan mengisi record
 *
 */
public class Payment extends Invoice
{
    public Shipment shipment;
    public int productCount;
    
    public ArrayList<Record> history = new ArrayList<>();
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(buyerId,productId);
        this.productCount = productCount;
        this.shipment = shipment;   
    }

    /**
     * Mengambil harga total yang akan dibayar
     * @param product produk dalam transaksi
     */
    public double getTotalPay(Product product)
    {
    	return product.price - (product.price * product.discount/100);
    }
    
    public static class Record
    {
    	public final Date date;
    	public String message;
    	public Status status;
    	
    	public Record(Status status, String message)
    	{
    		date = new Date();
            this.status = status;
            this.message = message;
    	}
    }
}