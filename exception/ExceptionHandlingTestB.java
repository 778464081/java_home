package cn.edu.ecut.exception;

import java.util.Arrays;

public class ExceptionHandlingTestB {
	
	static Object[] elements = new Object[ 10 ];

	public static void main(String[] args) {
		
		add( 2 , "二五零" );
		show();
		add( 250 , 250 );
		show();

	}
	
	public static void add( int index , Object element ) {
		if( index < 0 || index >= elements.length ) {
			// 指定异常实例中封装的 详细信息 ( 关于异常的描述信息 )
			String message = "索引必须是 [ 0 , " + elements.length + " ) 之间" ;
			// 创建异常实例
			ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException( message );
			// 注意，与 throws 关键字不同，throw 关键字之后跟的是 单个异常实例
			throw e ; // 抛出异常实例
		}
		elements[ index ] = element ;
	}
	
	public static void show() {
		System.out.println( Arrays.toString( elements ) );
	}

}
