package ecut.map;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {

	public static void main(String[] args) {
		
		SortedSet<Integer> set = new TreeSet<>();
		
		set.add( 10 );
		System.out.println( set );
		
		set.add( 7 );
		System.out.println( set );
		
		set.add( 1 );
		System.out.println( set );
		
		set.add( 2 );
		System.out.println( set );
		
		set.add( 5 );
		System.out.println( set );
		
		System.out.println( set.first() );
		
		System.out.println( set.last() );
		
		System.out.println( set.headSet( 5 ) );
		
		System.out.println( set.tailSet( 5 ) );
		
		System.out.println( set.subSet( 2 , 7 ) );

	}

}
