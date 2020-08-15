package GoldMine;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Barracks implements Runnable{

	private GoldMine gm;
	private int a=4;
	private Thread t = new Thread();
	
	
	public Barracks(GoldMine gm) {
		super();
		this.gm = gm;
		t = new Thread(this);
		t.start();
	}



	@Override
	public void run() {
		GoldMiner gminer = null;
		do {
			try {
				TimeUnit.SECONDS.sleep(10);
				System.out.println("-------10 seconds------");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(gm.getGold()>=2) {
			gminer = new GoldMiner(gm, "Miner"+a++);
			}
			
		}
		while(gm.getGold()>0);
		
	}



	public Thread getT() {
		return t;
	}



	public void setT(Thread t) {
		this.t = t;
	}
	
	
	
	
	
	

}
