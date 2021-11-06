package TimothyJmartKD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import com.google.gson.*;

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
		read("/Users/Timothy/Desktop/Kuliah/Semester 5/OOP/Praktikum/Modul 6/randomProductList.json");
	}
	
	public static List<Product> filterByCategory (List<Product>list, ProductCategory category)
	{
		 List<Product> categoryFilteredList = new ArrayList<>();
		 for(Product lists : list) 
		 {
			 if(lists.category == category)
			 {
				 categoryFilteredList.add(lists);
			 }
		  }
		 return categoryFilteredList;
	}
	
	public static List<Product> filterByPrice (List<Product> list, double minPrice, double maxPrice)
	{
		if (minPrice == 0.0);
		if (maxPrice == 0.0);
		return null;
	}
	
	public static  List<Product> read (String filepath)
	{
		Gson gson = new Gson();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			Product input = gson.fromJson(br, Product.class);
			System.out.println("accountId: " + input.name);
			System.out.println("category: " + input.category);
			System.out.println("conditionUsed:" + input.conditionUsed);
			System.out.println("discount: " + input.discount);
			System.out.println("name: " + input.name);
			System.out.println("price:" + input.price);
			System.out.println("shipmentPlans: " + input.shipmentPlans);
			System.out.println("weight: " + input.weight);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}