package cn.edu.ecut.proxy1;

public class Main {

	public static void main(String[] args) {
		
		HuaWei foctory = new Foxconn();

		HuaWei store = new Store( foctory );
		
		String x = store.produce();
		System.out.println( x );
		
	}

}
