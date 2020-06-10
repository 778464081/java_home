package cn.oracle;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 1、java.util.ListIterator 接口是 java.util.Iterator 接口的子接口
 * 2、ListIterator 接口中的抽象方法:
 * 			boolean hasNext() ;
 * 			E next();
 * 			int nextIndex();
 * 			void remove();
 * 			void set( E e );
 * 			void add( E e );
 * 			int previousIndex();
 * 			E previous();
 * 			boolean hasPrevious();	 
 */
public class IteratorTest2 {

	public static void main(String[] args) {
		
		List<String> x = new ArrayList<String>();
		x.add( "周勃" );
		x.add( "卫青" );
		x.add( "霍去病" );
		x.add( "岳飞" );
		x.add( "文天祥" );
		x.add( "辛弃疾" );
		
		ListIterator<String> t = x.listIterator();
		
		while( t.hasNext() ) { // 是否有下一个元素
			String s = t.next(); // 获取下一个元素
			if( s.contentEquals( "霍去病" ) ) { // contentEquals 是 String 类中的方法
				// 使用参数指定的对象 替换 目前已经获取到的元素
				t.set( "霍光" );  // ( 即刚刚调用 next 方法获取到谁就替换谁，集合中的数据会因此而发生改变 )
			}
		}
		
		System.out.println( x );
		
		while( t.hasPrevious() ) { // 是否有前一个元素
			String s = t.previous() ; // 获取前一个元素
			if( s.contentEquals( "霍光" ) ) {
				// 将参数指定的对象 添加到 目前已经获取到的元素 之前 ( List是有顺序存放的 )
				t.add( "霍去病" );
			}
		}
		
		System.out.println( x );
		
		// List 接口中提供的 listIterator( int beginIndex ) 方法用于获取可以迭代 beginIndex 及之后的元素的迭代器
		ListIterator<String> itor = x.listIterator( 4 ); // 获取新的迭代器对象，用于迭代 索引 4 及其之后的元素
		while( itor.hasNext() ) {
			System.out.println( itor.next() );
		}

	}

}
