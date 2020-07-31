package cn.edu.ecut.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 1、获取实例字段的值
 * 2、为实例字段赋值
 */
public class AccessFieldTest1 {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Class.forName( "cn.edu.ecut.reflect.Sheep" );
		
		Constructor<?> con = c.getDeclaredConstructor( String.class );
		
		con.setAccessible( true );
		
		Object o = con.newInstance( "宋青书" ); // new Sheep( "宋青书" )
		
		System.out.println( o ); // o.toString()
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ " );
		
		// 从c类中获得名称是 name 的字段
		Field f = c.getDeclaredField( "name" );
		int mod = f.getModifiers(); // 获得字段的修饰符
		String modifiers = Modifier.toString( mod );
		System.out.println( "修饰符: " + modifiers );
		
		Class<?> t = f.getType(); // 获得字段的类型
		System.out.println( t.getName() );
		
		f.setAccessible( true );
		
		// 获得 o 实例 中 f 字段的值
		Object value = f.get( o ) ; // value = o.name 
		System.out.println( value );
		
		// 为 o 实例 的 f 字段赋值，赋值为 "懒羊羊"
		f.set( o ,  "懒羊羊" ); // o.name = "懒羊羊" ;
		
		value = f.get( o ) ; // value = o.name 
		System.out.println( value );
		

	}

}
