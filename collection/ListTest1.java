package cn.oracle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * List 的特点是:  有序、可重复、可排序
 */
public class ListTest1 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add( "卫青" );
		list.add( "霍去病" );
		list.add( "岳飞" );
		list.add( "文天祥" );
		list.add( "辛弃疾" );
		
		// list 集合中的 元素的存放顺序 与 当时的添加顺序 是相同的
		System.out.println( list );
		
		list.add( 2 , "辛弃疾" ); // List 接口重新定义的方法
		System.out.println( list );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add( 100 );
		numbers.add( 88 );
		numbers.add( 95 );
		numbers.add( 6 );
		numbers.add( -1 );
		numbers.add( 1002 );
		numbers.add( 99 );
		
		System.out.println( numbers );
		
		// numbers 中的元素是 Integer ，而 Integer 是实现过 Comparable 接口的 ( 支持自然排序 )
		Collections.sort( numbers ); // 使用 java.util.Collections 类的 sort 方法对 List 集合进行排序
		
		System.out.println( numbers ); // 按照 自然顺序 排列

	}

}
