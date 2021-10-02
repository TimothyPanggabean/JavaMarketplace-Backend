package TimothyJmartKD;
import java.util.ArrayList;


/**
 * Class Filter
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Filter
{
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less) {
        ArrayList<PriceTag> arrList = new ArrayList<PriceTag>();
        if(less) 
        {
            for(PriceTag s : list) 
            {
                if(s.getAdjustedPrice() < value)arrList.add(s);
            }
        }
        
        else {
            for(PriceTag s : list) 
            {
                if(s.getAdjustedPrice() >= value)arrList.add(s);
            }
        }
        return arrList;
    }
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less) {
        if(less) 
        {
            for(int i = 0; i < list.size(); i++) 
            {
                if(list.get(i).getAverage() < value)list.remove(i);
            }
        }
        
        else 
        {
            for(int i = 0; i < list.size(); i++) 
            {
                if(list.get(i).getAverage() >= value)list.remove(i);
            }
        }
    }
}
