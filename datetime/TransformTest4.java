package cn.edu.ecut;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 1、java.util.Date ===>  java.time.LocalDateTime
 * 			java.util.Date ---> java.time.Instant ---> java.time.ZonedDateTime ---> java.time.LocalDateTime
 * 2、java.util.Date ===>  java.time.LocalDate
 * 			java.util.Date ---> java.time.Instant ---> java.time.ZonedDateTime ---> java.time.LocalDate
 * 3、java.util.Date ===>  java.time.LocalTime
 * 			java.util.Date ---> java.time.Instant ---> java.time.ZonedDateTime ---> java.time.LocalTime
 */
public class TransformTest4 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set( 1999 ,  9 ,  10 ,  20 ,  30 ,  40 );
		final Date utilDate = c.getTime();
		System.out.println( utilDate );
		
		// 根据 java.util.Date 实例 获得 与之对应的 java.time.Instant 实例
		Instant instant = utilDate.toInstant(); 
		System.out.println( instant );
		
		ZoneId zone = ZoneId.systemDefault();
		// 根据 Instant 实例获得 带有时区的 日期时间对象 ( ZonedDateTime实例 )
		ZonedDateTime zdt = instant.atZone( zone );
		System.out.println( zdt );
		
		// ZonedDateTime ===> LocalDateTime
		LocalDateTime datetime = zdt.toLocalDateTime() ;
		System.out.println( datetime );
		
		// ZonedDateTime ===> LocalDate
		LocalDate date = zdt.toLocalDate() ;
		System.out.println( date );
		
		// ZonedDateTime ===> LocalTime
		LocalTime time = zdt.toLocalTime() ;
		System.out.println( time );

	}

}
