package mcDonalds;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("============Start=============");
		Cashier cs = new Cashier();
		Cass cass = new Cass();
		Client c1 = new Client("Client1", cs, cass);
		Client c2 = new Client("Client2", cs, cass);
		Client c3 = new Client("Client3", cs,  cass);
		Client c4 = new Client("Client4", cs, cass);
		Client c5 = new Client("Client5", cs, cass);
		try {
			cass.getT().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("============End=============");
	}


}
