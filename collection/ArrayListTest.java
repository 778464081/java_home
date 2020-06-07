package cn.oracle;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>(5);
		ArrayListHelper.perspective( list );
		
		list.add( "华安" );
		list.add( "秋香" );
		list.add( "华文" );
		
		System.out.println( list );
		
		list.ensureCapacity( 10 ); // ArrayList 类中重新声明的方法
		ArrayListHelper.perspective( list );
		
		System.out.println( list );
		
		list.trimToSize(); // ArrayList 类中重新声明的方法
		ArrayListHelper.perspective( list );
		
		System.out.println( list );

	}

}
