package cn.oracle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 1、测试 Collection 接口中的 iterator
 * 2、什么是 迭代器 ( Iterator )
 */
public class CollectionTest4 {

	public static void main(String[] args) {
		
		// 注意这里在 < > 中间使用的是 String
		Collection<String> c = new ArrayList<String>();
		c.add( "李广" );
		c.add( "唐三藏" );
		c.add( "孙悟空" );
		c.add( "宋江" );
		c.add( "花荣" );
		c.add( "李广" );
		c.add( "李敢" );
		c.add( "李凌" );
		
		System.out.println( "for-each loop : " );
		
		// 对于 Iterable 实例来说，根本就没有什么 增强的 for 循环，本质上还是使用 迭代器完成迭代
		for( String s : c ) {
			System.out.println( s ); 
		}
	
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 用来完成 安全检查操作 的 机器 就是 安检设备
		// 用来完成 迭代集合操作 的 对象 就是 迭代器
		Iterator<String> itor = c.iterator(); // 返回一个可以 迭代 集合 c 中所包含元素的 迭代器 
		
		while( itor.hasNext() ) { // 判断是否存在下一个元素
			String e = itor.next() ; // 获取下一个元素
			System.out.println( e );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		for( Iterator<String> it = c.iterator(); it.hasNext() ; ) {
			String e = it.next();
			System.out.println( e );
		}
		
	}

}
