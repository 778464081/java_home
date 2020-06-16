package cn.edu.ecut;

import java.math.BigDecimal;

/**
 * 1、借助于 java.math.BigDecimal 类中提供的方法可以实现 精确计算
 * 2、通过 java.math.BigDecimal 类提供的方法可以完成 "大数据" 的计算
 */
public class DecimalTest2 {

	public static void main(String[] args) {
		
		BigDecimal a = BigDecimal.valueOf( 31 , 1 ) ; // double a = 3.1 ;
		System.out.println( a );
		
		BigDecimal b = BigDecimal.valueOf( 27 , 1 ) ; // double b = 2.7 ;
		System.out.println( b );
		
		
		BigDecimal c = a.add( b ); // double c = a + b ;
		System.out.println( c );
		
		BigDecimal d = a.subtract( b ) ; // double d = a - b ;
		System.out.println( d );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		
		System.out.println( Double.MAX_VALUE );
		
		// double x = 1.8 * Math.pow( 10 , 308 ); // 超出 基本数据类型所表示的数值的 最大范围
		BigDecimal x = BigDecimal.valueOf( 18 , -307 );
		System.out.println( x );
		
		
		//double y = 1.8 * Math.pow( 10 , 1000 ); // 超出 基本数据类型所表示的数值的 最大范围
		BigDecimal y = BigDecimal.valueOf( 18 , -999 );
		System.out.println( y );
		
		BigDecimal z = y.add( y );
		System.out.println( z );

	}

}
