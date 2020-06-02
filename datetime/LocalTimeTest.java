package cn.edu.ecut;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * 1、理解 java.time.LocalTime 表示某一天当中的时间
 * 2、通过 LocalTime 类的 类方法 来获取 LocalTime 实例: now() / now(ZoneId) / of( int , int ) / of( int , int , int ) / of ( int , int , int , int)
 * 3、秒( s ) 、毫秒 ( ms )、微秒(μs)、纳秒(ns) 、皮秒(ps)之间的换算
 *      1s = 1000ms 。[ 毫秒 ( millisecond ) ]
 *      1ms = 1000μs 。[ 微秒 ( microsecond ) ]
 *      1μs = 1000ns 。[ 纳秒 也叫 毫微秒 ( nanosecond ) ]
 *      1ns = 1000ps 。[ 皮秒 ( picosecond ) ]
 */
public class LocalTimeTest {

	public static void main(String[] args) {
		
		System.out.println( ZoneId.systemDefault() ); // 输出操作系统使用的默认时区
		
		 LocalTime now = LocalTime.now(); // 根据默认时区获取当地的当前时间
		 System.out.println( now );
		 
		 ZoneId zone = ZoneId.of( "US/Alaska" );
		 now = LocalTime.now( zone ); // 根据 指定时区 获取该地当前时间
		 System.out.println( now );
		 
		 System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		 
		 LocalTime first = LocalTime.of( 15 ,  35 );
		 System.out.println( first );
		 
		 LocalTime second = LocalTime.of( 15 ,  35 , 40 );
		 System.out.println( second );
		 
		 LocalTime third = LocalTime.of( 22 , 44 ,  55 , 100200300 ); // 时、分、秒、纳秒
		 System.out.println( third );
		 
		 System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		 
		 System.out.println( LocalTime.MIN );
		 System.out.println( LocalTime.MAX );
		 System.out.println( LocalTime.MIDNIGHT );
		 System.out.println( LocalTime.NOON );
		 
	}

}
