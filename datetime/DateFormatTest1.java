package cn.edu.ecut;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 1、通过 DateFormat 提供的 静态工厂方法 可以获得 DateFormat 实例，但是通常不会这样用
 *		 DateFormat.getInstance()
 *		 DateFormat.getDateInstance()
 *		 DateFormat.getTimeInstance()
 * 2、通过 DateFormat 实例的 format 方法可以将一个 Date实例 格式化为 特定模式 的字符串
 */
public class DateFormatTest1 {

	public static void main(String[] args) {
		
		final Calendar c = Calendar.getInstance();
		c.clear();
		c.set( 1999 , 9, 30, 19, 30 , 50 );
		
		final Date d = c.getTime();
		System.out.println( d );
		
		DateFormat df = DateFormat.getInstance(); // 获取默认语言环境的默认格式化风格
		
		// 将 Date实例 所表示的瞬间 用 特定格式 的 字符串 来表示
		String s = df.format( d ) ; // 将 Date实例 格式化 为特定的字符串 形式
		System.out.println( s );
		
		df = DateFormat.getDateInstance(); // 仅处理日期
		System.out.println( df.format( d ) );
		
		df = DateFormat.getTimeInstance(); // 仅处理时间
		System.out.println( df.format( d ) );

	}

}
