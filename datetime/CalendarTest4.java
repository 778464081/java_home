package cn.edu.ecut;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 1、时区: TimeZone 、地区: Locale
 * 2、获得 Calendar 实例时需要综合考虑 地区 和 时区 的影响
 */
public class CalendarTest4 {
	
	public static void main(String[] args) {
		
		// 获得 默认的地区 ( 用一个 Locale 对象表示 )
		Locale defaultLocale = Locale.getDefault(); // 类方法
		System.out.println( defaultLocale );
		
		Locale first = new Locale( "zh" , "CN" );
		System.out.println( first );
		
		Locale second = new Locale( "zh" , "TW" );
		System.out.println( second );
		
		Locale third = new Locale( "en" , "US" );
		System.out.println( third );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 获得 默认的时区 ( 用一个 TimeZone 对象表示 )
		TimeZone defaultTimeZone = TimeZone.getDefault() ; // 类方法
		System.out.println( defaultTimeZone );
		
		String id = "Asia/Chongqing" ;
		TimeZone tz = TimeZone.getTimeZone( id );
		System.out.println( tz );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		/*
		String[] ids = TimeZone.getAvailableIDs();
		for( int i = 0 ; i < ids.length ; i++ ) {
			System.out.println( ids[ i ] );
		}
		*/
		
		Calendar calendar = Calendar.getInstance( tz , first );
		System.out.println( calendar );
		
		System.out.println( calendar.getTime() );
		
	}
	
}

