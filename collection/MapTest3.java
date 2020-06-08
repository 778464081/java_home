package ecut.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 1、键集 : 所有的 映射项 的 键 组成的 Set 集合 ，通过 keySet() 方法获取
 * 2、值集 : 所有的 映射项 的 值 组成的 Collection 集合，通过 values() 方法来获取
 * 3、键-值映射关系集 : 就是 映射项 集合，所有的 映射项 组成的 Set 集合，通过 entrySet() 来获取
 * 4、本例中，对 三种 集合 都采用了迭代器来迭代
 */
public class MapTest3 {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		System.out.println("size : " + map.size() + " , is empty : " + map.isEmpty());

		map.put("藜蒿炒腊肉", 10);
		map.put("蒜苗回锅肉", 12);
		map.put("土豆片回锅肉", 12);
		map.put("毛血旺", 10);

		System.out.println(map); // { key = value , key = value , .... }

		// 获得 Map 中 所有 映射项 的 键 组成的 Set 集合
		Set<String> keySet = map.keySet(); // Collection<String> keySet = map.keySet();
		// Set 是 Collection 的子接口，所以可以将 Set 实例当做 Collection 来处理
		Iterator<String> iterator = keySet.iterator(); // 获取 Collection 的 迭代器
		// 使用迭代器迭代集合
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println( key ); // System.out.println( key + " : " + map.get( key ) );
		}

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

		Collection<Integer> values = map.values();
		Iterator<Integer> itor = values.iterator();
		// 使用迭代器迭代集合
		while (itor.hasNext()) {
			Integer value = itor.next();
			System.out.println(value);
		}
		
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
		
		// 从 Map 中获取 所有的 映射项 ( Map.Entry ) 组成的 Set 集合
		// 每个 映射项 就是一个 Map.Entry 实例，其中包括了 键 ( key ) 和 值 ( value ) 
		Set< Map.Entry< String , Integer > > entrySet = map.entrySet();
		// Set 集合中的元素类型是 Map.Entry 类型，对于 Map.Entry 来说，其 键的类型是 String ，值的类型是 Integer
		
		Iterator< Map.Entry< String , Integer > > it = entrySet.iterator();
		
		while( it.hasNext() ) {
			Map.Entry< String , Integer > entry = it.next() ;
			System.out.println( entry.getKey() + " : " + entry.getValue() );
		}

	}

}
