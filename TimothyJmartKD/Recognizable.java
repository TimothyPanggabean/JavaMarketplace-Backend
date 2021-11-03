package TimothyJmartKD;


/**
 * Abstract class Recognizable
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Recognizable implements Comparable<Recognizable>
{
    public final int id;
    
    protected Recognizable()
    {
        this.id = 3;
    }
    
    public boolean equals(Object object)
    {
        if (object instanceof Recognizable)
        {
            Recognizable newobject = (Recognizable)object;
            if(newobject.id == id) return true;
            else return false;
        }
        return false;
    }
    
    public boolean equals(Recognizable recognizable)
    {
        return id == recognizable.id;
    }
    
    public static<T extends Recognizable> int setClosingId(Class<T> clazz, int id) 
    {
    	return 0;
    }
    
    public static<T extends Recognizable> int getClosingId(Class<T> clazz)
    {
    	return 0;
    }
    
    public int compareTo(Recognizable recognizable) {
        if (this.id == recognizable.id) {
            return 0;
        } else if (this.id > recognizable.id) {
            return 1;
        } else {
            return -1;
        }
    }
    
   
}