package cn.edu.ecut.exception;

public class ExceptionHandlingTest7 {

	public static void main(String[] args) {
		
		System.out.println( "main begin ..." );
		
		Integer a = 100 ;
		// Integer b = null ;
		Integer b = 0 ;
		
		try {
			System.out.println( "- - - try - - -" );
			Integer c = a / b ; // 至此会触发异常，JVM创建表示该异常的对象，将该对象交给运行时系统处理
			System.out.println( a + " / " + b + " = " + c  );
		// 从 JDK 1.7 开始 允许在 catch 之后的 ( ) 中指定多个异常类型 ( 它们之间使用 | 隔开 )	
		} catch( NullPointerException | ArithmeticException e ) { 
			System.out.println( e.getMessage() ); // 打印异常信息
			if( e instanceof NullPointerException ) {
				System.out.println( "空指针异常" );
			}
			if( e instanceof ArithmeticException ) {
				System.out.println( "算术异常" );
			}
			e.printStackTrace(); // 打印异常堆栈
		}  finally {
			System.out.println( "- - - finally - - -" );
		}
		
		System.out.println( "main end ." );

	}

}
