package NolanBackground;

public class Multi extends Thread{

	private String name;
	private Thread t;
	
	public static Multi ticker = new Multi("Ticker");
	
	public static int tickInterval = 50;
	
	public Multi(String name){
		this.name = name;
	}
	
	public void start(){
		this.t = new Thread(this , this.name);
		this.t.start();
	}
	
	public void run(){
		if(this.name.equals("Ticker")){
			long startTime = System.currentTimeMillis();
			long now = System.currentTimeMillis();
			while(true){
				now = System.currentTimeMillis();
				if(now - tickInterval == startTime){
					startTime = System.currentTimeMillis();
					tick();
				}
			}
			
			
			
		}
	}
	
	public static void tick(){
		
	}
	
	//STUFF
	
	
}
