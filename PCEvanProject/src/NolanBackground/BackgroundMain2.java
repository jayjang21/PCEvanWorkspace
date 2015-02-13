package NolanBackground;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import JoshDatabase.Store;

public class BackgroundMain2 {
	
	public static void go(){
		
	}

	public static double totalPrice = 0;
	public static String path = "res";
	public static ArrayList<Items> items = new ArrayList<Items>();
	
	public static double getPrice(String name){
		Items i = getItem(name);
		totalPrice += i.getPrice();
		return i.getPrice();
	}
	
	public static double getTotalPrice(){
		return totalPrice;
	}
	
	public static void removeItem(String name){
		Items i = getItem(name);
		totalPrice -= i.getPrice();
	}
	
	public static void checkout(String paymentMethod , ArrayList<Items> items , double totalPrice){
		
	}
	
	public static double addItemToCart(String name){
		Items i = getItem(name);

		totalPrice = totalPrice + i.getPrice();

		return getPrice(name);
	}
	
	public static Items getItem(String name){
		String[] string =  Store.getitems(path + "/" + name, 3);
		JSONObject obj = new JSONObject();
		obj.put("name", string[1]);
		obj.put("price", string[2]);
		obj.put("PST", string[3]);
		obj.put("GST", string[4]);
		Items i = new Items(string[1] , Double.parseDouble((String) obj.get("price")) , Double.parseDouble( (String) obj.get("PST")) , Double.parseDouble((String) obj.get("GST")));	

		return i;
		
	}
	
	
	
	public static ArrayList<String> getItems(){
		ArrayList<String> answer = new ArrayList<String>();
		
			File file = new File(path);
			for(File f : file.listFiles()){
				String[] string =  Store.getitems(path + "/" + f.getName(), 5);
				if(f.isFile() &! f.isDirectory()){
				Items i = getItem(f.getName());
				/*
				String[] items = Store.getitems(f.getPath(), 3);
				JSONObject obj = new JSONObject();
				obj.put("name", items[0]);
				obj.put("price", items[1]);
				obj.put("PST", items[2]);
				obj.put("GST", items[3]);
				Items i = new Items(items[1] , Double.parseDouble((String) obj.get("price")) , Double.parseDouble( (String) obj.get("PST")) , Double.parseDouble((String) obj.get("GST")));
				*/	
				BackgroundMain2.items.add(i);
				answer.add(i.getName());
				}
			}
		
		
		return answer;
	}
	
	public static void setPath(){
		File file = new File(path);
		boolean s = false;
		for(File f : file.listFiles()){
			if(f.getName().equals("path")){
				s = true;
				String[] u = Store.getitems(f.getPath(), 3);
				path = u[1];
			}
		}
		File file2 = new File(path + "/" + "path");
		if(s == false){
		try {
			file2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		String[] string = Store.getitems(file2.getPath(), 2);
		if(!string[1].equals("null"))
		path = string[1];
	}
	
	public static void writeReceipt(String[] stuff){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
	
		File file2 = new File(path + "/" + "receipts");
		int i = 0;
		for(File f : file2.listFiles()){
			int name = Integer.parseInt(f.getName());
			if(name > i)
				i = name + 1;
			i++;
		}
		
		
		File file = new File(path + "/" + "receipts" + i + ".txt" );	
	
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Store.newaddition(path + "/" + "receipts" + i + ".txt", stuff, stuff.length);
		totalPrice = 0;
	}
	
	public static void totalGSTPST(double PST , double GST){
		File file = new File(path + "/" + "receipts" + "/" + "GST&PST.txt");
		
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		JSONObject old = new JSONObject();
		
		double pst = Double.parseDouble((String) old.get("PST"));
		double gst = Double.parseDouble((String) old.get("GST"));
		
		pst = pst + PST;
		gst = gst + GST;
		
		JSONObject obj = new JSONObject();
		
		obj.put("PST: ", "$" + pst);
		obj.put("GST: ", "$" + gst);
		
		
	}
	
	
	public static void newItem(Items i){
		JSONObject obj = new JSONObject();
		obj.put("name", i.getName());
		obj.put("price", i.getPrice());
		obj.put("PST", i.getPST() / 100);
		obj.put("GST", i.getGST() / 100);
		
		String[] str = new String[4];
		str[0] = (String) obj.get("name");
		str[1] = String.valueOf( obj.get("price"));
		str[2] = String.valueOf( obj.get("PST"));
		str[3] = String.valueOf(obj.get("GST"));
		
		File file = new File(path + "/" + i.getName() + ".txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		Store.newaddition(path + "/" + i.getName() + ".txt", str , 4);
	}
	
	
	//JSON Stuff
	
	@SuppressWarnings("unchecked")
	public static String itemToString(Items i){
		JSONObject obj = new JSONObject();
		obj.put("name", i.getName());
		obj.put("price", i.getPrice());
		obj.put("PST", i.getPST());
		obj.put("GST", i.getGST());
		return obj.toJSONString();
	}
	
	public static void changeDirectory(String dir){
		path = dir;
		File file = new File(dir);
		boolean any = false;
		for(File f : file.listFiles()){
			if(f.isDirectory() && f.getName().equals("receipts")){
				any = true;
			}else{
				
			}
		}
		if(!any){
			File file2 = new File(dir + "/" + "receipts");
			file2.mkdir();
		}
	}
	
	/*
	
	public static void main(String[] args){
		//newItem(new Items("apples" , 50.22 , 0.04 , 0.3));
		
		
		ArrayList<String> s = getItems();
		for(String str : s){
			System.out.println(str);
			Items i = getItem(str);
			System.out.println(getPrice(str));
		}
		System.out.println("TotalPrice: " + getTotalPrice());
		
	}
	
	
	*/
	
	public static JSONObject get(String file){
		
		JSONParser parser = new JSONParser();
		try {
			FileReader reader = new FileReader(path + "/" + file);
			try {
				return  (JSONObject) parser.parse(reader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
	public static void  write(String file){
		try {
			FileWriter writer = new FileWriter(path + "/" + file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
