package JoshDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class Store 
{	    
		
		private static int filesize(String file)
		{
			int i = 0;
			String type = "array";
			String a = "";
			JSONParser parser = new JSONParser();
			try 
			{
				Object obj = parser.parse(new FileReader(file));
				JSONObject jsonObject = (JSONObject) obj;
				// loop array
				JSONArray msg = (JSONArray) jsonObject.get(type);
				Iterator<String> iterator = msg.iterator();
					while (iterator.hasNext()) 
					{
						i++;
						a = ((String)iterator.next());
					}
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			return i;				
		}
		public static String[] getitems(String file)
		{
				
				int i = 0;
				String type = "array";
				String a[] = new String[9999];
				JSONParser parser = new JSONParser();
					try 
					{
						Object obj = parser.parse(new FileReader(file));
						JSONObject jsonObject = (JSONObject) obj;
						// loop array
						JSONArray msg = (JSONArray) jsonObject.get(type);
						Iterator<String> iterator = msg.iterator();
							while (iterator.hasNext()) 
							{
							i++;
							a[i] = ((String)iterator.next());
							}
					} 
					
					catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
			
			return a;
		}
		public static boolean deletefile(String filename)
		{
			boolean success = false;
			try{
				 
	    		File file = new File(filename+".txt");
	    		if(file.delete()){
	    			System.out.println(file.getName() + " is deleted!");
	    			success = true;
	    		}else{
	    			System.out.println("Delete operation is failed.");
	    			success = false;
	    		}
	 
	    	}catch(Exception e){
	 
	    		e.printStackTrace();
	 
	    	}
			return success;
		}
		public static void delete(String file, String name)
		{
			String type = "array";
			JSONObject obj = new JSONObject();
    		JSONArray items = new JSONArray();
    		String a[] = new String[filesize(file)];
    		a = getitems(file);
    		for(int i = 0; i < filesize(file); i++)
    		{	
    			if(a[i] == name)
    			{
    				a[i] = null;
    			}
    			if(a[i] != null)
    			{
    			items.add(a[i]);
    			}
    		}
    		obj.put(type, items);
    		
    		try 
        	{
    			System.out.println("size of array before addition = "+filesize(file));
        		FileWriter writer = new FileWriter(file);
        		writer.write(obj.toJSONString());
        		writer.flush();
        		writer.close();
        		System.out.println("size of array after addition = "+filesize(file));
        	}   
        	catch (IOException e) 
        	{
        	   e.printStackTrace();
        	}
		}
		public static void readablesales(String file, String sales[], int arraylength)
		{
			
			
    		try {	
    			FileWriter writer = new FileWriter(file);
    			for(int i = 0; i < arraylength; i++)
    			{
				writer.write(("\n "+ sales[i]));
    			}
				writer.flush();
	    		writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    		
		}
		public static void newaddition(String file, String additions[])
    	{
			int additionsize = Array.getLength(additions);
    		JSONObject obj = new JSONObject();
    		JSONArray items = new JSONArray();
    		String type = "array";
    		String a[] = new String[filesize(file)+additionsize];
    		File f = new File(file);
    		if(f.exists() && !f.isDirectory()) 
    		{ 
    			a = getitems(file); 
    		}
    		
    		
    		for(int i = 0; i < filesize(file)+additionsize; i++)
    		{	
    		//add compatibility for multiple arrays	
    				if(a[i] != null)
    				{
    				items.add(a[i]);
    				}
    				
    		}
    		for(int i = 0; i < additionsize; i++)
    		{
    		
    			items.add(additions[i]);
    			
    		}
    		obj.put(type, items);
    		
    		try 
        	{
    			System.out.println("size of array before addition = "+filesize(file));
        		FileWriter writer = new FileWriter(file);
        		writer.write(obj.toJSONString());
        		writer.flush();
        		writer.close();
        		System.out.println("size of array after addition = "+filesize(file));
        	}   
        	catch (IOException e) 
        	{
        	   e.printStackTrace();
        	}
    	}
		public static void newReceipt(String file, String additions[])
    	{
			int additionsize = Array.getLength(additions);
    		JSONObject obj = new JSONObject();
    		JSONArray items = new JSONArray();
    		String type = "array";
    		String a[] = new String[additionsize];
    		File f = new File(file);
    		for(int i = 0; i < additionsize; i++)
    		{
    		
    			items.add(additions[i]);
    			
    		}
    		obj.put(type, items);
    		
    		try 
        	{
        		FileWriter writer = new FileWriter(file);
        		writer.write(obj.toJSONString());
        		writer.flush();
        		writer.close();
        	}   
        	catch (IOException e) 
        	{
        	   e.printStackTrace();
        	}
    	}
		
}