package TimothyJmartKD;


/**
 * Class Store
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Store extends Recognizable implements FileParser
{
    @Override
    public boolean read(String readTest)
    {
        return false;
    }
    
    @Override
    public Object write()
    {
        return null;
    }
    
    @Override
    public Object newInstance(String newInstanceTest)
    {
        return null;
    }
    public String name;
    public String address;
    public String phoneNumber;
       
    public Store(int accountId, String name, String address, String phoneNumber)
    {
       super(accountId);
       this.name = name;
       this.address = address;
       this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber)
    {
       super(accountId);
       this.name = name;
       this.address = address;
       this.phoneNumber = phoneNumber;    
    }
}
