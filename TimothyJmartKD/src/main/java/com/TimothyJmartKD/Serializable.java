package com.TimothyJmartKD;

import java.util.HashMap;

/**
 * Abstract class Serializable
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    
    protected Serializable()
    {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }
    
    public boolean equals(Object other)
    {
        if (other instanceof Serializable)
        {
            Serializable newobject = (Serializable)other;
            if(newobject.id == id) return true;
            else return false;
        }
        return false;
    }
    
    public boolean equals(Serializable other)
    {
        return id == other.id;
    }
    
    public static<T extends Serializable> Integer setClosingId(Class<T> clazz, int id) 
    {
    	return mapCounter.put(clazz, id);
    }
    
    public static<T extends Serializable> Integer getClosingId(Class<T> clazz)
    {
    	return mapCounter.get(clazz);
    }
    
    @Override
    public int compareTo(Serializable other) {
        if (this.id == other.id) {
            return 0;
        } else if (this.id > other.id) {
            return 1;
        } else {
            return -1;
        }
    }
    
   
}