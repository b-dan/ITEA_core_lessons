package mcDonalds;

public class Cass implements Runnable{

	private Thread t;
	public volatile boolean isClosed;



	public Cass() {
		super();
		t = new Thread(this);
		t.start();
	}



	@Override
	public void run() {
		System.out.println("Cass is opened");
		//System.out.println(isClosed);
		while(!isClosed) {
			//System.out.println("Cass is"+isClosed);
		}
		System.out.println("Cass is stopped");

	}



	public Thread getT() {
		return t;
	}



	public void setT(Thread t) {
		this.t = t;
	}



	public boolean isClosed() {
		return isClosed;
	}



	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}


}
