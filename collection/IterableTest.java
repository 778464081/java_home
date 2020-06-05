package cn.oracle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 1、for-each loop  ( for-each 循环 ，国内很多资料上将 for-each 称作 增强for循环 )
 *      for( 类型  变量 : Iterable实例 或 数组 ) {
 *		 }
 * 2、Implementing interface Iterable allows an object to be the target of the enhanced for statement 
 * 		(sometimes called the "for-each loop" statement).
 */
public class IterableTest {

	public static void main(String[] args) {
		
		int[] array = { 100 , 200 , 300 , 400 };
		
		for( int i = 0 ; i < array.length ; i++ ) {
			int x = array[ i ];
			System.out.println( x );
		}
		
		System.out.println( "for-each loop : " );
		for( int x : array ) {
			System.out.println( x );
		}
		
		// 有黄色小灯泡警告不必理会
		Collection<Object> collection = new ArrayList<Object>();
		
		collection.add( "扈三娘" );
		collection.add( "孙尚香" );
		collection.add( "石榴姐" );
		collection.add( "公孙离" );
		
		for( Object o : collection ) {
			System.out.println( o );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Iterator<Object> iterator = collection.iterator();
		
		while( iterator.hasNext() ) {
			Object o = iterator.next();
			System.out.println( o );
		}

	}

}
