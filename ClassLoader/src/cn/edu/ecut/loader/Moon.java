package cn.edu.ecut.loader;

public class Moon {
	
	public static int first ;
	public static int second = 0 ;
	private static final Moon SINGLETON = new Moon();
	
	private Moon() {
		first++ ;
		second++ ;
	}
	
	public static Moon getInstance(){
		return SINGLETON ;
	}

}
