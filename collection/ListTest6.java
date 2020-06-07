package cn.oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1、将 数组 转换为 List 集合
 *      1>、使用 Arrays.asList( T... elements )  实现 [ 在 Java 9 之前 ]
 *      2>、使用 List.of( E... elements) 实现 [ 从 Java 9 开始 ]
 * 2、为了支持 添加、删除、替换、排序 等操作，
 *       需要重新创建 java.util.ArrayList 实例，
 *       并将 Arrays.asList 或 List.of 转换后的 List 实例中的所有元素包含进来
 */
public class ListTest6 {

	public static void main(String[] args) {
		
		List<Integer> list = null ;
		
		final Integer[]  array = { 99 , 100 , 5 , 200 , 10 , 300 , 86 }; // auto-boxing
		// 在 Java 9 之前是使用 Arrays.asList( T... elements ) 方法实现
		List<Integer> alist = Arrays.asList( array ); // 将数组转换为一个 定长的List实例 ( java.util.Arrays$ArrayList 类型)
		System.out.println( alist );
		array[ 0 ] = 199 ; 
		System.out.println( alist );
		// 根据 数组转换后的 List 重新创建一个 ArrayList 实例，该实例包含了 数组对应的 List 中所有元素
		list = new ArrayList<Integer>( alist ); // ArrayList( Collection<? extends E> c )
		System.out.println( list );
		list.add( 9527 );
		System.out.println( list );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 从 Java 9 开始可以使用 List.of( E... elements ) 方法实现
		List<Integer>  immutableList = List.of( array );
		System.out.println( immutableList );
		list = new ArrayList<Integer>( immutableList ); 
		System.out.println( list );
		list.add( 8526 );
		System.out.println( list );
		
	}

}
