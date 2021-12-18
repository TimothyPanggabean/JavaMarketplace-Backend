package com.TimothyJmartKD;


import com.TimothyJmartKD.dbjson.Serializable;

/**
 * Class Product
 * isi: constructor untuk inisiasi dan toString untuk menampilkan data (yang digunakan yang punya front end)
 */
public class Product extends Serializable
{
	public int accountId;
	public ProductCategory category;
	public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;
   
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
        this.accountId = accountId; 
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
    
    public String toString()
    {
        return
                "Name: "+ name +
                "\nWeight: "+ weight +
                "\nconditionUsed: "+ conditionUsed +
                "\nprice: "+ price +
                "\ndiscount: "+ discount +
                "\ncategory: "+ category +
                "\nshipmentPlans: "+ shipmentPlans;
    }
    
}