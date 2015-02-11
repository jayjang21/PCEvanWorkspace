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
		
		double price = DatabaseMain.getPrice(name);
		double PST = DatabaseMain.getPST(name);
		double GST = DatabaseMain.getGST(name);
		
		double afterPST = price * PST;
		double afterGST = price * GST;
		
		items.add(name);
		
		return price + PST + GST;
		
	}
	
	
	
	
}
