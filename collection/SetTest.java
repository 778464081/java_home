package ecut.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 1、在 HashSet 内部借助于一个 HashMap 来存储 元素
 * 2、向 HashSet 实例中添加的元素 都作为 HashMap 的 key 添加到了 Map 集合中
 */
public class SetTest {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
		System.out.println( set.add( "张三丰" ) );  // map.put( "张三丰" , PRESENT );
		System.out.println( set.add( "张君宝" ) );  // map.put( "张君宝" , PRESENT );
		System.out.println( set.add( "张翠山" ) );  // map.put( "张翠山" , PRESENT );
		
		System.out.println( set );
		
		System.out.println( set.add( "张翠山" ) ); // false : map.put( "张翠山" , PRESENT) == null
		System.out.println( set );
		
		System.out.println(set.remove( "张翠山" ) ); // true
		System.out.println( set );
		
		System.out.println( set.remove( "殷素素" ) ); // false
		System.out.println( set );

	}

}
