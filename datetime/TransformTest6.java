package cn.edu.ecut;

import java.time.LocalTime;

/**
 * 1、java.sql.Date 类 和 java.sql.Time 类 都是 java.util.Date 类的子类
 * 2、使用 java.util.Date 类型的引用变量 可以 指向 java.sql.Date 类型的实例 或  指向java.sql.Time 类型的实例
 * 3、因此:
 *      将 java.time.LocalDate 快速转换为 java.util.Date 的方法就是 java.sql.Date.valueOf( java.time.LocalDate ) ，
 *      将 java.time.LocalTime 快速转换为 java.util.Time 的方法就是 java.sql.Time.valueOf( java.time.LocalTime ) ，
 * 		 但是他们的确是不完美的。
 */
public class TransformTest6 {

	public static void main(String[] args) {
		
		long millis = 1000L * 60 * 60 * 24 * 365 * 50 ;
		// java.sql.Date 类 是 java.util.Date 类的子类，用来表示日期
		java.sql.Date date = new java.sql.Date( millis );
		System.out.println( date ); 
		
		// 直接将 java.sql.Date 实例转换为 java.time.LocalDate 实例
		java.time.LocalDate localDate = date.toLocalDate(); 
		System.out.println( localDate );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		long ms = 1000L * 60 * 60 * 15 ;
		// java.sql.Time 类 是 java.util.Date 类的子类，用来表示日期
		java.sql.Time time = new java.sql.Time( ms );
		System.out.println( time );
		
		LocalTime localTime = time.toLocalTime();
		System.out.println( localTime );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		java.time.LocalDate birthdate = java.time.LocalDate.of( 1998 , 10 , 20 );
		System.out.println( birthdate );
		// 使用 java.sql.Date 类中的 valueOf 方法将 LocalDate 转换为 java.sql.Date 实例
		java.sql.Date sqlDate = java.sql.Date.valueOf( birthdate );
		System.out.println( sqlDate );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		java.time.LocalTime now = java.time.LocalTime.now();
		java.sql.Time sqlTime = java.sql.Time.valueOf( now );
		System.out.println( sqlTime );
		
	}

}
