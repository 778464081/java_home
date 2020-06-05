package cn.oracle;

import java.util.ArrayList;
import java.util.List;

/**
 * List 接口中声明的方法 : add(int,E) / remove(int) / set(int, E) / subList(int, int)
 */
public class ListTest2 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add( "卫青" );
		list.add( "霍去病" );
		list.add( "岳飞" );
		list.add( "文天祥" );
		
		// list 集合中的 元素的存放顺序 与 当时的添加顺序 是相同的
		System.out.println( list );
		
		list.add( 2 , "辛弃疾" ); // void add( int index , E element )
		System.out.println( list );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		list.remove( 1 ); // 删除索引 1 处的元素
		
		System.out.println( list );
		
		String old = list.set( 2 ,  "霍去病" ); // E set( int index , E element )
		System.out.println( old );
		
		System.out.println( list );
		
		List<String> sub = list.subList( 1 ,  3 ) ; // List<E> subList( int from , int to )
		System.out.println( sub );

	}

}
