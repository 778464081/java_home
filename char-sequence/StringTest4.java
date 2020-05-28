package cn.oracle;

/**
 * 1、将 基本数据类型的值 转换为 字符串形式 :  valueOf( boolean | char | int | long | float | double  )
 * 2、public	static	String	valueOf( char[] data )
 * 3、public	static	String	valueOf( char[] data , int offset , int count )
 * 4、public	static	String	valueOf( Object o )
 */
public class StringTest4 {

	public static void main(String[] args) {
		
		boolean z = true ;
		String s = String.valueOf( z );
		StringHelper.perspective( s );
		s.hashCode();
		StringHelper.perspective( s );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		char[] chars = { '春' , '眠' , '不' , '觉' , '晓' , '处' , '处' , '闻' , '啼' , '鸟' };
		
		String x = String.valueOf( chars );
		System.out.println( x );
		
		String t = String.valueOf( chars , 7 , 3 ) ; // 如果超出范围会抛出 StringIndexOutOfBoundsException
		System.out.println( t );
		
		Object o = Integer.valueOf( 9527 );
		String u = String.valueOf( o ) ;
		System.out.println( u );

	}

}
