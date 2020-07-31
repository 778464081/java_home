package cn.edu.ecut.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 通过反射调用类方法
 */
public class InvokeMethodTest1 {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Class.forName( "cn.edu.ecut.reflect.Sheep" );
		
		Field f = c.getDeclaredField( "school" );
		f.setAccessible( true );
		f.set( c ,  "小肥羊火锅" ); // Sheep.school = "小肥羊火锅"
		
		// public Method getDeclaredMethod( String methodName , Class<?>... parameterTypes)
		Method m = c.getDeclaredMethod( "showSchool" );
		
		int mod = m.getModifiers();
		System.out.println( mod );
		System.out.println( Modifier.toString( mod ) );
		
		if( Modifier.isStatic( mod ) ) {
			// 调用 c 类的 m 方法并获得其返回值
			Object v = m.invoke( c ); // Sheep.showSchool()
			System.out.println( v );
		}
		
		System.out.println( "- - - - - - - - - - - -" );
		
		c = Class.forName( "java.lang.Math" ) ;
		m = c.getDeclaredMethod( "pow" , double.class , double.class );
		Object v = m.invoke( c , 5 , 2 );
		System.out.println( v );

	}

}
