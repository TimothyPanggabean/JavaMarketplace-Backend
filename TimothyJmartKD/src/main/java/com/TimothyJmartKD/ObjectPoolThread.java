package com.TimothyJmartKD;

import java.util.Vector;
import java.util.function.Function;

/**
 * Class ObjectPoolThread
 * isi: metode untuk membuat dan memulai sebuah thread
 *
 */
public class ObjectPoolThread<T> extends Thread
{
	private boolean exitSignal;
	private Vector<T> objectPool = new Vector<>();
	private Function<T, Boolean> routine;
	
	public ObjectPoolThread(String name, Function<T, Boolean> routine)
	{
		super(name);
		this.routine = routine;
	}
	
	public ObjectPoolThread(Function<T, Boolean> routine)
	{
		super();
		this.routine = routine;
	}
	
	public void add(T object)
	{
		objectPool.add(object);
	}
	
	public void exit()
	{
		exitSignal = true;
	}
	
	public void run()
	{
		synchronized (this) 
		{
			while(!exitSignal) 
			{
				try
				{
					while(objectPool.size() != 0)
					{
						for (T object : objectPool)
						{
							if(routine.apply(object)) objectPool.remove(object);
						}
					}
					this.wait();
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public int size()
	{
		return objectPool.size();
	}
}