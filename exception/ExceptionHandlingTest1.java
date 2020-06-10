package cn.edu.ecut.exception;

/**
 * 由 JVM 创建的异常对象
 */
public class ExceptionHandlingTest1 {

	public static void main(String[] args) {
		
		int a = 100 ;
		int b = 0 ;
		int c = a / b ; // java.lang.ArithmeticException
		System.out.println( a + " / " + b + " = " + c  );

	}

}
