package cn.edu.ecut.loader;

public class MoonTest {

	public static void main(String[] args) {
		
		Moon m = Moon.getInstance();
		
		System.out.println( m );
		System.out.println( "first : " + Moon.first );
		System.out.println( "second : " + Moon.second );
		
	}

}
