package cn.edu.ecut;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 1、java.time.LocalDateTime ===> java.util.Date
 * 			java.time.LocalDateTime ---> java.time.ZonedDateTime ---> java.time.Instant ---> java.util.Date
 * 2、java.time.LocalDateTime ===> java.time.ZonedDateTime
 * 3、java.time.ZonedDateTime ===> java.time.Instant
 * 4、java.time.Instant ===> java.util.Date
 */
public class TransformTest5 {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of( 1949 , 10 , 1 );
		LocalTime time = LocalTime.of( 10 , 0 );
		LocalDateTime datetime = LocalDateTime.of( date , time );
		System.out.println( datetime );
		
		ZoneId zone = ZoneId.systemDefault() ;
		
		// ZonedDateTime zonedDateTime = ZonedDateTime.of( date , time , zone );
		ZonedDateTime zonedDateTime = ZonedDateTime.of( datetime , zone );
		
		// ZonedDateTime 类 实现了 TemporalAccessor 接口
		Instant instant = Instant.from( zonedDateTime ) ;
		
		// 将一个 java.time.Instant 实例 转换为 java.util.Date 实例
		Date utilDate = Date.from( instant ) ;
		System.out.println( utilDate );
		
	}

}
