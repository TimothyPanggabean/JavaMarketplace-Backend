package TimothyJmartKD;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Class Complaint
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Complaint extends Recognizable implements FileParser
{
    public int paymentId;
    public String desc;
    public String date;

    public Complaint(int id, String desc)
    {
        super(id);
        this.desc = desc;
        Date date = new Date();
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
    
    public Object newInstance (String content)
    {
        return null;
    }
    
    public String toString()
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyy");
        return
        "Complaint{date=" + format.format(date) + ", desc=' " + desc + "'}";
    }
}
