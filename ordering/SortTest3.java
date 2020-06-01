package cn.edu.ecut;

import java.util.Arrays;

/**
 * 即使是使用冒泡排序，也可以借助于被排序对象的 compareTo 方法来实现比较
 */
public class SortTest3 {

	public static void main(String[] args) {
		
		Monkey[] monkeies = {
											new Monkey( "美猴王" , 5 , 30 ) ,
											new Monkey( "孙悟空" , 6 , 32 ) ,
											new Monkey( "弼马温" , 4 , 25 ) ,
											new Monkey( "齐天大圣" , 3 , 20 ) , 
											new Monkey( "孙行者" , 7 , 31 )
										};
		
		System.out.println( Arrays.toString( monkeies ) );
		
		for( int i = 0 ; i < monkeies.length - 1 ; i++ ) {
			for( int j = 0 ; j < monkeies.length - 1 - i ; j++ ) {
				if( monkeies[ j ].compareTo( monkeies[ j + 1 ] ) > 0 ) { // if( monkeies[ j ] > monkeies[ j + 1 ] ) {
					Monkey t = monkeies[ j ] ;
					monkeies[ j ] = monkeies[ j + 1 ] ;
					monkeies[ j + 1 ] = t ;
				}
			}
		}
		
		System.out.println( Arrays.toString( monkeies ) );

	}

}
