package cn.edu.ecut;

import java.util.Arrays;

/**
 * 理解 String 类的 compareTo 在比较什么
 * 1、纯 英文 时，直接比较 String 实例内部的 字节数组 [ 大致思路 ]
 * 2、非 纯英文 时，需要比较 String 实例 中的 字符  [ 大致思路 ]
 */
public class SortTest4 {

	public static void main(String[] args) {
		
		String[] numbers = { "九" , "一" , "八" , "四" , "七" , "三" , "六" , "二" , "五" };
		System.out.println( Arrays.toString( numbers ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String s = String.join( "" , numbers );
		char[] array = new char[ s.length() ];
		s.getChars( 0 ,  s.length() ,  array ,  0 );
		System.out.println( Arrays.toString( array ) );
		Arrays.sort( array );
		System.out.println( Arrays.toString( array ) );
		
		for( int i = 0 , n = array.length ; i < n ; i++ ) {
			System.out.print( array[ i ] + 0 );
			System.out.print( i < n - 1 ? " , " : "\n" );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Arrays.sort( numbers );
		System.out.println( Arrays.toString( numbers ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String[] sa = { "hello" , "abd" , "abc" , "abcd" , "helloword" };
		System.out.println( Arrays.toString( sa ) );
		Arrays.sort( sa );
		System.out.println( Arrays.toString( sa ) );
		
	}

}
