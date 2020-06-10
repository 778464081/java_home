package ecut.map;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfTest {

	public static void main(String[] args) {
		
		List<String> list = List.of( "刘备" , "关羽" , "张飞" , "刘备" , "关羽" , "张飞" );
		System.out.println( list );
		System.out.println( list.getClass() ); // class java.util.ImmutableCollections$ListN
		// list.add( "赵云" ); // UnsupportedOperationException
		
		// Set<String> set = Set.of( "刘备" , "关羽" , "张飞" , "刘备" , "关羽" , "张飞" ); // IllegalArgumentException: duplicate element: 刘备
		Set<String> set = Set.of( "刘备" , "关羽" , "张飞" );
		System.out.println( set );
		System.out.println( set.getClass() );
		// set.add( "赵云" ); // UnsupportedOperationException
		
		Map<String,Integer> map = Map.of( "红烧茄子" , 12 , "鱼香肉丝" , 15 , "藜蒿炒腊肉" , 18 , "蒜苗回锅肉" , 16 );
		System.out.println( map );
		System.out.println( map.getClass() );
		// map.put( "小酥肉" , 22 ); // UnsupportedOperationException

	}

}
