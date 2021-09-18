package TimothyJmartKD;


/**
 * Class PriceTag
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class PriceTag
{
    public static double COMMISSION_MULTIPLIER = 0.05;
    public static double BOTTOM_PRICE = 20000.0;
    public static double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;
        
    public PriceTag(double price)
    {
        this.price = price;
        discount = 0.0;
    }
    public PriceTag(double price, double discount)
    {
        this.price = price;
        this.discount = discount;
    }
    public double getAdjustedPrice()
    {
        return getDiscountedPrice() + getAdminFee();
    }
    public double getAdminFee()
    {
        if(getDiscountedPrice() != BOTTOM_PRICE) return BOTTOM_FEE;
        else return getDiscountedPrice() - (getDiscountedPrice() * COMMISSION_MULTIPLIER);
    }
    private double getDiscountedPrice()
    {
        if (discount > 100) discount = 100.0;
        if (discount == 100) return 0.0;
        return price = price - (price * discount/100);
    }
}
