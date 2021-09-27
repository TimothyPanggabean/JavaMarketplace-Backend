package TimothyJmartKD;


/**
 * Interface FileParser
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public interface FileParser
{
    public boolean read(String readTest);
    
    default Object write()
    {
        return null;
    }
    
    public static Object newInstance(String content)
    {
        return null;   
    }
}
