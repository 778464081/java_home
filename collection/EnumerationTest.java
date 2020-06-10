package ecut.map;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 1、建议使用 Iterator 而不是 Enumeration
 * 2、Enumeration 接口中只有两个方法: hasMoreElements() 、nextElement()
 * 3、Hashtable 类的 keys() 方法返回用于 迭代所有 映射项 的 key 的 Enumeration 对象
 * 4、Hashtable 类的 elements() 方法返回用于 迭代所有 映射项 的 value 的 Enumeration 对象
 */
public class EnumerationTest {

	public static void main(String[] args) {
		
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		ht.put( "藜蒿炒腊肉" , 10 );
		ht.put( "蒜苗回锅肉" , 12 );
		ht.put( "土豆片回锅肉" , 12 );
		ht.put( "毛血旺" , 10 );
		ht.put( "蒜苗回锅肉" , 15 );
		
		System.out.println( ht );
		
		Enumeration<String> keys = ht.keys();
		
		while( keys.hasMoreElements() ) {
			String key = keys.nextElement();
			System.out.println( key );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Enumeration<Integer> values = ht.elements();
		while( values.hasMoreElements() ) {
			Integer value = values.nextElement();
			System.out.println( value );
		}
		
	}

}
