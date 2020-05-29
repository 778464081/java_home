package cn.oracle;

import java.util.Arrays;

/**
 * 1、boolean startsWith( String ) 判断 当前 String 实例 中所包含的字符串 是否以指定的 字符串 为【前缀】
 * 2、boolean endsWith( String ) 判断 当前 String 实例 中所包含的字符串 是否以指定的 字符串 为【后缀】
 * 3、boolean startsWith( String s , int from ) 
 * 			判断 当前 字符串 从指定位置开始 是否以指定的 字符串 为前缀
 * 4、void getChars( int begin , int end , char[] array , int start )
 * 			将 当前 String 实例 中所包含的字符串 中 [ begin , end ) 之间的字符 拷贝到 array 数组的 start 位置
 * 5、String substring( int begin )  从当前字符串中的 begin 位置处开到字符串末尾截取并返回新字符串
 * 6、String substring( int begin , int end ) 从当前字符串中截取[ begin , end ) 之间的内容并返回新字符串
 * 7、CharSequence subSequence( int begin , int end ) 从当前字符串中截取[ begin , end ) 之间的内容并返回 CharSequence 实例
 */
public class StringTestE {

	public static void main(String[] args) {
		
		final String path = "D:/java-beginner/char-sequence/StringHelper.java" ;
		
		System.out.println( path.startsWith( "D:" ) ); // true
		System.out.println( path.startsWith( "C:" ) );  // false
		
		System.out.println( path.endsWith( ".java" ) ); // true
		System.out.println( path.endsWith( ".class" ) );  // false
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );	
		
		// 判断 从索引 17 处开始 是否是 已 "char" 为前缀
		System.out.println( path.startsWith( "char" , 17 ) ); // true
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );	
		
		char[] array = new char[ 10 ];
		System.out.println( Arrays.toString( array ) );
		String str = "沧海一声笑滔滔两岸潮" ;
		
		// 将 str 所指向的 String 实例中所包含的 字符串 中 [ 5 , 10 ) 之间的字符 拷贝到 array 数组中
		// 并在 array 数组的 索引 0 处 开始存放拷贝的字符
		str.getChars( 5 , 10, array , 0 );
		System.out.println( Arrays.toString( array ) );
		
		str.getChars( 0 , 5, array , 5 );
		System.out.println( Arrays.toString( array ) );
		
		String u = str.substring( 5 ); // [ 5 , length() - 1 ]
		System.out.println( u );
		
		String v = str.substring( 3 , 7 ) ; // [ 3 , 7 )
		System.out.println( v );
		
		CharSequence cs = str.subSequence( 2 ,  8 ) ; // [ 2 , 8 )
		System.out.println( cs );
		System.out.println( cs.getClass() );
		
	}

}
