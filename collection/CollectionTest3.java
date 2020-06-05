package cn.oracle;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 测试 Collection 接口中的 retainAll / hashCode / equals
 */
public class CollectionTest3 {

	public static void main(String[] args) {
		
		// 注意这里在 < > 中间使用的是 String
		Collection<String> first = new ArrayList<String>();
		first.add( "李广" );
		first.add( "唐三藏" );
		first.add( "孙悟空" );
		first.add( "宋江" );
		first.add( "花荣" );
		
		Collection<String> second = new ArrayList<String>();
		second.add( "李广" );
		second.add( "李敢" );
		second.add( "李凌" );
		
		System.out.println( "first => " + first );
		System.out.println( "second => " + second );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 顺"参"者昌逆"参"者亡
		// 如果 当前 collection  中所包含的元素 在 参数指定的 collection 中也存在，则保留下来，否则统统删除 
		System.out.println( first.retainAll( second ) ); // true : 如果当前 collection 由于调用 retainAll 而发生更改，则返回 true
		
		System.out.println( "first => " + first );
		System.out.println( "second => " + second );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Collection<String> third = new ArrayList<String>( second );
		System.out.println( "third => " + third );
		System.out.println( "second => " + second );
		
		System.out.println( second.hashCode() );
		System.out.println( third.hashCode() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		System.out.println( second == third ); // false
		System.out.println( System.identityHashCode( second ) );
		System.out.println( System.identityHashCode( third ) );
		System.out.println( second.equals( third ) ); // true

	}

}
