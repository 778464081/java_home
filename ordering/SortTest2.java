package cn.edu.ecut;

import java.util.Arrays;

/**
 * 使用 Arrays.sort( Object[] ) 排序的数组对应的类实现了 java.lang.Comparable 接口
 */
public class SortTest2 {

	public static void main(String[] args) {
		
		Monkey[] monkeies = {
											new Monkey( "美猴王" , 5 , 30 ) ,
											new Monkey( "孙悟空" , 6 , 32 ) ,
											new Monkey( "弼马温" , 4 , 25 ) ,
											new Monkey( "齐天大圣" , 3 , 20 ) , 
											new Monkey( "孙行者" , 7 , 31 )
										};
		
		System.out.println( Arrays.toString( monkeies ) );
		// public static void sort( Object[] array )
		Arrays.sort( monkeies ); 
		System.out.println( Arrays.toString( monkeies ) );

	}

}
