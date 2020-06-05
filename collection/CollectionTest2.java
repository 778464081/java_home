package cn.oracle;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 测试 Collection 接口中的 addAll / containsAll / removeAll
 */
public class CollectionTest2 {

	public static void main(String[] args) {
		
		// 注意这里在 < > 中间使用的是 String
		Collection<String> first = new ArrayList<String>();
		first.add( "唐三藏" );
		first.add( "孙悟空" );
		first.add( "宋江" );
		first.add( "花荣" );
		System.out.println( "first => " + first );
		
		Collection<String> second = new ArrayList<String>();
		second.add( "李广" );
		second.add( "李敢" );
		second.add( "李凌" );
		System.out.println( "second => " + second );
		
		// addAll( Collection ) 将 参数对应的集合中的元素全部添加到 当前集合中
		System.out.println( first.addAll( second ) );  // true
		System.out.println( "first => " + first );
		
		System.out.println( first.containsAll( second ) ); // true
		
		first.remove( "李凌" ); // 删除 "李凌"
		System.out.println( "first => " + first );
		System.out.println( "second => " + second );
		
		// 当 containsAll 参数指定的集合 中包含的元素 全部都在 当前集合 中存在时返回 true  ，否则返回 false
		System.out.println( first.containsAll( second ) ); // false
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 当 removeAll 参数指定的集合 中所包含的元素 存在于 当前集合 时，就从 当前集合 中删除该元素
		// 如果因为调用 removeAll 导致 当前集合 发生变化就返回 true， 否则返回 false
		System.out.println( first.removeAll( second ) ) ; // true
		
		System.out.println( "first => " + first );
		System.out.println( "second => " + second );
		

	}

}
