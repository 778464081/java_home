package cn.edu.ecut.exception;

/**
 * 由 程序 创建的异常对象
 */
public class ExceptionHandlingTest2 {

	public static void main(String[] args) {
		
		int a = 100 ;
		int b = 0 ;
		if( b == 0 ) {
			// 主动创建 异常对象 ( 即 创建 Exception 类的实例 或 其子类类型的实例 )
			RuntimeException e = new RuntimeException( "除数不能为零" );
			// 抛出异常对象
			throw e ; // throw 用于抛出 异常实例
		}
		int c = a / b ;
		System.out.println( a + " / " + b + " = " + c  );

	}

}
