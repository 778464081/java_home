package ecut.map;

import java.util.TreeMap;

public class TreeMapTest1 {

	public static void main(String[] args) {
		
		TreeMap<Integer,String> ts = new TreeMap<>();
		
		ts.put( 100 ,  "百" );
		ts.put( 10 ,  "十" );
		ts.put( 50 ,  "半百" );
		ts.put( 1000 ,  "千" );
		ts.put( 0 ,  "个" );
		
		System.out.println( ts );
		
		// ts.put( null ,  "空的" ); // java.lang.NullPointerException
		
		ts.put( -1 , null ); // 没问题，可以放入到 Map 集合中
		System.out.println( ts );

	}

}
