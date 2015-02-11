package JoshDatabase;


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
		String c[] =  new String[3];
		c[0] = "Apple";
		c[1] = "10";
		c[2] = "abc1234";
		delete("Items.json","items","Apple");
		newaddition("Items.json","items",c,3);	
		}
		
		public static int filesize(String file, String type)
		{
			int i = 0;
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
			finally{
			return i;	
			}
			
						
		}
		public static String[] makeitems(String file, String type)
		{
			
				int i = 0;
				String a[] = new String[filesize(file,type)+4];
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
		public static void delete(String file, String type, String name)
		{
			JSONObject obj = new JSONObject();
    		JSONArray items = new JSONArray();
    		String a[] = new String[filesize(file,type)];
    		a = makeitems(file,type);
    		for(int i = 0; i < filesize(file,type); i++)
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
    			System.out.println("size of array before addition = "+filesize(file,type));
        		FileWriter writer = new FileWriter(file);
        		writer.write(obj.toJSONString());
        		writer.flush();
        		writer.close();
        		System.out.println("size of array after addition = "+filesize(file,type));
        	}   
        	catch (IOException e) 
        	{
        	   e.printStackTrace();
        	}
		}
		public static void newaddition(String file, String type, String additions[], int additionsize)
    	{
    		JSONObject obj = new JSONObject();
    		JSONArray items = new JSONArray();
    		String a[] = new String[filesize(file,type)+additionsize];
    		a = makeitems(file,type);
    		
    		for(int i = 0; i < filesize(file,type)+additionsize; i++)
    		{	
    			
    				if(a[i] != null)
    				{
    				items.add(a[i]);
    				}
    				
    		}
    		for(int i = 0; i < additionsize; i++)
    		{
    		//checkmif it has been added before for items and deals only
    			items.add(additions[i]);
    			
    		}
    		obj.put(type, items);
    		
    		try 
        	{
    			System.out.println("size of array before addition = "+filesize(file,type));
        		FileWriter writer = new FileWriter(file);
        		writer.write(obj.toJSONString());
        		writer.flush();
        		writer.close();
        		System.out.println("size of array after addition = "+filesize(file,type));
        	}   
        	catch (IOException e) 
        	{
        	   e.printStackTrace();
        	}
    	}
		

}