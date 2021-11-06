package TimothyJmartKD;
import java.util.Date;
import java.util.ArrayList;

/**
 * Class Invoice
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public abstract class Invoice extends Serializable
{
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history;
    
    protected Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
    }
    
    public abstract double getTotalPay();
    
    public static enum Status
    {
       WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY,
       COMPLAINT, FINISHED, FAILED;
    }
       
    public static enum Rating
    {   
        NONE, BAD, NEUTRAL, GOOD;
    }
    
    public class Record
    {
        public Status status;
        public Date date;
        public String message;
        
    }
}
