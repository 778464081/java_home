package cn.edu.ecut.error;

public class ErrorTest {

	public static void main(String[] args) {
		hello(); // StackOverflowError
	}
	
	public static void hello() {
		hello();
	}

}
