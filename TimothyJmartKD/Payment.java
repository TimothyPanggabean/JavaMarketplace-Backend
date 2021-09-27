package TimothyJmartKD;


/**
 * Class Payment
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Payment extends Invoice implements Transactor
{
    public Shipment shipment;
    public int productCount;
    
    @Override
    public double getTotalPay()
    {
        return 0.0;
    }
    
    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
        
    }
    
    public boolean validate()
    {
        return false;
    }
    
    public Invoice perform()
    {
        return null;
    }
}
