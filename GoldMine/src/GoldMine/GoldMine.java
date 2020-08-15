package GoldMine;

public class GoldMine {
	private volatile int gold = 100;
	
	public void decreaseGold() {
		gold -= 2;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
}
