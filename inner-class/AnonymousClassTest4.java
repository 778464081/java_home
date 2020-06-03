package cn.edu.ecut;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * 尝试获取匿名类的构造方法
 */
public class AnonymousClassTest4 {

	public static void main(String[] args) {
		
		// 在 java.lang.Cloneable 接口中没有声明任何方法
		Cloneable c = new Cloneable() {
			// 这里什么都不用写
		};
		
		/*
		Human c = new Human( "张翠山" ) {
			@Override
			public void eat(String food) {
			}
		};
		*/
		
		System.out.println( c );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Class<?> clazz = c.getClass();
		
		// 通过 反射 来获取 匿名类 中所有的构造方法组成的数组
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		
		System.out.println( Arrays.toString( constructors ) ); 

	}

}
