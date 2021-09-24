package TimothyJmartKD;

/**
 * Class Jmart
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Jmart
{
    public static void main(String[] args)
    {
        
    }
    
    public static Product create()
    {
        Product test = new Product("test", 68, false, new PriceTag(419), ProductCategory.MISCELLANEOUS);
        return test;
    }
    
    public static Product createProduct()
    {
        Product testProduct = new Product("test product", 70, true, new PriceTag(421), ProductCategory.MISCELLANEOUS);
        return testProduct;
    }
    
    
    public static Coupon createCoupon()
    {
        Coupon diskonNatal = new Coupon("75% discount", 25, Coupon.Type.DISCOUNT, 75, 100000);
        return diskonNatal;
    }
    
    public static ShipmentDuration createShipmentDuration()
    {
        ShipmentDuration express = new ShipmentDuration(ShipmentDuration.SAME_DAY, ShipmentDuration.KARGO);
        return express;
    }
    
    /*
    public static int getPromo()
    {
       return 0;
    }
    
    public static String getCustomer()
    {
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after)
    {
        float DiscountPercentage;
        
        if (before>after)
        {
            DiscountPercentage = before - after;
            DiscountPercentage = (DiscountPercentage * 100) / before;
        }
        else
        {
            DiscountPercentage = 0;
        }
        return DiscountPercentage;
    }
     
    public static int getDiscountedPrice(int price, float discountPercentage)
    {
        int DiscountedPrice;
      if(discountPercentage > 100.0f) 
        {
            return 100;
        }
        else 
        {
            return (int)(price - (price * discountPercentage / 100));
        }
    }
    
     public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
       return (int)(discountedPrice / (discountPercentage / 100));
    }
    
     public static float getCommissionMultiplier()
    {
       return 0.05f;
    }
    
     public static int getAdjustedPrice(int price)
    {
       int sementara, AdjustedPrice;
       
       sementara = (int)(price * getCommissionMultiplier());
       AdjustedPrice = price + sementara;
       return AdjustedPrice;
    }
    
     public static int getAdminFee(int price)
    {
       return (int)(price * getCommissionMultiplier());
    }*/
    
}