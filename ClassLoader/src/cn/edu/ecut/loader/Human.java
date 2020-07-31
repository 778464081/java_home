package cn.edu.ecut.loader;

public class Human {
	
	static {
		System.out.println( "static initializer : Human" );
	}
	
	public static void show() {
		System.out.println( "俺们那个都是东北人..." );
	}

}
