package TimothyJmartKD;


/**
 * Abstract class Recognizable
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public abstract class Recognizable
{
    public final int id;
    
    protected Recognizable(int id)
    {
        this.id = id;
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
}