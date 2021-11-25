package com.TimothyJmartKD;

import java.lang.Iterable;
import java.util.*;

public class Algorithm
{

	private Algorithm()
	{
	}

	public static<T> List<T> collect(T[] array, T value)
	{
		Predicate<T> pred = val -> val.equals(value);
        List<T> list = new ArrayList<>();
        for (T index : array) 
        {
            if (pred.predicate(index)) 
            {
                list.add(index);
            }
        }
        return list;
	}
	
	public static<T> List<T> collect(Iterable<T> iterable, T value)
	{
		Predicate<T> pred = val -> val.equals(value);
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = iterable.iterator();

        while (iterator.hasNext()) 
        {
            T index = iterator.next();
            if (pred.predicate(index)) 
            {
                list.add(index);
            }
        }
        return list;
	}
	
	public static<T> List<T> collect(Iterator<T> iterator, T value)
	{
		Predicate<T> pred = val -> val.equals(value);
        List<T> list = new ArrayList<>();

        while (iterator.hasNext()) 
        {
            T index = iterator.next();
            if (pred.predicate(index)) 
            {
                list.add(index);
            }
        }
        return list;
	}
	
	public static<T> List<T> collect(T[] array, Predicate<T> pred)
	{
		List<T> list = new ArrayList<>();
        for (T index : array) 
        {
            if (pred.predicate(index)) 
            {
                list.add(index);
            }
        }
        return list;
	}
	
	public static<T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
	{
		List<T> list = new ArrayList<>();
        Iterator<T> iterator = iterable.iterator();

        while (iterator.hasNext()) 
        {
            T index = iterator.next();
            if (pred.predicate(index)) 
            {
                list.add(index);
            }
        }
        return list;
	}
	
	public static<T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
	{
		List<T> list = new ArrayList<>();
		while (iterator.hasNext()) 
		{
            T index = iterator.next();
            if (pred.predicate(index)) 
            {
                list.add(index);
            }
        }
        return list;
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T> int count(T[] array, T value)
	{
		int cnt = 0;
        Predicate<T> x = val -> (val == value);
        for (T s : array) 
        {
            if (x.predicate(s)) 
            {
                cnt++;
            }
        }
        return cnt;
	}
	
	public static<T> int count(Iterable<T> iterable, T value)
	{
		int cnt = 0;
        Predicate<T> x = val -> (val == value);
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(x.predicate(index))
            {
                cnt++;
            }
        }
        return cnt;
	}
	
	public static<T> int count(Iterator<T> iterator, T value)
	{
		int cnt = 0;
        Predicate<T> x = val -> (val == value);
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(x.predicate(index))
            {
                cnt++;
            }
        }
        return cnt;
	}
	
	public static<T> int count(T[] array, Predicate<T> pred)
	{
		int cnt = 0;
        for (T s : array) 
        {
            if (pred.predicate(s)) 
            {
                cnt++;
            }
        }
        return cnt;
	}
	
	public static<T> int count(Iterable<T> iterable, Predicate<T> pred)
	{
		int cnt = 0;
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                cnt++;
            }
        }
        return cnt;
	}
	
	public static<T> int count(Iterator<T> iterator, Predicate<T> pred)
	{
		int cnt = 0;
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                cnt++;
            }
        }
        return cnt;
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T> boolean exists(T[] array, T value)
	{
		Predicate<T> pred = val -> (val == value);
        for (T s : array) {
            if (pred.predicate(s)) 
            {
                return true;
            }
        }
        return false;
	}
	
	public static<T> boolean exists(Iterable<T> iterable, T value)
	{
		Predicate<T> pred = val -> (val == value);
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                return true;
            }
        }
        return false;
	}
	
	public static<T> boolean exists(Iterator<T> iterator, T value)
	{
		Predicate<T> pred = val -> (val == value);
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                return true;
            }
        }
        return false;
	}
	
	public static<T> boolean exists(T[] array, Predicate<T> pred)
	{
		for (T s : array) 
		{
            if (pred.predicate(s)) 
            {
                return true;
            }
        }
        return false;
	}
	
	public static<T> boolean exists(Iterable<T> iterable, Predicate<T> pred)
	{
		Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                return true;
            }
        }
        return false;
	}
	
	public static<T> boolean exists(Iterator<T> iterator, Predicate<T> pred)
	{
		while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                return true;
            }
        }
        return false;
	}
	
