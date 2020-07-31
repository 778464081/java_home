package cn.edu.ecut.loader;

public class JvmProcessStatus {
	
	public static int counter = 0 ;

	public static void main(String[] args) {
		JvmProcessStatus.counter++ ;
		System.out.println( JvmProcessStatus.counter );
	}

}
