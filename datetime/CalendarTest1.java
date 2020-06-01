package cn.edu.ecut;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 1、java.util.Calendar 类是个抽象类
 * 2、java.util.GregorianCalendar 类是 Calendar 的子类
 * 3、Calendar 为特定瞬间与一组日历字段之间的转换提供了一些方法，并为操作日历字段提供了一些方法
 *       日历字段 ( calendar field ) 就是表示 特定瞬间 中某个部分的 字段 ，比如:
 *       Calendar.YEAR 表示年 、
 *       Calendar.MONTH 表示月、
 *       Calendar.DATE 表示天 、
 *       Calendar.HOUR 表示小时 ( 12 小时进制 ，分上午和下午 ) 、
 *       Calendar.HOUR_OF_DAY 表示小时 ( 24 小时进制 ) 、
 *       Calendar.MINUTE 表示分钟 、
 *       Calendar.SECOND 表示秒 、
 *       Calendar.MILLISECOND 表示毫秒
 * 4、瞬间 可用毫秒值来表示，它是距历元的偏移量
 * 		 历元:  即格林威治标准时间 1970 年 1 月 1 日的 00:00:00.000，格里高利历
 * 5、通过 Calendar 实例 调用 get( int) 方法可以获得指定 日历字段 的值
 */
public class CalendarTest1 {
	
	public static void main(String[] args) {
		
		// 父类类型的 引用变量 指向了 子类类型的对象
		Calendar calendar = new GregorianCalendar(); // 默认地区 、默认时区
		System.out.println( calendar );
		
		StringBuilder builder = new StringBuilder();
		
		int year = calendar.get( Calendar.YEAR );
		builder.append( year + "年" );
		
		// 鬼子那边的月份是从 零 开始计数的
		int month = calendar.get( Calendar.MONTH ) + 1 ;
		builder.append( month + "月" );
		
		int date = calendar.get( Calendar.DATE );
		builder.append( date + "日" );
		
		int hours = calendar.get( Calendar.HOUR_OF_DAY );
		builder.append( hours + ":" );
		
		int minutes = calendar.get( Calendar.MINUTE );
		builder.append( minutes + ":" );
		
		int seconds = calendar.get( Calendar.SECOND );
		builder.append( seconds + "." );
		
		int millis = calendar.get( Calendar.MILLISECOND );
		builder.append( millis );
		
		String s = builder.toString();
		System.out.println( s );
	}
	
}

