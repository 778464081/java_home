package cn.oracle;

/**
 * 1、String concat( String ) 将当前 字符串 与 参数给定的字符串 拼接到一个新的字符串中并返回新字符串实例
 * 2、	
 * 3、String toLowerCase() 将当前 字符串 中所有的大写英文字符转换为小写后返回新的字符串实例
 * 4、boolean equals( Object ) String 类重写了 equals 方法用于比较 两个 String 实例中所包含的字符串是否相等
 * 5、boolean equalsIgnoreCase( String ) 比较两个 String 实例中所包含的字符串是否相等 ( 忽略英文字母大小写 )
 * 6、boolean contentEquals( CharSequence ) 用于比较参数指定的 字符序列 是否与 当前 String 实例所包含的 字符串内容 相等
 * 7、int compareTo( String ) 用于比较两个字符串的 "大小"  ( 当两个字符串相等时返回 零 ( 英文字母区分大小写 ) )
 * 8、int compareToIgnoreCase( String ) 用于比较两个字符串的 "大小"  ( 当两个字符串相等时返回 零 ( 英文字母不区分大小写 ) )
 */
public class StringTestC {

	public static void main(String[] args) {
		
		String s = "abc" ;
		
		String x = s.concat( "123" );
		System.out.println( s ); // "abc"
		System.out.println( x ); // "abc123"
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );	
		
		String upper = x.toUpperCase(); 
		System.out.println( upper ); // "ABC123"
		
		String lower = upper.toLowerCase() ;
		System.out.println( lower ); // "abc123"
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );	
		
		final String a = "hello" ;
		final String b = "Hello" ;
		
		System.out.println( a.equals( b ) ); // 比较 字符串 内容时 英文字母区分大小写
		System.out.println( a.equalsIgnoreCase( b ) ) ; // 忽略英文字母区分大小写
		System.out.println( a.contentEquals( b ) ); // 区分大小写
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );	
		
		// compareTo 是一个比较方法，用于比较两个字符串的 "大小"
		System.out.println( a.compareTo( b ) ); // 考虑大小写
		// 当 两个 String 实例中所包含的 字符串内容 相同时 返回 零 ，否则返回 非零 的整数
		System.out.println( a.compareToIgnoreCase( b ) ); // 不考虑大小写
		
	}

}
