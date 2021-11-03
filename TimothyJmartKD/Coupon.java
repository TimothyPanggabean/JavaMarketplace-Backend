package TimothyJmartKD;


/**
 * Class Coupon
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Coupon extends Recognizable
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
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
    
    public boolean canApply(Treasury priceTag)
    {
        if (priceTag.getAdjustedPrice(priceTag.price, priceTag.discount) >= minimum && used == false ) return true;
        else return false;
    }

    public double apply(Treasury priceTag)
    {
        used = true;
        if (type == Type.DISCOUNT) return priceTag.getAdjustedPrice(priceTag.price, priceTag.discount) - (priceTag.getAdjustedPrice(priceTag.price, priceTag.discount) * cut/100);
        else if(type == Type.REBATE) return priceTag.getAdjustedPrice(priceTag.price, priceTag.discount) - cut;
        else return 0;
    }
}
