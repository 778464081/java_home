package ecut.map;

import java.util.Arrays;

public class HashTest2 {

	public static void main(String[] args) {
		
		int value  ;
		int index ;
		
		int[] array = new int[ 10 ];
		System.out.println( Arrays.toString( array ) );
		
		value = 7 ;
		// 通过某种规则可以计算出 某个值 应该存放在数组的哪个位置
		index = hash( value , array.length ) ;
		array[ index ] = value ;
		System.out.println( Arrays.toString( array ) );
		
		value = 87 ;
		// 通过某种规则可以计算出 某个值 应该存放在数组的哪个位置
		index = hash( value , array.length ) ;
		array[ index ] = value ;
		System.out.println( Arrays.toString( array ) );

	}
	
	public static int hash( int value , int length ) {
		// 根据 某个值 和 数组 长度 计算 该值应该在数组的哪个位置存放
		return value % length ;
	}

}
