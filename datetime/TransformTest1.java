package cn.edu.ecut;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 1、LocalDateTime ===>  LocalDate
 * 2、LocalDateTime ===>  LocalTime
 */
public class TransformTest1 {

	public static void main(String[] args) {
		
		LocalDateTime now = LocalDateTime.now(); // 默认时区
		System.out.println( now );
		
		// LocalDateTime ===>  LocalDate
		LocalDate date = now.toLocalDate();
		System.out.println( date );
		
		// LocalDateTime ===>  LocalTime
		LocalTime time = now.toLocalTime();
		System.out.println( time );

	}

}
