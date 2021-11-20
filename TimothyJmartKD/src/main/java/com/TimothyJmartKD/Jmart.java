package com.TimothyJmartKD;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class Jmart
 *
 * Timothy Christian Panggabean
 * 1906355705
 */

@SpringBootApplication
public class Jmart
{
	public static long DELIVERED_LIMIT_MS = 200;
	public static long ON_DELIVERY_LIMIT_MS = 300;
	public static long ON_PROGRESS_LIMIT_MS = 300;
	public static long WAITING_CONF_LIMIT_MS = 200;
	
	public static void main(String[] args)
	{
		SpringApplication.run(Jmart.class, args);

		try
		{

		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}
	
	/*public static boolean paymentTimekeeper(Payment payment)
	{
		long elapsedTime = (new java.util.Date()).getTime() - payment.history.get(payment.history.size()-1).date.getTime();
		
		if(payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.WAITING_CONFIRMATION) && elapsedTime > WAITING_CONF_LIMIT_MS)
			payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Transaction Failed"));
		
		else if(payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.ON_PROGRESS) && elapsedTime > ON_PROGRESS_LIMIT_MS)
			payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Transaction Failed"));
		
		else if(payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.ON_DELIVERY) && elapsedTime > ON_DELIVERY_LIMIT_MS)
			payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "Package has been delivered"));
		
		else if(payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.DELIVERED) && elapsedTime > DELIVERED_LIMIT_MS)
			payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "Payment has been finished"));
		
		for(Payment.Record element: payment.history) {
            if(element.status == Invoice.Status.FINISHED || element.status == Invoice.Status.FAILED) payment.history.remove(element);
        }
        
        if(payment.history.isEmpty()) return true;
        
        else return false;
	}*/
	
	/*
	public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize)
	{
		List<Product> listFilterByAccountId = new ArrayList<>();
		Predicate<Product> pred = product -> product.accountId == accountId;
		listFilterByAccountId = paginate(list, page, pageSize, pred);
		
		return listFilterByAccountId;
	}
	
	public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize)
	{
		List<Product> listFilterByName = new ArrayList<>();
		Predicate<Product> pred = product -> product.name.toLowerCase().contains(search.toLowerCase());
		listFilterByName = paginate(list, page, pageSize, pred);
		
		return listFilterByName;
	}
	public static List<Product> filterByCategory (List<Product>list, ProductCategory category)
	{
		 List<Product> listFilterByCategory = new ArrayList<>();
		 for(Product lists : list) 
		 {
			 if(lists.category == category) listFilterByCategory.add(lists);
		 }
		 return listFilterByCategory;
	}
	
	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) 
	{
        List<Product> listFilterByPrice = new ArrayList<>();
        if(minPrice == 0.0 && maxPrice == 0.0) return null;
        else if(minPrice == 0.0) 
        {
            for(Product lists : list) 
            {
                if(lists.price <= maxPrice) listFilterByPrice.add(lists);
            }
        }
        else if(maxPrice == 0.0) 
        {
            for(Product lists : list) 
            {
                if(lists.price >= minPrice) listFilterByPrice.add(lists);
            }
        }
        else
        	for(Product lists : list) 
            {
        		if(lists.price >= minPrice && lists.price <= maxPrice) listFilterByPrice.add(lists);
            }
        return listFilterByPrice;
    }
	
	private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred)
	{
		List<Product> listPaginate = new ArrayList<>();
		
		for(Product lists : list) {
			if(pred.predicate(lists)) listPaginate.add(lists);
		}
		
		if(pageSize <= 0 || page < 0) {
	        throw new IllegalArgumentException("invalid page size!");
	    }
	    
	    int fromIndex = page * pageSize;
	    if(listPaginate == null || listPaginate.size() <= fromIndex){
	        return Collections.emptyList();
	    }
	    return listPaginate.subList(fromIndex, Math.min(fromIndex + pageSize, listPaginate.size()));
	}
	
	public static List<Product> read(String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        Product[] entry = new Gson().fromJson(reader, Product[].class);
        List<Product> list = new ArrayList<>();
        Collections.addAll(list, entry);
        return list;
    }
    */
}