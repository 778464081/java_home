package ecut.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashtableTest {

	public static void main(String[] args) {
		
		Map<String,Integer> map = null ;
		
		map = new HashMap<String, Integer>(); // 在 Java 7 开始允许写作 new HashMap<>()
		
		map.put( "xyz" , 20 );
		map.put( null ,  100 );
		map.put( "hello" , null );
		System.out.println( map );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		map = new Hashtable<>(); // 在 Java 7 之前需要写作 new Hashtable<String, Integer>()
		
		map.put( "xyz" , 20 );
		// map.put( null ,  100 ); // NullPointerException
		// map.put( "hello" , null ); // NullPointerException
		map.put( "abs" ,  100 );
		map.put( "min" , 0 );
		System.out.println( map );

	}

}
