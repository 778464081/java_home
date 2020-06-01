package cn.edu.ecut;

import java.util.Date;

/**
 * 1、类 Date 表示特定的 瞬间 ，精确到毫秒 
 *      ( The class Date represents a specific instant in time, with millisecond precision . )
 * 2、Date 类的实例内部封装了一个 毫秒值 ( 从 历元 至 某一瞬间 所经历的 毫秒值 )
 * 3、历元( Epoch ) : 1970 年 1 月 1 日 00:00:00 GMT ( GMT : 格林尼治标准时间 )
 * 4、CST : China Standard Time , 中国标准时间
 */
public class DateTest1 {

	public static void main(String[] args) {
		
		// 使用 Date 类的 无参构造 创建 Date 实例
		Date now = new Date(); 
		System.out.println( now );
		
		long millis = System.currentTimeMillis() ; // 获取 从 历元 至 现在所经历的 毫秒数 ( 毫秒值 )
		System.out.println( millis );
		// 使用 Date 类带有一个 long 类型参数的构造 创建 Date 实例
		Date date = new Date( millis ); 
		System.out.println( date ); // date.toString()
		
		long ms = date.getTime(); // 获取在 Date 实例内部封装的 毫秒值
		System.out.println( ms );
		
		date.setTime( 1000000L );
		System.out.println( date );
		
		long t = date.getTime(); // 获取在 Date 实例内部封装的 毫秒值
		System.out.println( t );
		
	}

}
