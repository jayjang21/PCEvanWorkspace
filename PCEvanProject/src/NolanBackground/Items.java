package NolanBackground;

public class Items {
	
	public Items(String name , double price , double PST){
		this.name = name;
		this.price = price;
		this.PST = PST;
	}
	
	

	private String name;
	private double price;
	private double PST;
	private double GST;
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPST() {
		return PST;
	}
	public void setPST(double pST) {
		PST = pST;
	}
	public double getGST() {
		return GST;
	}
	public void setGST(double gST) {
		GST = gST;
	}
	
	//STUF
	
	
}
