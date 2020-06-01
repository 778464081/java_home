package cn.edu.ecut;

import java.util.Calendar;

/**
 * 1、通过 静态工厂方法 来获取 Calendar 类的实例
 * 		  ( 这里的 静态工厂方法 就是 Calendar 类中的 返回 Calendar实例 的 类方法 )
 * 2、设置 Calendar 实例所表示的 瞬间 :
 * 			public void set( int field , int value ) 为 指定的日历字段 设置 指定的值，比如 c.set( Calendar.YEAR , 1999 )
 * 			public final void set( int year , int month , int date )
 * 			public final void set( int year , int month , int date , int hourOfDay , int minute )
 * 		    public final void set( int year , int month , int date , int hourOfDay , int minute , int second )
 */
public class CalendarTest2 {
	
	public static void main(String[] args) {
		
		String s ;
		
		// 父类类型的 引用变量 指向了 子类类型的对象
		Calendar calendar = Calendar.getInstance(); // 默认地区 、 默认时区
		System.out.println( calendar );
		System.out.println( calendar.getClass() ); // 运行时类型
		 // 在 同一个类中使用 本类声明的 类方法时可以省略类名
		s = toString( calendar ) ; // s = CalendarTest2.toString( calendar ) ;
		System.out.println( s );
		
		
		calendar.set( Calendar.YEAR ,  1999 );
		calendar.set( Calendar.MONTH , 5 ); // 注意: 鬼子那边月份从零开始计数
		calendar.set( Calendar.DATE , 10 );
		calendar.set( Calendar.HOUR_OF_DAY , 7 );
		calendar.set( Calendar.MINUTE , 50 );
		calendar.set( Calendar.SECOND , 0);
		calendar.set( Calendar.MILLISECOND , 0 );
		
		calendar.set( 1999 , 5 , 10, 7, 50 , 0 );
		calendar.set( Calendar.MILLISECOND , 0 );
		
		System.out.println( calendar );
		
		s = toString( calendar ) ; 
		System.out.println( s );
		
	}
	
	public static String toString( Calendar calendar ) {
		StringBuilder builder = new StringBuilder();
		
		int year = calendar.get( Calendar.YEAR );
		builder.append( year + "年" );
		
		// 鬼子那边的月份是从 零 开始计数的
		int month = calendar.get( Calendar.MONTH ) + 1 ;
		builder.append( month + "月" );
		
		int date = calendar.get( Calendar.DATE );
		builder.append( date + "日" );
		
		int hours = calendar.get( Calendar.HOUR_OF_DAY );
		if( hours < 10 ) {
			builder.append( '0' );
		}
		builder.append( hours + ":" );
		
		int minutes = calendar.get( Calendar.MINUTE );
		if( minutes < 10 ) {
			builder.append( '0' );
		}
		builder.append( minutes + ":" );
		
		int seconds = calendar.get( Calendar.SECOND );
		if( seconds < 10 ) {
			builder.append( '0' );
		}
		builder.append( seconds + "." );
		
		int millis = calendar.get( Calendar.MILLISECOND );
		builder.append( millis );
		
		String s = builder.toString();
		return s ;
	}
	
}

