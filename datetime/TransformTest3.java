package cn.edu.ecut;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * LocalTime ===>  LocalDateTime
 */
public class TransformTest3 {

	public static void main(String[] args) {
		
		LocalTime time = LocalTime.of( 16 ,  50 , 30, 400500600 );
		System.out.println( time );
		
		LocalDate date = LocalDate.now(); // 默认时区
		
		LocalDateTime first = time.atDate( date );
		System.out.println( first );
		
		

	}

}
