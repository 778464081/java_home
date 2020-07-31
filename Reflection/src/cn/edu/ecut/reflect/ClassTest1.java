package cn.edu.ecut.reflect;

import java.util.List;

public class ClassTest1 {

	public static void main(String[] args) {
		
		Class<?> clazz = null ;
		
		// 所有的类型都可以通过 .class 来获取该类型对应的 Class类型的实例
		clazz = int.class ; // 基本类型
		System.out.println( clazz );
		
		clazz = char.class ; // 基本类型
		System.out.println( clazz );
		
		clazz = byte[][].class ; // 引用类型 ( 数组类型 )
		System.out.println( clazz );
		
		clazz = boolean[][].class ; // 引用类型 ( 数组类型 )
		System.out.println( clazz );
		
		clazz = Object.class ; // 引用类型 ( 类类型 )
		System.out.println( clazz );
		
		// State 是 Thread 类中声明的 内部枚举
		clazz = Thread.State.class ; // 引用类型( 枚举是一种特殊的类 )
		System.out.println( clazz );
		
		clazz = List.class; // 引用类型 ( 接口类型 )
		System.out.println( clazz );
		
		clazz = Override.class; // 引用类型 ( 注解(annotation)是一种特殊的接口 )
		System.out.println( clazz );
		
		clazz = Integer.class ;
		System.out.println( clazz );
		
		
	}

}
