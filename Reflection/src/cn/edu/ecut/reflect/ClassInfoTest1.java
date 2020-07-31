package cn.edu.ecut.reflect;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Map;

/**
 * 1、获得类的修饰符
 * 2、获得类的直接父类
 * 3、获得类直接实现的接口
 * 4、获得类的名称
 */
public class ClassInfoTest1 {

	public static void main(String[] args) {
		
		Class<?> c = ArrayList.class ;
		
		// 获得 c 指向的Class实例所表示的类的修饰符
		int mod = c.getModifiers(); // 返回以数字形式表示的修饰符
		System.out.println( mod );
		
		// 通过 java.lang.reflect.Modifier 类的 toString 方法可以将数字形式的修饰符解析为字符串形式
		String modifier = Modifier.toString( mod ); 
		System.out.println( modifier );
		
		// 获得 c 所表示的类的父类
		Class<?> p = c.getSuperclass();
		System.out.println( p );
		
		// 获得 c 所表示的类 直接实现的接口
		Class<?>[] interfaces = c.getInterfaces();
		for( int i = 0 ; i < interfaces.length ; i++ ) {
			System.out.println( interfaces[ i ] );
		}
		
		System.out.println( "- - - - - - - - - - - - - - -" );
		
		c = Map.Entry.class ;
		
		System.out.println( c.getName() ); // 获得类的权限定名称
		System.out.println( c.getSimpleName() ); // 获得简单类名(就是class或interface关键字之后的名字)
		System.out.println( c.getCanonicalName() ); // 获得规范化类名
		
	}

}
