package com.TimothyJmartKD;

/**
 * Interface Predicate
 * isi: boolean untuk digunakan di class lain
 */
public interface Predicate<T>
{
	public abstract boolean predicate(T arg);
}