package cn.edu.ecut;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * 1、了解 java.time.LocalDateTime 表示 日期时间，其中既有日期又有时间 
 * 2、LocalDateTime类中的类方法: now() / now(ZoneId) / of( ... )
 *
 */
public class LocalDateTimeTest {

	public static void main(String[] args) {

		System.out.println(LocalDateTime.MIN);
		System.out.println(LocalDateTime.MAX);

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

		LocalDateTime now = null;

		// 使用操作系统使用默认时区获得 LocalDateTime 实例
		now = LocalDateTime.now();
		System.out.println(now); // now.toString()

		// 根据 指定时区 获取该时区对应的 日期时间
		now = LocalDateTime.now(ZoneId.of("US/Alaska"));
		System.out.println(now);

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

		LocalDate date = LocalDate.of(1998, 6, 10);
		LocalTime time = LocalTime.of(14, 20, 30, 111222333);

		LocalDateTime first = LocalDateTime.of(date, time);
		System.out.println(first);

		LocalDateTime second = LocalDateTime.of(1999, 7, 8, 5, 30);
		System.out.println(second);

		LocalDateTime third = LocalDateTime.of(1999, 7, 8, 5, 30, 40);
		System.out.println(third);

	}

}
