package TimothyJmartKD;
import java.lang.Iterable;
import java.util.*;

public class Algorithm
{
	private Algorithm()
	{
	}
	
	public static<T> List<T> collect(T[] array, T value)
	{
		List<T> list = new ArrayList<T>();
	    Collections.addAll(list, array);
	    Collections.addAll(list, value);
	    return (list);
	}
	
	public static<T> List<T> collect(Iterable<T> iterable, T value)
	{
		return null;
	}
	
	public static<T> List<T> collect(Iterator<T> iterator, T value)
	{
		return null;
	}
	
	public static<T> List<T> collect(T[] array, Predicate<T> pred)
	{
		return null;
	}
	
	public static<T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
	{
		return null;
	}
	
	public static<T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
	{
		return null;
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T> int count(T[] array, T value)
	{
		final Iterator<T> check = Arrays.stream(array).iterator();
        return count(check, value);
	}
	
	public static<T> int count(Iterable<T> iterable, T value)
	{
		final Iterator <T> check = iterable.iterator();
        return count(check, value);
	}
	
	public static<T> int count(Iterator<T> iterator, T value)
	{
		final Predicate <T> pred = value::equals;
        return count(iterator,pred);
	}
	
	public static<T> int count(T[] array, Predicate<T> pred)
	{
		final Iterator<T> check = Arrays.stream(array).iterator();
        return count(check, pred);
	}
	
	public static<T> int count(Iterable<T> iterable, Predicate<T> pred)
	{
		final Iterator<T> check = iterable.iterator();
        return count(check, pred);
	}
	
	public static<T> int count(Iterator<T> iterator, Predicate<T> pred)
	{
		return count(iterator, pred);
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T> boolean exists(T[] array, T value)
	{
		final Iterator<T> check = Arrays.stream(array).iterator();
        return exists(check, value);
	}
	
	public static<T> boolean exists(Iterable<T> iterable, T value)
	{
		final Iterator<T> check = iterable.iterator();
        return exists(check, value);
	}
	
	public static<T> boolean exists(Iterator<T> iterator, T value)
	{
		final Predicate <T> pred = value::equals;
        return exists(iterator,pred);
	}
	
	public static<T> boolean exists(T[] array, Predicate<T> pred)
	{
		final Iterator<T> check = Arrays.stream(array).iterator();
        return exists(check, pred);
	}
	
	public static<T> boolean exists(Iterable<T> iterable, Predicate<T> pred)
	{
		final Iterator <T> check = iterable.iterator();
        return exists(check, pred);
	}
	
	public static<T> boolean exists(Iterator<T> iterator, Predicate<T> pred)
	{
		return exists(iterator, pred);
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T> T find(T[] array, T value)
	{
		final Iterator<T> check = Arrays.stream(array).iterator();
        return find(check, value);
	}
	
	public static<T> T find(Iterable<T> iterable, T value)
	{
		final Iterator <T> check = iterable.iterator();
        return find(check, value);
	}
	
	public static<T> T find(Iterator<T> iterator, T value)
	{
		final Predicate <T> pred = value::equals;
        return find(iterator, pred);
	}
	
	public static<T> T find(T[] array, Predicate<T> pred)
	{
		final Iterator<T> check = Arrays.stream(array).iterator();
        return find(check, pred);
	}
	
	public static<T> T find(Iterable<T> iterable, Predicate<T> pred)
	{
		final Iterator <T> check = iterable.iterator();
        return find(check, pred);
	}
	
	public static<T> T find(Iterator<T> iterator, Predicate<T> pred)
	{
		return find(iterator, pred);
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T extends Comparable<? super T>> T max(T first, T second)
	{
		if(first.compareTo(second) > 0)
        {
            return first;
        }
        return second;
	}
	
	public static<T extends Comparable<? super T>> T max(T[] array)
	{
		return Collections.max(Arrays.asList(array));
	}
	
	public static<T extends Comparable<? super T>> T max(Iterable<T> iterable)
	{
		return null;
	}
	
	public static<T extends Comparable<? super T>> T max(Iterator<T> iterator)
	{
		return null;
	}
	
	public static<T> T max(T first, T second, Comparator<? super T> comparator)
	{
		return null;
	}
	
	public static<T> T max(T[] array, Comparator<? super T> comparator)
	{
		return null;
	}
	
	public static<T> T max(Iterable<T> iterable, Comparator<? super T> comparator)
	{
		return null;
	}
	
	public static<T> T max(Iterator<T> iterator, Comparator<? super T> comparator)
	{
		return null;
	}

//--------------------------------------------------------------------------------------

	public static<T extends Comparable<? super T>> T min(T first, T second)
	{
		if(first.compareTo(second) < 0)
        {
            return first;
        }
        return second;
	}
	
	public static<T extends Comparable<? super T>> T min(T[] array)
	{
		return Collections.min(Arrays.asList(array));
	}
	
	public static<T extends Comparable<? super T>> T min(Iterable<T> iterable)
	{
		return null;
	}
	
	public static<T extends Comparable<? super T>> T min(Iterator<T> iterator)
	{
		return null;
	}
	
	public static<T> T min(T first, T second, Comparator<? super T> comparator)
	{
		return null;
	}
	
	public static<T> T min(T[] array, Comparator<? super T> comparator)
	{
		return null;
	}
	
	public static<T> T min(Iterable<T> iterable, Comparator<? super T> comparator)
	{
		return null;
	}
	
	public static<T> T min(Iterator<T> iterator, Comparator<? super T> comparator)
	{
		return min(iterator, comparator);
	}
}