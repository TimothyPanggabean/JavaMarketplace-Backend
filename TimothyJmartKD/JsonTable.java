package TimothyJmartKD;

import java.io.*; 
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector; 
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonTable<T> extends Vector
{
	public final String filepath;
	private static final Gson gson = new Gson();
	
	public JsonTable(Class<T> clazz, String filepath) throws IOException
	{
		this.filepath = filepath;
		try
		{
			Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
			T[] loaded = readJson(arrayType, filepath);
			if(loaded != null)
			{
				Collections.addAll(this, loaded);
			}
		}
		catch (FileNotFoundException e)
		{
			File f = new File(filepath);
            File f1 =  f.getParentFile();
            if(f1 != null)
            {
                f1.mkdirs();
            }
            f.createNewFile();
		}	
	}
	
	public static<T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException
	{
		JsonReader reader = new JsonReader(new FileReader(filepath));
		T obj = gson.fromJson(reader, clazz);
        return obj;
	}
	
	public void writeJson() throws IOException
	{
		writeJson(this, this.filepath);
	}
	
	public static void writeJson(Object object, String filepath) throws IOException
	{
		FileWriter fwrite = new FileWriter(filepath);
        String data = gson.toJson(object);
        fwrite.write(data);
        fwrite.close();
	}
}
