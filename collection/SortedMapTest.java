package ecut.map;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 1、SortedMap 表示一种整体上排好顺序的 映射项 集合
 * 2、SortedMap 中提供了以 有顺序存放的 映射项为基础的操作方法
 * 			firstKey() / lastKey() / headMap( toKey ) / tailMap( fromKey ) / subMap( fromKey , toKey )
 */
public class SortedMapTest {

	public static void main(String[] args) {
		
		SortedMap<Integer,String> map = new TreeMap<>();
		System.out.println( map );
		
		map.put( 100 ,  "百" );
		System.out.println( map );
		
		map.put( 10 ,  "十" );
		System.out.println( map );
		
		map.put( 50 ,  "半百" );
		System.out.println( map );
		
		map.put( 1000 ,  "千" );
		System.out.println( map );
		
		map.put( 0 ,  "个" );
		System.out.println( map );
		
		System.out.println( map.firstKey() ); // SortedMap 中 firstKey 获取 Map 中第一个 key
		System.out.println( map.lastKey() ); // SortedMap 中 firstKey 获取 Map 中最后一个 key
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		SortedMap<Integer,String> hm = map.headMap( 100 ); // headMap( toKey ) 用于截取 从头开始 到 toKey 前的 "子集"
		System.out.println( hm );
		
		SortedMap<Integer,String> tm = map.tailMap( 50 ); // tailMap( fromKey ) 用于截取 从 fromKey 开始 到 末尾 的 "子集"
		System.out.println( tm );
		
		SortedMap<Integer,String> sm = map.subMap( 10 ,  100 ); // 截取从 fromKey 到 toKey 之前的 "子集"
		System.out.println( sm );
		
	}

}
