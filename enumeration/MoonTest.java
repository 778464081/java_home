package cn.edu.ecut.singleton;

public class MoonTest {

	public static void main(String[] args) {
		
		// Moon m = new Moon(); // The constructor Moon() is not visible
		 
		Moon m = Moon.getInstance();
		
		Moon o = Moon.getInstance();
		
		System.out.println( m == o );

	}

}
