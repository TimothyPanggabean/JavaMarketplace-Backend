package TimothyJmartKD;


/**
 * Class Payment
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Payment extends Invoice
{
    public Shipment shipment;
    public int productCount;
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(buyerId,productId);
        this.productCount = productCount;
        this.shipment = shipment;
        
    }
    
    public double getTotalPay()
    {
    	return 0;
    }
}
