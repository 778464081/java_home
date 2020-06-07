package org.malajava;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * 测试采用 java.lang.reflect.Array 类提供的支持来创建、访问数组
 */
public class ReflectionTest {

	public static void main(String[] args) {
		
		Class<?> componentType = Integer.class ; // 组件类型 就是数组中存放的元素的类型 
		int length = 5 ; // 数组长度
		// 通过 反射方式创建 数组对象 ( 返回类型是 Object )
		Object o = Array.newInstance( componentType , length );
		
		// 获取指定的数组的长度，使用 getLength 方法
		int len =Array.getLength( o );
		System.out.println( "length : " +  len );
		
		for( int i = 0 ; i < len ; i++ ) {
			Object e = Array.get( o ,  i ) ; // 获取 指定数组 ( o )  指定位置 ( i ) 的元素
			System.out.println( e );
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Random rand = new Random();
		
		for( int i = 0 ; i < len ; i++ ) {
			Object v = rand.nextInt( 100 ) ; 
			Array.set( o ,  i , v ); // 为 指定数组 o 的 指定位置 i 赋予 指定的值 v 
		}
		
		for( int i = 0 ; i < len ; i++ ) {
			Object e = Array.get( o ,  i ) ; // 获取 指定数组 ( o )  指定位置 ( i ) 的元素
			System.out.println( e );
		}
		
	}

}
