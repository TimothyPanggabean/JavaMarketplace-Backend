package TimothyJmartKD;


/**
 * Class Store
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Store extends Recognizable implements FileParser
{
    public String name;
    public String address;
    public String phoneNumber;
    
    @Override
    public boolean read(String readTest)
    {
        return false;
    }
       
    public Store(int accountId, String name, String address, String phoneNumber)
    {
       super(accountId);
       this.name = name;
       this.address = address;
       this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber)
    {
       super(account.id);
       this.name = name;
       this.address = address;
       this.phoneNumber = phoneNumber;    
    }
    
    public String toString()
    {
        return
        "Name: "+ name +
        "\nAddress: "+ address +
        "\nPhone Number: "+ phoneNumber;
    }
}
