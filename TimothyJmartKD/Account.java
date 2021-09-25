package TimothyJmartKD;


/**
 * Class Account
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Account extends Recognizable implements FileParser
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
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
