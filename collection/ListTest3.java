package cn.oracle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest3 {

	public static void main(String[] args) {
		
		List<String> list1 = new ArrayList<String>();
		list1.add( "周勃" );
		list1.add( "卫青" );
		list1.add( "霍去病" );
		list1.add( "岳飞" );
		
		List<String> list2 = new ArrayList<String>();
		list2.add( "文天祥" );
		list2.add( "辛弃疾" );
		
		list1.addAll( 3 , list2 ) ; // boolean  addAll( int index, Collection<? extends E> c )
		
		System.out.println( list1 );
		
		System.out.println( "~ ~ ~ ~ ~ ~" );

		for( int i = 0 ; i < list1.size() ; i++ ) {
			String x = list1.get( i );
			System.out.println( x );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~" );
		
		Iterator<String> itor = list1.iterator();
		
		while( itor.hasNext() ) {
			String x = itor.next();
			System.out.println( x );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~" );
		
		for( String x : list1 ) {
			System.out.println( x );
		}

	}

}
