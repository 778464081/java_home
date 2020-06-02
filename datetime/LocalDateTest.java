package cn.edu.ecut;

import java.time.LocalDate;

/**
 * 1、了解 LocalDate 中的常量:  MIN / MAX / EPOCH
 * 2、熟练使用 LocalDate 类中的 静态工厂方法 :  now() / of( int , int , int ) / ofYearDay( int , int )
 * 3、理解 LocalDate 内部设计: 
 *          LocalDate 类是 final 修饰的 、
 *          LocalDate 类的构造方法都是私有的、
 *          LocalDate 类中表示 年、月、日的 实例变量全部都是 私有 且 不可更改的:
 *           private final int year ;
 *           private final short month ;
 *           private final short date ;
 *  4、LocalDate 类是一个最终类，同时 LocalDate 类的实例 也是不可变的
 */
public class LocalDateTest {

	public static void main(String[] args) {
		
		System.out.println( LocalDate.MIN ); 
		System.out.println( LocalDate.EPOCH ); // 历元
		System.out.println( LocalDate.MAX ); 
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		LocalDate today = LocalDate.now(); // 获得当前日期
		System.out.println( today );
		
		LocalDate birthdate1 = LocalDate.of( 1999 ,  5 , 10 ); // 注意这里的月份从一开始
		System.out.println( birthdate1 );
		
		LocalDate birthdate2 = LocalDate.of( 1999 ,  5 , 10 ); 
		System.out.println( birthdate2 );
		
		System.out.println( birthdate1 == birthdate2 ); // false
		System.out.println( birthdate1.equals( birthdate2 ) ); // true
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		System.out.println( today.plusDays( 15 ) ); // 增加 N 天
		System.out.println( today.plusWeeks( 3 ) ); // 增加 N 周
		System.out.println( today.plusMonths( -5 ) );
		System.out.println( today.plusYears( -10 ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		LocalDate date = LocalDate.ofYearDay( 2020 , 200 ); // 获取 指定年份 的 第 N 天对应的 日期
		System.out.println( date );
		System.out.println( date.isLeapYear() ); // 判断 指定日期 所在年份是否是闰年
		System.out.println( date.lengthOfMonth() ); // 获取 当前日期 所在月份的总天数
		System.out.println( date.lengthOfYear() ); // 获取 当前日期 所在年份的总天数

	}

}
