package cn.edu.ecut.exception;

public class ExceptionHandlingTest5 {

	public static void main(String[] args) {
		
		System.out.println( "main begin ..." );
		
		int a = 100 ;
		int b = 0 ;
		
		try {
			System.out.println( "- - - try - - -" );
			int c = a / b ; // 至此会触发异常，JVM创建表示该异常的对象，将该对象交给运行时系统处理
			System.out.println( a + " / " + b + " = " + c  );
		} finally {
			System.out.println( "- - - finally - - -" );
		}
		
		System.out.println( "main end ." ); // 因为前面没有 catch 异常，所以这里不输出

	}

}
