package cn.edu.ecut.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 1、获得类中声明的字段
 * 2、获得类中声明的方法
 * 3、获得类中声明的构造方法
 */
public class ClassInfoTest2 {

	public static void main(String[] args) {
		
		Class<?> c = HashMap.class ;
		
		Field[] fields = c.getDeclaredFields(); // 仅获取c所表示的类中直接声明的字段(不考虑修饰符)
		for( int i = 0 , n = fields.length ; i < n ; i++ ) {
			System.out.println( fields[ i ] );
		}
		
		System.out.println( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		
		Method[] methods = c.getDeclaredMethods(); // 仅获取c所表示的类中直接声明的方法(不考虑修饰符)
		for( int i = 0 , n = methods.length ; i < n ; i++ ) {
			System.out.println( methods[ i ] );
		}
		
		System.out.println( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		
		Constructor<?>[] constructors = c.getDeclaredConstructors(); // 仅获取c所表示的类中的所有构造方法(不考虑修饰符)
		for( int i = 0 , n = constructors.length ; i < n ; i++ ) {
			System.out.println( constructors[ i ] );
		}

		
	}

}
