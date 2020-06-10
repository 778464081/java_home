package cn.edu.ecut.exception;

public class ExceptionHandlingTest6 {

	public static void main(String[] args) {
		
		System.out.println( "main begin ..." );
		
		Integer a = 100 ;
		// Integer b = null ;
		Integer b = 0 ;
		
		try {
			System.out.println( "- - - try - - -" );
			Integer c = a / b ; // 至此会触发异常，JVM创建表示该异常的对象，将该对象交给运行时系统处理
			System.out.println( a + " / " + b + " = " + c  );
		} catch( NullPointerException e ) { 
			System.out.println( "空指针异常 : " + e.getMessage() );
			e.printStackTrace(); // 打印 栈 轨迹
		} catch( ArithmeticException e ) { 
			System.out.println( "算术异常 : " + e.getMessage() );
			e.printStackTrace(); // 打印 栈 轨迹
		}  finally {
			System.out.println( "- - - finally - - -" );
		}
		
		System.out.println( "main end ." );

	}

}
