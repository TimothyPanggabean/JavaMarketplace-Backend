package TimothyJmartKD;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Account
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Account extends Serializable
{
	public static final String REGEX_EMAIL="^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD="^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
    public double balance;
    public String email;
    public String name;
    public String password;
    public Store store;
    

    public Account(String name, String email, String password, double balance)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    
    public boolean validate()
    {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matchEmail = patternEmail.matcher(email);
        
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matchPassword = patternPassword.matcher(password);
        
        return matchEmail.find() && matchPassword.find();
    }
    
    public String toString() 
    {
    	return "name: "+ name + "\nemail: " + email + "\npassword: " + password;
    }
}
