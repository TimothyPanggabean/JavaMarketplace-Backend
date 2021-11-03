package TimothyJmartKD;


/**
 * Class Product
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Product extends Recognizable
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
        "\nshipmentPlans"+ shipmentPlans;
    }
    
}