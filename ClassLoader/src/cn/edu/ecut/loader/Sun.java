package cn.edu.ecut.loader;

public class Sun {
	
	private static final Sun SINGLETON = new Sun();
	public static int first ;
	public static int second = 0 ;

	public Sun() {
		first++ ;
		second++ ;
	}
	
	public static Sun getInstance(){
		return SINGLETON ;
	}

}
