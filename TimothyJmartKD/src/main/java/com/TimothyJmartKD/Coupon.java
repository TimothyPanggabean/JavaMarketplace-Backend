package com.TimothyJmartKD;


import com.TimothyJmartKD.dbjson.Serializable;

/**
 * Class Coupon
 * isi: constructor untuk inisiasi dan sistem apply
 * tidak diimplementasi di program akhir
 */
public class Coupon extends Serializable
{
    public final int code;
    public final double cut;
    public final double minimum;
    public final String name;
    public final Type type;
    private boolean used; 
    
    public static enum Type
    {
        DISCOUNT, REBATE;
    }
    
    public Coupon(String name, int code, Type type, double cut, double minimum)
    {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }

    public boolean isUsed()
    {
        return used;
    }
    
    public boolean canApply(double price, double discount)
    {
        if (Treasury.getAdjustedPrice(price, discount) >= minimum && used == false ) return true;
        else return false;
    }

    public double apply(double price, double discount)
    {
        used = true;
        if (type == Type.DISCOUNT) return Treasury.getAdjustedPrice(price, discount) - (Treasury.getAdjustedPrice(price, discount) * cut/100);
        else if(type == Type.REBATE) return Treasury.getAdjustedPrice(price, discount) - cut;
        else return 0;
    }
}
