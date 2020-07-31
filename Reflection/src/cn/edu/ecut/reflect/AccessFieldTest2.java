package cn.edu.ecut.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 */
public class AccessFieldTest2 {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Class.forName( "cn.edu.ecut.reflect.Sheep" );
		
		Field f = c.getDeclaredField( "school" );
		System.out.println( Modifier.toString( f.getModifiers() ) );
		System.out.println( f.getType().getName() ); // 字段的类型名称
		System.out.println( f.getName() ); // 字段的名称
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ " );
		
		System.out.println( Modifier.isPrivate( f.getModifiers() ) );
		System.out.println( Modifier.isStatic( f.getModifiers() ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ " );
		
		f.setAccessible( true );
		
		System.out.println( f.get( c ) ); // Sheep.school
		
		// 为 c 类的 f 字段赋值 ( 前提是 f 是个类变量 )
		f.set( c ,  "大肥羊学校" ); // Sheep.school = "大肥羊学校" ; 
		
		System.out.println( f.get( c ) ); // Sheep.school

	}

}
