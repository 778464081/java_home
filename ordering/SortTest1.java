package cn.edu.ecut;

import java.util.Arrays;

/**
 * 这个类运行后会抛出 ClassCastException
 */
public class SortTest1 {

	public static void main(String[] args) {
		
		int[] array = { 3 , 9 ,  5 , 1 , 7 };
		System.out.println( Arrays.toString( array ) );
		Arrays.sort( array ); // 对参数所传入的数组进行排序
		System.out.println( Arrays.toString( array ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		char[] chars = { 'Z' , 'P' , 'O' , 'W' , 'B' , 'C' , 'N' , 'A' };
		System.out.println( Arrays.toString( chars ) );
		Arrays.sort( chars );
		System.out.println( Arrays.toString( chars ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String[] numbers = { "九" , "一" , "八" , "四" , "七" , "三" , "六" , "二" , "五" };
		System.out.println( Arrays.toString( numbers ) );
		Arrays.sort( numbers ); // String 类 实现了 Comparable 接口，支持自然排序
		System.out.println( Arrays.toString( numbers ) ); // 最终的顺序由 String 类所实现的 compareTo 方法来确定
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Panda[] pandas = new Panda[ 5 ];
		System.out.println( Arrays.toString( pandas ) );
		pandas[ 0 ] = new Panda( "团团" , 5 , 30 );
		pandas[ 1 ] = new Panda( "圆圆" , 6 , 32 );
		pandas[ 2 ] = new Panda( "和和" , 4 , 25 );
		pandas[ 3 ] = new Panda( "美美" , 3 , 20 );
		pandas[ 4 ] = new Panda( "媛媛" , 7 , 31 );
		System.out.println( Arrays.toString( pandas ) );
		// public static void sort( Object[] array )
		Arrays.sort( pandas ); // 运行时抛出异常: ClassCastException: class cn.edu.ecut.Panda cannot be cast to class java.lang.Comparable 
		System.out.println( Arrays.toString( pandas ) );

	}

}
