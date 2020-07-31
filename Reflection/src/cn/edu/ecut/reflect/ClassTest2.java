package cn.edu.ecut.reflect;

import java.util.ArrayList;

public class ClassTest2 {

	public static void main(String[] args) {
		
		// 变量 o 的编译时类型是 java.lang.Object
		Object o = null ;
		Class<?> c = null ;
		
		o = new ArrayList<String>();
		// 对于引用类型的实例来说，还可以通过 getClass 方法来获取其运行时类型
		c = o.getClass();
		System.out.println( c );
		
		System.out.println( "- - - - - - - - - - - -" );
		
		o = "" ; // o = new String();
		c = o.getClass();
		System.out.println( c );
		
		o = 250 ; // auto-boxing ( 自动装箱 )
		c = o.getClass();
		System.out.println( c );
	}

}
