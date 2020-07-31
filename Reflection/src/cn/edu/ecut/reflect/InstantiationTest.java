package cn.edu.ecut.reflect;

import java.lang.reflect.Constructor;

public class InstantiationTest {

	public static void main(String[] args) throws Exception {
		
		// 加载类并返回该类对应的Class实例
		Class<?> c = Class.forName( "cn.edu.ecut.reflect.Sheep" );
		
		ClassLoader loader = c.getClassLoader(); // 谁加载了 c 对应的类
		System.out.println( loader );
		
		// Java 9 开始废弃了 newInstance 方法
		// Object o = c.newInstance(); // 本来是通过c类的无参构造来创建c类的实例
		
		// 根据参数类型来获取c类中的指定构造方法
		// getDeclaredConstructor( Class<?>... paramTypes )
		Constructor<?> con = c.getDeclaredConstructor( String.class );
		// 让不能被访问的资源可以被访问
		con.setAccessible( true );
		
		// 使用构造方法提供的 newInstance 方法来创建 c类的实例
		Object o = con.newInstance( "懒羊羊" );
		System.out.println( o );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ " );
		
		con = c.getDeclaredConstructor();
		con.setAccessible( true );
		o = con.newInstance();
		System.out.println( o );
		
	}

}
