package com.TimothyJmartKD;
import java.util.Date;
import java.util.ArrayList;

/**
 * Class Invoice
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public abstract class Invoice extends Serializable
{
    public final Date date = new Date();
    public int buyerId;
    public int productId;
    public int complaintId = -1;
    public Rating rating = Rating.NONE;
    
    protected Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
    }
    
    public abstract double getTotalPay(Product product);
    
    public static enum Status
    {
       CANCELLED, COMPLAINT, DELIVERED, FAILED, FINISHED, 
       ON_DELIVERY, ON_PROGRESS, WAITING_CONFIRMATION;
    }
       
    public static enum Rating
    {   
        NONE, BAD, NEUTRAL, GOOD;
    }
}
