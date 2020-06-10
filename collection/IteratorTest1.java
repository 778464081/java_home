package cn.oracle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * java.util.Iterator 接口中的抽象方法:  hasNext() 、next() 、remove()
 */
public class IteratorTest1 {

	public static void main(String[] args) {
		
		List<String> x = new ArrayList<String>();
		x.add( "周勃" );
		x.add( "卫青" );
		x.add( "霍去病" );
		x.add( "岳飞" );
		x.add( "文天祥" );
		x.add( "辛弃疾" );
		
		Iterator<String> t = x.iterator(); // 获得一个可以迭代 x 的 迭代器
		
		while( t.hasNext() ) { // 判断是否存在下一个元素
			String s = t.next(); // 获取下一个元素
			// 判断目前已经获取到的元素是否是 "霍去病"
			if( s.equals( "霍去病" ) ) {
				// x.remove( "霍去病" ); // [ 快速失败 ] JVM 会尽可能抛出 java.util.ConcurrentModificationException 
				// 当使用 迭代器 或 "for-each loop" 语句 迭代集合时，
				// 如果需要删除集合中的元素，应该使用 迭代器的 remove 方法，而不是集合本身的方法 ( 比如 x.remove( "霍去病" ) )
				t.remove(); // 删除目前已经获取到的元素 ( 即刚刚调用 next 方法获取到谁就删除谁 )
			}
		}

	}

}
