package cn.edu.ecut.exception;

public class ExceptionHandlingTest3 {

	public static void main(String[] args) {
		
		System.out.println( "main begin ..." );
		
		int a = 100 ;
		int b = 0 ;
		
		try {
			int c = a / b ; // 至此会触发异常，JVM创建表示该异常的对象，将该对象交给运行时系统处理
			System.out.println( a + " / " + b + " = " + c  );
			
			// 运行时系统 会寻找 try 之后的 catch 语句块，
			// 如果 遇到 与异常对象的类型 匹配的语句块，则将该异常对象 传递 给该 catch 语句块
		} catch( NullPointerException e ) { // 注意，catch 后的 ( ) 中指定的实际上是个 形参
			System.out.println( e ); // 输出异常对象的字符串形式
			System.out.println( e.getClass() ); // 运行时类型
		} catch( ArithmeticException e ) {
			System.out.println( e ); // 输出异常对象的字符串形式
			System.out.println( "message : " + e.getMessage() );
			System.out.println( "cause : " + e.getCause() );
			System.out.println( e.getClass() ); // 运行时类型
		}
		
		System.out.println( "main end ." );

	}

}
