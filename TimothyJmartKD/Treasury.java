package TimothyJmartKD;


/**
 * Class PriceTag
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Treasury
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;
    
    public double getAdjustedPrice(double price, double discount)
    {
        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }
    public double getAdminFee(double price, double discount)
    {
        if(getDiscountedPrice(price, discount) <= BOTTOM_PRICE) return BOTTOM_FEE;
        else return (getDiscountedPrice(price, discount) * COMMISSION_MULTIPLIER);
    }
    private double getDiscountedPrice(double price, double discount)
    {
        if (discount > 100.0) discount = 100.0;
        if (discount == 100.0) return 0.0;
        return price = price - (price * discount/100);
    }
}