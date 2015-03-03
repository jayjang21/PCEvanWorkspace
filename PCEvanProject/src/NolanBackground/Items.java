package NolanBackground;

public class Items {
	
	public Items(String name , double price , double PST , double GST){
		this.name = name;
		this.price = price;
		this.PST = PST;
		this.GST = GST;
		this.sale = 0;
		this.colour = "white";
	}
	
	public Items(String name , double price , double PST , double GST , double sale , String colour){
		this.name = name;
		this.price = price;
		this.PST = PST;
		this.GST = GST;
		setSale(sale);
		this.colour = colour;
	}
	
	

	private String name;
	private double price;
	private double PST;
	private double GST;
	private double sale;
	private String colour;
	
	
	
	
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
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		if(sale != 0){
			this.sale = sale / 100;
		}else{
		this.sale = 0;
		}
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	//STUF
	
	
}