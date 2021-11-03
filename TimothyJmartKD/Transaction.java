package TimothyJmartKD;


/**
 * Class Transaction
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public abstract class Transaction extends Recognizable
{
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating;
    
    public static enum Rating
    {
        NONE, BAD, NEUTRAL, GOOD
    }
    
    protected Transaction (int buyerId, int storeId)
    {
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    protected Transaction (Account buyer, Store store)
    {
        buyerId = buyer.id;
        storeId = store.id;
    }
    
    public abstract boolean validate();
    
    public abstract Transaction perform();
}
