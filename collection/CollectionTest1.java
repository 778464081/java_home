package cn.oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 测试 Collection 接口中的 size / isEmpty / contains / remove / toArray / clear
 */
public class CollectionTest1 {

	public static void main(String[] args) {
		
		// Eclipse 快捷键 : ctrl + shift + o 快速修复代码
		Collection<Object> collection = new ArrayList<Object>();
		System.out.println( "size : " + collection.size() + " , is empty : " + collection.isEmpty() );
		
		collection.add( "吴老二" );
		collection.add( 9527 );
		collection.add( '中' );
		collection.add( null );
		
		System.out.println( "size : " + collection.size() + " , is empty : " + collection.isEmpty() );
		
		System.out.println( collection ); // toString()
		
		System.out.println( collection.contains( "吴老二" ) ); // true
		System.out.println( collection.contains( "null" ) ); // false
		
		System.out.println( collection.remove( "null" ) ); // false
		System.out.println( collection );
		
		System.out.println( collection.remove( null ) ); // true
		System.out.println( collection );
		
		Object[] array = collection.toArray();
		System.out.println( Arrays.toString( array ) );
		
		collection.clear();
		System.out.println( collection );
		
		System.out.println( "size : " + collection.size() + " , is empty : " + collection.isEmpty() );

	}

}
