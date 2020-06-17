package cn.edu.ecut;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest2 {

	public static void main(String[] args) {
		
		BigDecimal a = BigDecimal.valueOf( 100200300 ); // ( long )
		System.out.println( a );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigDecimal b = BigDecimal.valueOf( 3.14 ); // ( double )
		System.out.println( b );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigDecimal c = BigDecimal.valueOf( 3.14159265358979323846 ); // ( double )
		System.out.println( c );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~" );
		
		final long uv = 3141592653589793238L ;
		final int s = 18 ;
		BigDecimal d = BigDecimal.valueOf( uv , s ); // ( long , int )
		System.out.println( d );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~" );
		
		final String value = "3141592653589793238462643383279";
		// 采用 BigInteger 实例所表示的不可变的任意精度的整数 来充当 非标度值 ( unscaledValue )
		final BigInteger unscaledValue = new BigInteger( value );
		// 根据实际需要来指定 标度 ( scale ) 值
		final int scale = value.length() - 1 ; // 因为为圆周率的小数点之前只有一位数字
		
		// 根据 非标度值 和 标度值 来创建一个 BigDecimal 实例，用来表示 不可变的、任意进度的十进制数
		BigDecimal f = new BigDecimal( unscaledValue , scale ); // ( BigInteger , int )
		System.out.println( f );

	}

}
