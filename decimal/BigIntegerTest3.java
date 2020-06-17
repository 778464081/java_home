package cn.edu.ecut;

import java.math.BigInteger;

/**
 */
public class BigIntegerTest3 {

	public static void main(String[] args) {
		
		final byte[] bytes = { -1 , 99 };
		
		BigInteger x = new BigInteger( "9527" ); // 按照十进制解析字符串
		System.out.println( x );
		
		BigInteger y = new BigInteger( bytes );
		System.out.println( y );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigInteger z = x.add( y );
		
		System.out.println( "z = " + z );
		System.out.println( "x = " + x );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigInteger a = x.not(); //返回其值为 (~this) 的 BigInteger
		System.out.println( "a = " + a );
		System.out.println( "x = " + x );
		
		BigInteger b = x.negate();
		System.out.println( "b = " + b );//返回其值为 (-this) 的 BigInteger
		System.out.println( "x = " + x );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigInteger c = x.shiftLeft( 1 ); // x << 1 
		System.out.println( "c = " + c + " , x = " + x );
		
		BigInteger d = y.shiftLeft( 1 ); // y >> 1
		System.out.println( "d = " + d + " , y = " + y );

	}

}
