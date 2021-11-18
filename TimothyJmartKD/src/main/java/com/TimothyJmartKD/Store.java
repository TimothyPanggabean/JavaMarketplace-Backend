package com.TimothyJmartKD;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Store
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Store
{
    public String name;
    public String address;
    public String phoneNumber;
    public static final String REGEX_PHONE =" ^[0-9]{9,12}\b";
    public static final String REGEX_NAME = "^[A-Z][a-z\\sa-z]{4,19}\b";
    public double balance;
       
    public Store(String name, String address, String phoneNumber,double balance)
    {
       this.name = name;
       this.address = address;
       this.phoneNumber = phoneNumber;
       this.balance = balance;
    }
    
    public String toString()
    {
        return
        "name: "+ name +
        "\naddress: "+ address +
        "\nphone Number: "+ phoneNumber +
        "\nbalance: "+ balance;
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