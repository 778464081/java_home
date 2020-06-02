package cn.edu.ecut;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *  LocalDate ===>  LocalDateTime
 */
public class TransformTest2 {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.ofYearDay( 1999 ,  200 );
		System.out.println( date );
		
		// 获得 date 所表示日期的 00:00:00.000000000 对应的 LocalDateTime实例
		LocalDateTime first = date.atStartOfDay(); 
		System.out.println( first );
		
		LocalDateTime second = date.atTime( 5 , 30 );
		System.out.println( second );
		
		LocalDateTime thrid = date.atTime( 5 , 30 , 40 );
		System.out.println( thrid );
		
		LocalDateTime fourth = date.atTime( 5 , 30 , 40 , 100200300 );
		System.out.println( fourth );
		
		LocalTime time = LocalTime.of( 17 ,  20 , 30, 400500600 );
		LocalDateTime fifth = date.atTime( time );
		System.out.println( fifth );

	}

}
