package cn.edu.ecut;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 1、通过创建 SimpleDateFormat 类的实例来完成 日期格式化操作
 * 2、在创建 SimpleDateFormat 对象时，一定要注意 日期模式
 */
public class DateFormatTest2 {

	public static void main(String[] args) {
		
		final Calendar c = Calendar.getInstance();
		c.clear();
		c.set( 1999 , 9, 30, 19, 30 , 50 );
		
		final Date d = c.getTime();
		System.out.println( d );
		
		// Locale.setDefault( new Locale( "en" , "US") ); // 设置默认的国家/地区
		
		// final String pattern = "Gyyyy年MM月dd日 E HH:mm:ss.SSS" ;
		final String pattern = "Gyyyy年MM月dd日 EEEE HH:mm:ss.SSS" ;
		// 父类类型的引用 变量 指向了 子类类型的对象
		DateFormat df = new SimpleDateFormat( pattern );
		
		String s = df.format( d ); // 将 Date实例 格式化为 特定模式 的 字符串
		System.out.println( s );

	}

}
