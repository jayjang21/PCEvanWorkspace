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
		//totalPrice += i.getPrice();
		return i.getPrice();
	}
	
	public static double getTotalPrice(){
		return totalPrice;
	}
	
	public static void checkout(String paymentMethod , ArrayList<Items> items , double totalPrice){
		
	}
	
	public static double addItemToCart(String name){
		Items i = getItem(name);
		items.add(i);
		totalPrice = totalPrice + i.getPrice();

		return getPrice(name);
	}
	
	public static Items getItem(String name){
	
		String[] string =  Store.getitems("res" + "/" + name + ".txt", 3);
		JSONObject obj = new JSONObject();
		obj.put("name", string[1]);
		obj.put("price", string[2]);
		obj.put("PST", string[3]);
		obj.put("GST", string[4]);
		Items i = new Items(string[1] , Double.parseDouble((String) obj.get("price")) , Double.parseDouble( (String) obj.get("PST")) , Double.parseDouble((String) obj.get("GST")));	
		items.add(i);
		return i;
	}
	
	
	
	public static ArrayList<String> getItems(){
		ArrayList<String> answer = new ArrayList<String>();
		
			File file = new File("res");
			for(File f : file.listFiles()){
				if(!f.isDirectory()){
				String[] items = Store.getitems(f.getPath(), 4);
				System.out.println(f.getPath().toString());
				JSONObject obj = new JSONObject();
				obj.put("name", items[1]);
				obj.put("price", items[2]);
				obj.put("PST", items[3]);
				obj.put("GST", items[4]);
				Items i = new Items(items[1] , Double.parseDouble((String) obj.get("price")) , Double.parseDouble( (String) obj.get("PST")) , Double.parseDouble((String) obj.get("GST")));	
				BackgroundMain2.items.add(i);
				answer.add(i.getName());
			}
		
			}
		return answer;
	}
	
	public static void writeReceipt(String[] stuff){
		
		for(String s : stuff){
			System.out.println(s);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
	
		File filee = new File(path + "/" + "receipt"); 
		if(!filee.exists())
		filee.mkdir();
		
		File file = new File(path + "/" + "receipt" + "/" + date + ".txt" );	
	
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Store.newReceipt(path + "/" + "receipt" + "/" + date + ".txt", stuff);
		totalPrice = 0;
		
		
		
	}
	
	public static void totalGSTPST(double PST , double GST){
		File file = new File(path + "/" + "receipt" + "/" + "GST&PST.txt");
		
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		JSONObject old = new JSONObject();
		
		JSONParser parser = new JSONParser();
		
		try {
			old = (JSONObject) parser.parse(file.toString());
		} catch (ParseException e) {
			System.out.println("Failed to print GST and PST");
		}
		double pst = 0;
		if(old.get("PST") != null)
		 pst = Double.parseDouble((String) old.get("PST"));
		double gst = 0;
		if(old.get("GST") != null)
		gst = Double.parseDouble((String) old.get("GST"));
		
		pst = pst + PST;
		gst = gst + GST;
		
		JSONObject obj = new JSONObject();
		
		obj.put("PST: ", "$" + pst);
		obj.put("GST: ", "$" + gst);
		
		try {
			FileWriter writer = new FileWriter(file.toString());
			writer.write(obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		
		File file = new File("res" + "/" + i.getName() + ".txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		Store.newaddition("res" + "/" + i.getName() + ".txt", str);
	}
	
	public static void writePath(String path){
		File file = new File("res/path.txt");
		
		JSONObject obj = new JSONObject();
		obj.put("path", path);
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(obj.toJSONString());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void checkPath(){
		File file = new File("res");
		
		boolean any = false;
		for(File f : file.listFiles()){
			if(f.getName().equals("path"))
				any = true;
		}
		if(any == false){
			File f = new File("res/path.txt");
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		JSONParser parser = new JSONParser();
		try {
			FileReader reader = new FileReader("res/path.txt");
			try {
				JSONObject obj = (JSONObject) parser.parse(reader);
				if(obj.containsKey("path")){
					path = (String) obj.get("path");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
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
	}
	
	public static void delete(String name){
		Store.deletefile("res" + "/" + name);
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
}