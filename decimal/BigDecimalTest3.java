package cn.edu.ecut;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest3 {

	public static void main(String[] args) {
		
		final String value = "3141592653589793238462643383279";
		// 采用 BigInteger 实例所表示的不可变的任意精度的整数 来充当 非标度值 ( unscaledValue )
		final BigInteger unscaledValue = new BigInteger( value );
		// 根据实际需要来指定 标度 ( scale ) 值
		final int scale = value.length() - 1 ; // 因为为圆周率的小数点之前只有一位数字
		
		// 根据 非标度值 和 标度值 来创建一个 BigDecimal 实例，用来表示 不可变的、任意进度的十进制数
		final BigDecimal pi = new BigDecimal( unscaledValue , scale ); // ( BigInteger , int )
		System.out.println( pi );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigDecimal radius = BigDecimal.valueOf( 2.5 ); // ( double )
		System.out.println( "半径: " + radius );
		
		BigDecimal x = radius.pow( 2 ); // 求平方，返回一个新的 BigDecimal 实例
		System.out.println( "半径的平方: " + x );
		
		BigDecimal area = pi.multiply( x ); // 求 pi 乘以 x 的 积
		System.out.println( "半径为" + radius + "的圆面积为" + area );

	}

}
