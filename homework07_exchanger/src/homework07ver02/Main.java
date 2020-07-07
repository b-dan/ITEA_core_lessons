package homework07ver02;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		Cart cart = new Cart(6);
		Heap heap = new Heap();
		Exchanger<Cart> excLoaderTransp = new Exchanger<Cart>();
		Exchanger<Cart> excUnloaderTransp = new Exchanger<Cart>();	
		
		Loader loader = new Loader(heap, cart, excLoaderTransp);
		Transporter transporter = new Transporter(cart, excLoaderTransp, excUnloaderTransp);
		Unloader unloader = new Unloader(cart, excUnloaderTransp);
	}
}
