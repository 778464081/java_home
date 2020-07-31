package cn.edu.ecut.loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EcutClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		final String path = "D:/test" ;
		
		EcutClassLoader loader = new EcutClassLoader( path );
		
		final String name = "cn.edu.ecut.loader.Panda" ;
		
		// 通过自定义的类加载器来加载指定的类
		Class<?> c = loader.loadClass( name );
		System.out.println( c );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 获得c所表示的类中直接声明的字段 (不考虑访问修饰符的影响)
		Field[] fields = c.getDeclaredFields();
		for( int i = 0 ; i < fields.length ; i++ ) {
			System.out.println( fields[ i ]);
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 获得c所表示的类中直接声明的方法 (不考虑访问修饰符的影响)
		Method[] methods = c.getDeclaredMethods();
		for( int i = 0 ; i < methods.length ; i++ ) {
			System.out.println( methods[ i ]);
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 获得c所表示的类中的所有构造方法 (不考虑访问修饰符的影响)
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for( int i = 0 ; i < constructors.length ; i++ ) {
			System.out.println( constructors[ i ]);
		}
		
		
	}

}
