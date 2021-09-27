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
    
    protected Transaction (int id, int buyerId, int storeId)
    {
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    protected Transaction (int id, Account buyer, Store store)
    {
        super(id);
        buyerId = buyer.id;
        storeId = store.id;
    }
    
    public abstract boolean validate();
    
    public abstract Transaction perform();
}
