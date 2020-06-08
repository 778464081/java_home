package ecut.map;

import java.util.HashMap;
import java.util.Map;

/**
 * size / isEmpty / containsKey / containsValue / get / clear
 */
public class MapTest2 {

	public static void main(String[] args) {
	
		Map<String,Integer> map = new HashMap<>();
		
		System.out.println( "size : " + map.size() + " , is empty : " + map.isEmpty() );
		
		map.put( "藜蒿炒腊肉" , 10 );
		map.put( "蒜苗回锅肉" , 12 );
		map.put( "土豆片回锅肉" , 12 );
		map.put( "毛血旺" , 10 );
		map.put( "蒜苗回锅肉" , 15 );
		
		System.out.println( map ); // { key = value , key = value , .... }
		
		System.out.println( "size : " + map.size() + " , is empty : " + map.isEmpty() );
		
		System.out.println( map.containsKey( "老碗鱼" ) ); // false
		System.out.println( map.containsKey( "藜蒿炒腊肉" ) ); // true
		
		System.out.println( map.containsValue( 12 ) ); // true
		System.out.println( map.containsValue( 120 ) ); // false
		
		System.out.println( map.get( "藜蒿炒腊肉" ) ); // 根据 key 获取 映射项 的值
		System.out.println( map.get( "老碗鱼" ) );
		
		map.clear(); // 清空集合
		
		System.out.println( map );
		
		System.out.println( "size : " + map.size() + " , is empty : " + map.isEmpty() );

	}

}
