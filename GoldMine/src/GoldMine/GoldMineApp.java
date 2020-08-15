package GoldMine;


public class GoldMineApp {
	public static void main(String[] args) {
		
		System.out.println("============Start=============");
		GoldMine g = new GoldMine();
		System.out.println("Gold mine capacity: " + g.getGold());
		GoldMiner g1 = new GoldMiner(g, "Miner1");
		GoldMiner g2 = new GoldMiner(g, "Miner2");
		GoldMiner g3 = new GoldMiner(g, "Miner3");
		Barracks b = new Barracks(g);
		try {
			g1.getT().join();
			g2.getT().join();
			g3.getT().join();
			b.getT().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Gold mine capacity: " + g.getGold());
		System.out.println("============End=============");
		
	}

}
