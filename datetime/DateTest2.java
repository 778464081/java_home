package cn.edu.ecut;

import java.util.Date;

/**
 * 1、1h = 60m ; 1m = 60s ; 1s = 1000 ms ;
 * 2、比较两个 Date 实例是否相等: public boolean equals( Object o )
 * 3、判断 当前Date实例 所表示瞬间 是否 早于 另一个Date实例所表示的瞬间: boolean before( Date when )
 * 4、判断 当前Date实例 所表示瞬间 是否 晚于 另一个Date实例所表示的瞬间: boolean after( Date when )
 * 5、了解一下 "闰秒" : 对于 UTC，大约每一两年出现一次额外的一秒，称为 "闰秒"
 */
public class DateTest2 {

	public static void main(String[] args) {
		
		long millis = System.currentTimeMillis(); // 该行代码执行时对应的毫秒值
		Date now = new Date( millis );
		System.out.println( now );
		
		long day = 1000L * 60 * 60 *24 ; // 统计 24 小时对应的毫秒值
		
		Date first = new Date(  millis - day );
		System.out.println( first );
		
		Date second = new Date(  millis  );
		System.out.println( second );
		
		Date third = new Date(  millis + day  );
		System.out.println( third );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		System.out.println( first.equals( now ) ); // false
		System.out.println( second.equals( now ) ); // true
		System.out.println( third.equals( now ) ); // false
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		System.out.println( first.before( now ) ); // true
		System.out.println( second.before( now ) ); // false
		System.out.println( third.before( now ) ); // false
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		System.out.println( first.after( now ) ); // false
		System.out.println( second.after( now ) ); // false
		System.out.println( third.after( now ) ); // true	
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 以下比较方法就不赞成使用了
		System.out.println( first.getTime() <  now.getTime() ); 
		System.out.println( second.getTime() <  now.getTime() ); 
		System.out.println( third.getTime() < now.getTime() ); 
		
	}

}
