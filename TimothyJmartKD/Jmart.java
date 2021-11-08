package TimothyJmartKD;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

/**
 * Class Jmart
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Jmart
{
	public static void main(String[] args)
	{
		try
		{
			List<Product> list	= read("/Users/Timothy/Desktop/Kuliah/Semester 5/OOP/Praktikum/Modul 6/randomProductList.json");
			
			//List<Product> filteredPrice = filterByPrice(list, 0.0, 20000.0);
			//filteredPrice.forEach(product -> System.out.println(product.price));
			
			//List<Product> filteredAccountId = filterByAccountId(list, 1, 0, 5);
			//filteredAccountId.forEach(product -> System.out.println(product.name));
			
			List<Product> filteredName = filterByName(list, "gtx", 1, 5);
			filteredName.forEach(product -> System.out.println(product.name));
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}
	
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
}