package ecut.map;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PandaTest {

	public static void main(String[] args) {
		
		Panda p = new Panda( "团团" , LocalDate.of( 2018 , 8 ,  10 ) , 15000 );
		Panda a = new Panda( "团团" , LocalDate.of( 2018 , 8 ,  10 ) , 15000 );
		
		System.out.println( p == a ); // false
		System.out.println( p.equals( a ) ); // true
		System.out.println( p.hashCode() == a.hashCode() ); // true
		
		Map<Panda,String> map = new HashMap<>();
		
		map.put( p , "团团是只不可爱的熊猫" );
		
		System.out.println( map );
		
		System.out.println( map.containsKey( p ) ); // true
		System.out.println( map.containsKey( a ) ); // true
		
		System.out.println( map.remove( a ) ) ; // true
		
		System.out.println( map );

	}

}
