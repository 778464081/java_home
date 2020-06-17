package cn.edu.ecut;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 1、将一个 十六进制的、字符串形式的 整数解析为 数字后创建与之相应的 BigInteger 实例
 * 2、BigInteger 的 toByteArray 返回一个包含了当前的 BigInteger 的二进制补码表示形式的 byte 数组
 */
public class BigIntegerTest1 {

	public static void main(String[] args) {
		
		String value = "8fa3";
		int radix = 16 ;
		
		BigInteger b = new BigInteger( value , radix );
		System.out.println( b ); // b.toString()
		
		// 返回一个 byte 数组，该数组包含此 BigInteger 的二进制补码表示形式
		byte[] bytes = b.toByteArray();
		System.out.println( Arrays.toString( bytes ) );
		
		for( int i = 0 ; i < bytes.length ; i++ ) {
			byte t = bytes[ i ];
			String s = Integer.toBinaryString( t );
			if( s.length() > 24 ) {
				s = s.substring( 24 );
			}
			System.out.println( s );
		}
		
		int y = 0b0000_0000_0000_0000_1000_1111_1010_0011;
		System.out.println( y );

	}

}
