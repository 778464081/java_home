package cn.oracle;

/**
 * 1、 int indexOf( int ch , int from ) 
 * 			从 当前字符串中 指定位置(from) 开始寻找 指定字符 ( ch ) 首次出现的位置，若存在即返回该索引，否则返回 -1 
 * 2、int indexOf( String s , int from ) 
 * 			从 当前字符串中 指定位置(from) 开始寻找 指定字符串 ( s ) 首次出现的位置，若存在即返回该索引，否则返回 -1 
 * 3、int lastIndexOf( int ch , int from ) 
 * 			从 当前字符串中 指定位置(from) 开始反向寻找 指定字符 ( ch ) 最后一次出现的位置，若存在即返回该索引，否则返回 -1 
 *         即获取在 from 处及其之前 ch 最后一次出现的位置是什么
 *         ( 反向寻找的顺序是 from 、from - 1  、from - 2 、........ )
 * 4、int lastIndexOf( String s , int from ) 
 * 			从 当前字符串中 指定位置(from) 开始反向寻找 指定字符串 ( s ) 最后一次出现的位置，若存在即返回该索引，否则返回 -1 
 * 			即获取在 from 处及其之前 s 最后一次出现的位置是什么
 */
public class StringTestB {

	public static void main(String[] args) {
		
		final String s = "/string/test.html" ;
		
		int index ;
		int last ;
		
		index = s.indexOf( '/' ) ;
		last = s.lastIndexOf( '/' );
		System.out.println( index + " , " + last );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		index = s.indexOf( '/' , 10 ); // 从 索引 10 开始 向后寻找 '/' 字符首次出现的位置
		last = s.lastIndexOf( '/' , 12); // 从 索引 37 处开始 反向寻找 '/' 字符 最后一次出现的位置
		System.out.println( index + " , " + last );
		
	
		
	}

}
