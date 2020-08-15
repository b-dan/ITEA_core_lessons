package GoldMine;

import java.util.concurrent.TimeUnit;

public class GoldMiner implements Runnable{
	private GoldMine goldmine;
	private String minerName;
	private int gold;
	private Thread t;

	public GoldMiner(GoldMine goldmine,String minerName) {
		super();
		this.goldmine=goldmine;
		this.minerName = minerName;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		do {
			synchronized(goldmine){
					goldmine.decreaseGold();
					gold+=2;
			}
			try {
				TimeUnit.SECONDS.sleep(1);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getMinerName()+" : "+this.getGold());
		}
		while(goldmine.getGold()>0);
		
	}
		
		public String getMinerName() {
			return minerName;
		}

		public void setMinerName(String minerName) {
			this.minerName = minerName;
		}

		public int getGold() {
			return gold;
		}

		public void setGold(int gold) {
			this.gold = gold;
		}

		public Thread getT() {
			return t;
		}

		public void setT(Thread t) {
			this.t = t;
		}
	}
