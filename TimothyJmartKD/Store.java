package TimothyJmartKD;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static final String REGEX_PHONE =" ^[0-9]{9,12}\b";
    public static final String REGEX_NAME = "^[A-Z][a-z\\sa-z]{4,19}\b";
    
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
        "name: "+ name +
        "\naddress: "+ address +
        "\nphone Number: "+ phoneNumber;
    }
    
    public boolean validate()
    {
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matchPhone = patternPhone.matcher(phoneNumber);
        
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matchName = patternName.matcher(name);
        
        return matchPhone.find() && matchName.find();
    }
}