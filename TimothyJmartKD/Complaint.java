package TimothyJmartKD;


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
        this.date = "Hari ini";
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
    
    public Object newInstance (String content)
    {
        return null;
    }
}
