package cn.edu.ecut;

import java.math.BigInteger;

/**
 * 使用 BigInteger( byte[] ) 根据一个 byte 数组构造一个与之对应的  BigInteger 实例
 */
public class BigIntegerTest2 {

	public static void main(String[] args) {
		
		byte[] bytes = { -1 , 98 , -113 , 99 };
		
		String x = "" ;
		for( int i = 0 ; i < bytes.length ; i++ ) {
			byte t = bytes[ i ];
			String s = Integer.toBinaryString( t );
			if( t > 0 ) {
				// 正数 补够8位
				for( int j = 8 , n = s.length() ; j > n ; j-- ) {
					s = "0" + s ;
				}
			} else if( t == 0 ){
				s = "00000000";
			} else {
				// 负数 截取 低8位
				if( s.length() > 24 ) {
					s = s.substring( 24 );
				}
			}
			System.out.println( s );
			x += s ;// x = x + s ;
		}
		
		System.out.println( x );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		System.out.println( 0b11111111_01100010_10001111_01100011 ); // -10317981
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigInteger h = new BigInteger( bytes ) ;
		System.out.println( h );
		

	}

}
