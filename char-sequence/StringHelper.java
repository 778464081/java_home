package cn.oracle;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * 这个类是一个工具，用于帮助我们认识 Stirng 内部存储结构，大家不需要懂
 */
public class StringHelper {
	
	private static Field valueField ; // value 字段
	private static Field coderField ; // coder 字段
	private static Field hashField ; // hash 字段
	
	static {
		Class<String> sc = String.class ;
		try {
			valueField = sc.getDeclaredField( "value" ); // 获取 value 字段
			valueField.setAccessible( true );
			coderField = sc.getDeclaredField( "coder" ); // 获取 coder 字段
			coderField.setAccessible( true );
			hashField = sc.getDeclaredField( "hash" ); // 获取 hash 字段
			hashField.setAccessible( true );
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 透视一个字符串实例，将其中的 value 、coder 、hash 输出到控制台中
	 * @param s 被透视的字符串实例
	 */
	public static void perspective( final String s ) {
		try {
			System.out.println( "字符串实例内容: " + s );
			System.out.println( "字符串实例中字符个数: " + s.length() );
			final Object value = valueField.get( s );
			int length = Array.getLength( value );
			System.out.println( "字符串实例内部字节数组长度: " + length );
			System.out.println( "字符串实例内部字节数组\"地址\": " + System.identityHashCode( value )  );
			System.out.print( "字符串实例内部字节数组: " );
			for ( int i = 0 ; i < length ; i++ ) {
				System.out.print( Array.get( value , i ) );
				System.out.print( i < length - 1 ? " , " : "\n" );
			}
			System.out.println( "字符串实例的 coder 变量: " + coderField.getByte( s ) );
			System.out.println( "字符串实例的 hash 变量: " + hashField.getInt( s ) );
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
