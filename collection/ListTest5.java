package cn.oracle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1、不可变的 List  ( Immutable List ) 不支持任何修改操作
 * 		 List.of 方法返回的 List 实例都是 不可变的
 * 2、java.util.Arrays 类中的 asList( T... a ) 返回的 List 实例是 Arrays 类的 内部类类型 ( ArrayList )，
 *      这种集合支持 set( index , element) 操作 和 排序操作 ，不支持 remove 操作和 add 操作，
 *      同时其长度是固定的 ( 有人称作 定长List )。
 * 3、ArrayList 类的实例 支持 修改操作( add / remove / set ) 、支持 迭代操作 、支持排序
 */
public class ListTest5 {

	public static void main(String[] args) {
		
		List<String> list = null ;
		Class<?> c = null ;
		
		// 从 Java 9 开始 List 接口中声明了一批 of 方法，用于返回 【不可变的 List 实例】
		list = List.of( "韩信" , "晁错" , "窦婴" , "李广" , "李敢" , "李凌" );
		System.out.println( list );
		
		c = list.getClass();
		System.out.println( c.getName() ); // java.util.ImmutableCollections$ListN
		
		// 尝试修改一个不可变的 List 实例会抛出 UnsupportedOperationException
		// list.add( "李敢" ); // java.lang.UnsupportedOperationException
		// list.remove(1); // UnsupportedOperationException
		// list.clear(); // UnsupportedOperationException
		// list.set( 3 ,  "李将军" ); // UnsupportedOperationException
		// Collections.sort( list ); // UnsupportedOperationException
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		list = Arrays.asList("李广" , "李敢" , "李凌" );
		System.out.println( list );
		c = list.getClass();
		System.out.println( c.getName() ); // java.util.Arrays$ArrayList
		
		// list.add( "李敢" ); // UnsupportedOperationException
		// list.remove(1); // UnsupportedOperationException
		// list.clear(); // UnsupportedOperationException
		
		list.set( 0 ,  "李将军" ); // 支持替换操作
		System.out.println( list );
		
		Collections.sort( list ); 
		System.out.println( list );
		
	}

}
