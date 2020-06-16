package mcDonalds;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cashier{
	public void serveClient(Cass cass, String clientName) {
		//System.out.println("in cashier");
		Random randomno = new Random();
		boolean value = randomno.nextBoolean();
		//System.out.println("VALUE = " + value);
		if(!cass.isClosed) {
			if(!value) {
				System.out.println("Cashier serves client"+clientName);
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else{
				cass.setClosed(true);
				System.out.println("McDonalds is closed.");
			}
		}
	}
}
