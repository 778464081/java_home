package cn.edu.ecut.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 1、对比 getDeclaredMethods 和 getMethods 所返回的方法的区别
 * 2、通过 本类中的对比，理解 getDeclaredFields 和 getFields 的区别
 */
public class ClassInfoTest3 {

	public static void main(String[] args) {
		
		Class<?> c = HashMap.class ;
		
		// 仅获取c所表示的类中直接声明的方法(不考虑访问修饰符的影响)
		Method[] methods = c.getDeclaredMethods(); 
		for( int i = 0 , n = methods.length ; i < n ; i++ ) {
			System.out.println( methods[ i ] );
		}
		
		System.out.println( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		
		// 仅获取c所表示的类中 public所修饰的方法以及从父类中继承的public方法
		methods = c.getMethods();
		for( int i = 0 , n = methods.length ; i < n ; i++ ) {
			System.out.println( methods[ i ] );
		}
		
	}

}