//--------------------------------------------------------------------------------------
	
	public static<T> T find(T[] array, T value)
	{
		Predicate<T> pred = val -> (val == value);
        for (T s : array) {
            if (pred.predicate(s)) 
            {
                return s;
            }
        }
        return null;
	}
	
	public static<T> T find(Iterable<T> iterable, T value)
	{
		Predicate<T> pred = val -> (val == value);
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                return index;
            }
        }
        return null;
	}
	
	public static<T> T find(Iterator<T> iterator, T value)
	{
		Predicate<T> pred = val -> (val == value);
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                return index;
            }
        }
        return null;
	}
	
	public static<T> T find(T[] array, Predicate<T> pred)
	{
		for (T s : array) 
		{
            if (pred.predicate(s)) 
            {
                return s;
            }
        }
        return null;
	}
	
	public static<T> T find(Iterable<T> iterable, Predicate<T> pred)
	{
		Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                return index;
            }
        }
        return null;
	}
	
	public static<T> T find(Iterator<T> iterator, Predicate<T> pred)
	{
		while(iterator.hasNext())
        {
            T index = iterator.next();
            if(pred.predicate(index))
            {
                return index;
            }
        }
        return null;
	}
	
//--------------------------------------------------------------------------------------
	
	public static  <T extends Comparable<? super T>> T max(T first, T  second)
    {
        if(first.compareTo(second) > 0)
        {
            return first;
        }
        return second;
    }

    public static  <T extends Comparable<? super T>> T max(T[] array){
        T maximum = null;
        for (T s : array) {
            if (maximum == null) maximum = s;
            else if (s.compareTo(maximum) > 0) 
            {
                maximum = s;
            }
        }
        return maximum;

    }

    public static  <T extends Comparable<? super T>> T max(Iterable<T> iterable){
        T maximum = null;
        for (T index : iterable) {
            if (maximum == null){
                maximum = index;
            }
            else if (index.compareTo(maximum) > 0)
            {
                maximum = index;
            }
        }
        return maximum;
    }

    public static  <T extends Comparable<? super T>> T max(Iterator<T> iterator){
        T maximum = null;
        while (iterator.hasNext()) {
            T index = iterator.next();
            if (maximum == null){
                maximum = index;
            }
            else if (index.compareTo(maximum) > 0)
            {
                maximum = index;
            }
        }
        return maximum;
    }

    public static  <T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator){
        int Comp = comparator.compare(first, second);
        if(Comp > 0) 
        {
            return first;
        }
        else 
        {
            return second;
        }
    }

    public static  <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator){
        T maximum = array[0];
        for(int i = 0; i < array.length; i++)
        {
            int Comp = comparator.compare(array[i], maximum);
            if(Comp > 0)
            {
                maximum = array[i];
            }
        }
        return maximum;
    }

    public <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator){
        Iterator<T> iterator = iterable.iterator();
        T maximum = iterator.next();
        while(iterator.hasNext())
        {
            T index = iterator.next();
            int Comp = comparator.compare(index, maximum);
            if(Comp > 0)
            {
                maximum = index;
            }
        }
        return maximum;
    }

    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator){
        T maximum = iterator.next();
        while(iterator.hasNext())
        {
            T index = iterator.next();
            int Comp = comparator.compare(index, maximum);
            if(Comp > 0)
            {
                maximum = index;
            }
        }
        return maximum;
    }

 //--------------------------------------------------------------------------------------

    public static  <T extends Comparable<? super T>> T min(T  first, T  second)
    {
        if(first.compareTo(second) < 0)
        {
            return first;
        }
        return second;
    }
    
    public static  <T extends Comparable<? super T>> T min(T[] array){
        T minimum = null;
        for (T index : array) 
        {
            if (minimum == null) 
            {
                minimum = index;
            }
            else if (index.compareTo(minimum) < 0) 
            {
                minimum = index;
            }
        }
        return minimum;
    }

    public static  <T extends Comparable<? super T>> T min(Iterable<T> iterable){
        T minimum = null;
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) 
        {
            T index = iterator.next();
            if (minimum == null)
            {
                minimum = index;
            }
            else if (index.compareTo(minimum) < 0)
            {
                minimum = index;
            }
        }
        return minimum;
    }

    public static  <T extends Comparable<? super T>> T min(Iterator<T> iterator){
        T minimum = null;
        while (iterator.hasNext()) 
        {
            T index = iterator.next();
            if (minimum == null) 
            {
                minimum = index;
            }
            else if (index.compareTo(minimum) < 0) 
            {
                minimum = index;
            }
        }
        return minimum;
    }

    public static  <T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator){
        int Comp = comparator.compare(first, second);
        if (Comp < 0) 
        {
            return first;
        } 
        else 
        {
            return second;
        }
    }

    public static  <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator){
        T minimum = null;
        for (T index : array) 
        {
            if (minimum == null)
            {
                minimum = index;
            }
            else 
            {
                int Comp = comparator.compare(index, minimum);
                if (Comp < 0)
                {
                    minimum = index;
                }
            }
        }
        return minimum;
    }

    public static  <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator){
        T minimum = null;
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) 
        {
            T index = iterator.next();
            if (minimum == null) 
            {
                minimum = index;
            }
            else 
            {
                int compare = comparator.compare(index, minimum);
                if (compare < 0) 
                {
                    minimum = index;
                }
            }
        }
        return minimum;
    }

    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator){
        T minimum = null;
        while (iterator.hasNext()) 
        {
            T index = iterator.next();
            if (minimum == null) 
            {
                minimum = index;
            }
            else 
            {
                int compare = comparator.compare(index, minimum);
                if (compare < 0)
                {
                    minimum = index;
                }
            }
        }
        return minimum;
    }
    
  //--------------------------------------------------------------------------------------
    
    public static<T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred)
    {
		List<T> newPage = new ArrayList<T>();
		
		if((pageSize < 0 || pageSize <= 0))
		{
			throw new IllegalArgumentException("Invalid Page Size");
		}

        int startIndex = page * pageSize;

        if(array == null || array.length <= startIndex)
        {
            return Collections.emptyList();
        }

		for(T element: array) 
		{
			if(pred.predicate(element))
				newPage.add(element);
		}

		return newPage.subList(startIndex, Math.min(startIndex + pageSize, newPage.size()));
	}
	
	public static<T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred)
	{
		List<T> newPage = new ArrayList<T>();
		Iterator<T> iterator = iterable.iterator();

        if(page < 0 || pageSize <= 0)
        {
            throw new IllegalArgumentException("Invalid Page Size");
        }

        int startIndex = page * pageSize;
        int size = ((Collection<?>) iterator).size();

        if(iterator == null || size <= startIndex)
        {
            return Collections.emptyList();
        }
        while(iterator.hasNext())
        {
            if(pred.predicate(iterator.next()))
            {
                newPage.add(iterator.next());
            }
        }
		return newPage.subList(startIndex, Math.min(startIndex + pageSize, newPage.size()));
	}
	
	public static<T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred)
	{
		List<T> newPage = new ArrayList<T>();
		
		if(pageSize < 0 || pageSize <= 0)
		{
			throw new IllegalArgumentException("Invalid Page Size");
		}

        int startIndex = page * pageSize;

        int size = ((Collection<?>) iterator).size();

        if(iterator == null || size <= startIndex)
        {
            return Collections.emptyList();
        }

		while(iterator.hasNext()) 
		{
			if(pred.predicate(iterator.next()))
            {
                newPage.add(iterator.next());
            }
		}
		
		return newPage.subList(startIndex, Math.min(startIndex + pageSize, newPage.size()));
	}
}