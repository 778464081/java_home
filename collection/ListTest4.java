package cn.oracle;

import java.util.List;
import java.util.ListIterator;

/**
 * 1、List 接口中的类方法: of
 * 2、java.util.ListIterator
 */
public class ListTest4 {

	public static void main(String[] args) {
		
		// 从 Java 9 开始 List 接口中声明了一批 of 方法，用于返回 【定长】的 List 集合
		List<String> list = List.of( "韩信" , "晁错" , "窦婴" , "李广" , "李敢" , "李凌" );
		System.out.println( list );
		// list.add( "李敢" ); // java.lang.UnsupportedOperationException
		
		for( int i = 0 , n = list.size() ; i < n ; i++ ) {
			System.out.println( list.get( i ) );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~" );
		
		for( int i = list.size() - 1 ; i >= 0 ; i-- ) {
			System.out.println( list.get( i ) );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~" );
		
		ListIterator<String> listIterator = list.listIterator();
		
		while( listIterator.hasNext() ) {
			int index = listIterator.nextIndex() ;
			String element = listIterator.next();
			System.out.println( index + " - " + element );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~" );
		
		while( listIterator.hasPrevious() ) {
			int index = listIterator.previousIndex() ;
			String element = listIterator.previous();
			System.out.println( index + " - " + element );
		}

	}

}
