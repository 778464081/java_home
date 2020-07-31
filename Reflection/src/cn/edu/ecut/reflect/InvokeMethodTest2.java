package cn.edu.ecut.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 通过反射调用实例方法
 */
public class InvokeMethodTest2 {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Class.forName( "cn.edu.ecut.reflect.Sheep" );
		
		Constructor<?> con = c.getDeclaredConstructor( String.class );
		con.setAccessible( true );
		
		Object o = con.newInstance( "喜羊羊" );
		
		Method m = c.getDeclaredMethod( "showName" );
		if( Modifier.isPublic( m.getModifiers() ) ) {
			Object v = m.invoke( o );
			System.out.println( v ); // null
		}
		
		System.out.println( "- - - - - - - - - - - -" );
		
		c = Class.forName( "java.util.ArrayList" ); // 加载指定的类
		con = c.getDeclaredConstructor(); // 获得 c类的public修饰的无参构造
		o = con.newInstance(); // new ArrayList()
		m = c.getMethod( "add" , Object.class );
		Object v = m.invoke( o ,  "慢羊羊" ); // v = o.add( "慢羊羊" )
		System.out.println( v );

	}

}
