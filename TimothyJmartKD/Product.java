package TimothyJmartKD;


/**
 * Class Product
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Product
{
    private static int idCounter = -1;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    
    public Product(String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category)
    {
        idCounter++;
        this.id = idCounter; 
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }
}
