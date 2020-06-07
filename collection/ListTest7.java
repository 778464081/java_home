package cn.oracle;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于一个包含了一组 Integer 类型数据的 List 集合来说 remove( 1 ) 是删除谁
 */
public class ListTest7 {

	public static void main(String[] args) {
		
		List<Integer> list = null ;
		
		// 得到一个不可变的List实例
		list = List.of( 13 , 9 , 1 , 3 , 7 , 5 , 11 ) ; // 自动装箱( auto-boxing )
		System.out.println( list + " ==> " + list.getClass().getName() );
		
		list = new ArrayList<Integer>( list );
		System.out.println( list + " ==> " + list.getClass().getName() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		System.out.println( list );
		
		// 根据索引删除元素时，索引的有效范围是 [ 0 , list.size() - 1 ] 
		Integer deleted = list.remove( 1 ) ; // 根据参数匹配于【 E remove( int index ) 】
		System.out.println( "被删除的元素是: " + deleted );
		System.out.println( list );
		
		list.remove( Integer.valueOf( 13 ) ); // 根据参数匹配与【 void remove( Object o ) 】
		System.out.println( list );
	
	}

}
