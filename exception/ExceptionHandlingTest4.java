package cn.edu.ecut.exception;

public class ExceptionHandlingTest4 {

	public static void main(String[] args) {
		
		System.out.println( "main begin ..." );
		
		int a = 100 ;
		int b = 10 ;
		
		try {
			System.out.println( "- - - try - - -" );
			int c = a / b ; // 至此会触发异常，JVM创建表示该异常的对象，将该对象交给运行时系统处理
			System.out.println( a + " / " + b + " = " + c  );
			
			// 运行时系统 会寻找 try 之后的 catch 语句块，
			// 如果 遇到 与异常对象的类型 匹配的语句块，则将该异常对象 传递 给该 catch 语句块
		} catch( Exception e ) {
			System.out.println( "- - - catch - - -" );
			System.out.println( e ); // 输出异常对象的字符串形式
		} finally {
			System.out.println( "- - - finally - - -" );
		}
		
		System.out.println( "main end ." );

	}

}
