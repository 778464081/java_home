package ecut.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、声明 Map 变量时，可以分别指定 映射项 中 键 和 值 的类型，
 * 		 比如 Map< String , Integer > 中 String 是 键的类型，Integer 是 值的类型
 * 2、V put( K key , V value ) : 将 指定的值 ( value ) 与 Map 中的指定键 ( key ) 关联
 * 3、V remove( K key ) : 根据 key 从 Map 中删除指定 映射项(键值对) 并返回该 映射项(键值对) 的值
 *
 */
public class MapTest1 {

	public static void main(String[] args) {
		
		// Map< K , V >
		Map<String,Integer> map = new HashMap<>();
		
		// 将 指定的值 ( value ) 与 Map 中的指定键 ( key ) 关联
		Integer value = map.put( "张三丰" , 108 );
		System.out.println( value );
		
		// map.put( K ,  V);
		value = map.put( "张翠山" , 36 );
		System.out.println( value );
		
		value = map.put( "张无忌" , 8 );
		System.out.println( value );
		
		System.out.println( map );
		
		value = map.put( "张无忌" , 10 );
		System.out.println( value );
		
		System.out.println( map );
		
		value = map.remove( "张翠山" ); // 根据 key 删除 映射项 (键值对)
		System.out.println( value );
		
		System.out.println( map );

	}

}
