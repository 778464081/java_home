package cn.oracle;

/**
 * 1、int length()
 * 2、boolean isEmpty() 
 * 			用于判断 当前 String 实例 所包含 字符串 是否为 空 ( 即 value.length 为 零 )
 * 3、boolean isBlank()  【 JDK 11 新增的方法 】
 * 			用于 当前 String 实例 所包含 字符串 是否为 空白 ( 仅包含了 空格 、制表符 等字符 )
 * 4、String trim() 剔除 当前 String 实例 所包含 字符串 中的首尾空白后返回新的 String 实例
 */
public class StringTestD {

	public static void main(String[] args) {
		
		String a = null ;
		System.out.println( a );
		
		String s = "" ; // 空串 不是 一个空格 或 一个制表符(Tab) ，也不是 \u0000  或 null
		System.out.println( s );
		
		System.out.println( "length : " + s.length() + " , is empty : " + s.isEmpty() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );	
		
		String t = "   	 	 	 "; // 有 空格 、 有 Tab
		System.out.println( "length : " + t.length() + " , is empty : " + t.isEmpty() + " , is blank : " + t.isBlank() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );	
		
		String x = "     hello ecuter.    ";
		System.out.println( x.length() ); // 含空白字符
		String y = x.trim() ; // 剔除首尾空白后返回新的 String 实例
		System.out.println( y.length() ); // 不含空白字符
		System.out.println( y ); // 不剔除中间空格
		
	}

}
