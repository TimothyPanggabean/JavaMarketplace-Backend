package TimothyJmartKD;

/**
 * Warm-Up Program
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Jmart
{
    public static void main(String[] args)
    {
        
    }

    public int getPromo()
    {
       return 0;
    }
    
    public String getCustomer()
    {
        return "oop";
    }
    
    public float getDiscountPercentage(int before, int after)
    {
        float persenDiskon;
        
        if (before>after)
        {
            persenDiskon = before - after;
            persenDiskon = (persenDiskon * 100) / before;
        }
        else
        {
            persenDiskon = 0;
        }
        return persenDiskon;
    }
     
    public float DiscountedPrice(int price, float discountPercentage)
    {
       return 0;
    }
    
}