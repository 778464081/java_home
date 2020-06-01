package cn.edu.ecut;

import java.util.Calendar;
import java.util.Date;

/**
 * 1、如果不是使用 JDK 1.8 提供的 日期/时间 支持 ( 不是使用 java.time 包 提供的支持 )，
 *      但需要获得 指定 年、月、日、时、分、秒 、毫秒 对应的 java.util.Date 实例 ，
 *      则可以借助于 Calendar 实例来实现
 * 2、通过 clear 方法可以 清空 Calendar 实例的所有 日历字段值 和 时间值
 */
public class CalendarTest3 {
	
	public static void main(String[] args) {
		
		// 1、获得一个 Calendar 实例
		final Calendar calendar = Calendar.getInstance(); // 默认地区、默认时区
		System.out.println( calendar );

		// 2、清空 Calendar 实例的所有 日历字段值 和 时间值
		calendar.clear(); // 将 当前Calendar实例 的所日历字段值和时间值（从历元至现在的毫秒偏移量）设置成未定义
		
		System.out.println( calendar );
		
		// 3、根据实际需要设置 年、月、日、时、分、秒 、毫秒
		calendar.set( 1999 , 9 , 10 , 16, 30, 40 ); // 注意月份从零开始计数
		calendar.set( Calendar.MILLISECOND , 123 );// 如有必要可以单独设置毫秒
		
		System.out.println( calendar );
		
		// 4、通过 Calendar 实例来获得 Date 对象
		Date date = calendar.getTime(); // 通过 Calendar实例 获得该实例所表示瞬间对应的 Date 对象
		System.out.println( date );
		
		long millis = calendar.getTimeInMillis(); // 通过 Calendar实例 获得该实例所表示瞬间 对应的毫秒值
		System.out.println( millis );
		
	}
	
}

