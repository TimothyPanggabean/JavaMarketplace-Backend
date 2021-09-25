package TimothyJmartKD;


/**
 * Interface FileParser
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public interface FileParser
{
    boolean read(String readTest);
    default Object write()
    {
        return null;
    }
    Object newInstance(String newInstanceTest);
}
