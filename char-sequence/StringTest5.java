package cn.oracle;

/**
 * 1、public static String format( String format , Object... args )
 * 2、public static String join​( CharSequence delimiter , CharSequence... elements ) 【 JDK 1.8 开始提供 】
 */
public class StringTest5 {

	public static void main(String[] args) {
		
		 int one = 123456789;
		 double two = 123456.789;
		 String s = String.format( "第一个参数：%,d 第二个参数：%,.2f", one , two );
		 System.out.println(s);
		 
		 // JDK 1.8 开始定义了 join 方法
		 String x = String.join( "===" , "张三丰" , "张君宝" , "觉远大师" , "杨过" , "郭襄" );
		 System.out.println( x );
		 
		 // 注意 split 是个实例方法，一定要通过 String 实例来调用
		 String[] array = x.split( "===" ) ; // 将一个 String 实例中的 字符串 按照指定的 表达式 拆分成 String 数组
		 for( int i = 0 ; i < array.length ; i++ ) {
			 System.out.println( array[ i ] );
		 }

	}

}
