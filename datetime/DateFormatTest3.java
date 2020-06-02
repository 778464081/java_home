package cn.edu.ecut;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过 SimpleDateFormat实例 来完成 将符合 特定模式 的 字符串 解析为 Date实例
 */
public class DateFormatTest3 {

	public static void main(String[] args) throws ParseException {
		
		String source = "公元2044年10月30日 星期日 19:30:50.000" ;
		
		final String pattern = "Gyyyy年MM月dd日 EEEE HH:mm:ss.SSS" ;
		// 父类类型的引用 变量 指向了 子类类型的对象
		DateFormat df = new SimpleDateFormat( pattern );
		
		Date d = df.parse( source ); // 可能触发 ParseException 异常
		System.out.println( d );

	}

}
