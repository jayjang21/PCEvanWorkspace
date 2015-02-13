package JoshDatabase;import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class Store 
{	    
	
		static String a = "Fruit";
		static String b = "Orange";
		public static void main(String[] args)
		{
		//test method calls
		//newitem(a,110);
		//sale(b,117,15.09082215);
		String d[] = new String[3];
		d[0] = "orange";
		d[1] = "10";
		d[2] = "blah";
		String c[] =  new String[3];
		c[0] = "Apple";
		c[1] = "10";
		c[2] = "abc1234";
		//delete("swagger.json","Apple",3);
		deletefile("swagger.json");
		newaddition("swagger.json",c,3);
		newaddition("swagger.json",d,3);
		//readablesales("sales1.sales",c,3);
		}
		
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
		public static String[] getitems(String file, int additionsize)
		{
			
				int i = 0;
				String type = "array";
				String a[] = new String[filesize(file)+additionsize];
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
				 
	    		File file = new File(filename);
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
			System.out.println(filesize(file));
			String type = "array";
			JSONObject obj = new JSONObject();
    		JSONArray items = new JSONArray();
    		String a[] = new String[filesize(file)+1];
    		a = getitems(file,1);
    		for(int i = 0; i < filesize(file)+1; i++)
    		{	
    			
    			System.out.println(""+i);
    			System.out.println(name + " this is the delete name");
    			System.out.println(a[i] + " this is the array item name");
    			if(a[i] != null )
    			{
    			if(a[i].equals(name))
    			{
    				System.out.println("deleted "+i);
    			}
    			if(!(a[i].equals(name)))
    			{	
    				System.out.println("added");
    				items.add(a[i]);
    			}
    			}	
    		}
    		obj.put(type, items);
    		try 
        	{
    			//System.out.println("size of array before delete = "+filesize(file));
        		FileWriter writer = new FileWriter(file);
        		writer.write(obj.toJSONString());
        		writer.flush();
        		writer.close();
        		//System.out.println("size of array after delete = "+filesize(file));
        	}   
        	catch (IOException e) 
        	{
        	   e.printStackTrace();
        	}
		}
		public static void readablesales(String file, String newsales[], int arraylength)
		{
			BufferedReader br = null;
	        //Needs to convert everything already in the file into a string
	        //or Nolan needs to make a new file for every time a sale is made
    		try {	
    			FileWriter writer = new FileWriter(file);
    			for(int i = 0; i < arraylength; i++)
    			{
				writer.write(("\n "+ newsales[i]));
    			}
				writer.flush();
	    		writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    		
		}
		public static void newaddition(String file, String additions[], int additionsize)
    	{
    		JSONObject obj = new JSONObject();
    		JSONArray items = new JSONArray();
    		String type = "array";
    		File f = new File(file);
    		if(f.exists() && !f.isDirectory()) 
    		{ 
    			String a[] = new String[filesize(file)+additionsize];
    			a = getitems(file,additionsize); 
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
    		else
    		{
    			String a[] = new String[additionsize];
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
    		
    	}
		
}