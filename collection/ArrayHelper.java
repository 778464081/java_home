package org.malajava;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayHelper {
	
	/*
	 * 泛型方法
	 * 
	 * [修饰符]  <类型参数>  返回类型  方法名称( 形参列表 )  [ throws 异常类型列表 ] {
	 * }
	 * 
	 * 泛型方法仅适用于 引用类型，不适用于 基本数据类型 
	 * (所有的类型参数都仅适用于 引用类型 ，不适用于 基本类型 )
	 */
	
	public static <T> T[] build( Class<T>  clazz , int length ) {
		// 以 clazz 对应的类 为 组件类型 创建一个长度 为 length 的新数组
		@SuppressWarnings("unchecked")
		T[] newArray = (T[])Array.newInstance( clazz , length );
		return newArray;
	}

	public static void main(String[] args) {
		
		Integer[] array = ArrayHelper.build( Integer.class , 5 );
		System.out.println( array );
		System.out.println( Arrays.toString( array ) );

	}

}
