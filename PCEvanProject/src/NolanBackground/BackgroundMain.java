package NolanBackground;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import JoshDatabase.*;
import JayUI.*;

public class BackgroundMain {
	
	public static ArrayList<String> items = new ArrayList<String>();
	
	
	
	

	public BackgroundMain(){
		Multi.ticker.start();
	}
	
	
	
	public static void ItemPressed(String name){
		
	}
	
	
	public static double add(String name){
		
		
		
		items.add(name);
		
		return 0;
		
	}
	
	public static double cal(Items i){
		return i.getPrice() + (i.getPrice() * i.getPST()) + (i.getPrice() * i.getGST());
	}
	
	
	public static double all(ArrayList<Items> i) {
		double answer = 0;
		for(Items s : i){
			answer = answer + cal(s);
		}
		
		return answer;
		
	}
	
	public static void Generate(String name , double price , double PST , double GST){
		
	}
	
	public static void Remove(String name){
		
	}
	
	public static void SaveReceipt(ArrayList<Items> items , String paymentMethod , double totalPrice){
		
	}
	
	
}
