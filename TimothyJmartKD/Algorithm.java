package TimothyJmartKD;
import java.lang.Iterable;
import java.util.*;

public class Algorithm
{
	private Algorithm()
	{
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T> int count(T[] array, T value)
	{
		return 0;
	}
	
	public static<T> int count(Iterable<T> iterable, T value)
	{
		return 0;
	}
	
	public static<T> int count(Iterator<T> iterator, T value)
	{
		return 0;
	}
	
	public static<T> int count(T[] array, Predicate<T> pred)
	{
		return 0;
	}
	
	public static<T> int count(Iterable<T> iterable, Predicate<T> pred)
	{
		return 0;
	}
	
	public static<T> int count(Iterator<T> iterator, Predicate<T> pred)
	{
		return 0;
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T> boolean exists(T[] array, T value)
	{
		return false;
	}
	
	public static<T> boolean exists(Iterable<T> iterable, T value)
	{
		return false;
	}
	
	public static<T> boolean exists(Iterator<T> iterator, T value)
	{
		return false;
	}
	
	public static<T> boolean exists(T[] array, Predicate<T> pred)
	{
		return false;
	}
	
	public static<T> boolean exists(Iterable<T> iterable, Predicate<T> pred)
	{
		return false;
	}
	
	public static<T> boolean exists(Iterator<T> iterator, Predicate<T> pred)
	{
		return false;
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T> T find(T[] array, T value)
	{
		return null;
	}
	
	public static<T> T find(Iterable<T> iterable, T value)
	{
		return null;
	}
	
	public static<T> T find(Iterator<T> iterator, T value)
	{
		return null;
	}
	
	public static<T> T find(T[] array, Predicate<T> pred)
	{
		return null;
	}
	
	public static<T> T find(Iterable<T> iterable, Predicate<T> pred)
	{
		return null;
	}
	
	public static<T> T find(Iterator<T> iterator, Predicate<T> pred)
	{
		return null;
	}
	
//--------------------------------------------------------------------------------------
	
	public <T extends Comparable<? super T>> T max(T first, T  second)
    {
        if(first.compareTo(second) > 0)
        {
            return first;
        }
        return second;
    }
	
	public <T extends Comparable<? super T>> T min(T  first, T  second)
    {
        if(first.compareTo(second) < 0)
        {
            return first;
        }
        return second;
    }
}