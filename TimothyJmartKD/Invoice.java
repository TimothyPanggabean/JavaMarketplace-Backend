package TimothyJmartKD;
import java.util.Date;

/**
 * Class Invoice
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    
    protected Invoice(int id, int buyerId, int productId)
    {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        Date date = new Date();
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    
    public boolean read(String content)
    {
        return false;
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
}
