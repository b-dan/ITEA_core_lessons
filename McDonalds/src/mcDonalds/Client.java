package mcDonalds;

public class Client implements Runnable{

	private String name;
	private Thread t;
	private Cass cass;
	private Cashier cs;

	public Client(String name, Cashier cs, Cass cass) {
		super();
		this.cs=cs;
		this.name = name;
		this.cass = cass;
		t = new Thread(this);
		t.setDaemon(true);
		t.start();
	}

	@Override
	public void run() {
		//System.out.println("in client run");
		synchronized(cs) {
			cs.serveClient(cass, name);
		}


	}

	public Thread getT() {
		return t;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
