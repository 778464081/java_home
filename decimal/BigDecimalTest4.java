package cn.edu.ecut;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest4 {

	public static void main(String[] args) {
		
		BigInteger unscaledValue = null ;
		int scale = 0 ;
		BigDecimal x = null ;
		
		// 在字符串形式中就使用了 正负号
		final String value = "-3141592653589793238462643383279";
		unscaledValue = new BigInteger( value );
		scale = value.length() - 2 ; // 因为为圆周率的小数点之前只有一位数字
		
		// 根据 非标度值 和 标度值 来创建一个 BigDecimal 实例
		x = new BigDecimal( unscaledValue , scale ); // ( BigInteger , int )
		System.out.println( x );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		unscaledValue = new BigInteger( "3141592653589793238462643383279" );
		System.out.println( System.identityHashCode( unscaledValue ) );
		
		// 通过 BigInteger 实例来取相反数
		unscaledValue = unscaledValue.negate(); // 取相反数
		System.out.println( System.identityHashCode( unscaledValue ) );
		
		x = new BigDecimal( unscaledValue , scale ); // ( BigInteger , int )
		System.out.println( x );

	}

}
