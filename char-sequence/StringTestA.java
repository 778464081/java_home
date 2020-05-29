package cn.oracle;

/**
 * 1、 int length() 获取字符串长度 ( 字符串中所包含的字符个数 )
 * 2、char charAt( int ) 获取指定索引处的单个字符
 * 3、boolean contains( CharSequence ) 判断指定的 字符序列 是否存在于 当前字符串中，若存在即返回 true 否则返回 false
 * 4、int indexOf( int ch ) 查询 指定字符 在 当前字符串中首次出现的位置，若存在即返回该索引，否则返回 -1 
 * 5、int indexOf( String s ) 查询 指定字符串 在 当前字符串中首次出现的位置，若存在即返回该索引，否则返回 -1 
 * 6、int lastIndexOf( int ch ) 查询 指定字符 在 当前字符串中最后一次出现的位置，若存在即返回该索引，否则返回 -1 
 * 7、int lastIndexOf( String s ) 查询 指定字符串 在 当前字符串中最后一次出现的位置，若存在即返回该索引，否则返回 -1 
 */
public class StringTestA {

	public static void main(String[] args) {
		
		final String s = "今天天气好晴朗处处好风光好风光" ;
		for( int i = 0 , n = s.length() ; i < n ; i++ ) { // 【 int length() 】
			char ch = s.charAt( i ); // 【 char charAt( int ) 】
			System.out.print( ch );
			System.out.print( i < n - 1 ? " , " : "\n" );
		}
		
		// 因为 String 类实现了 CharSequence 接口
		CharSequence cs = "好风光" ; // 所以 用 CharSequence 类型的引用变量 指向 String 实例是可以的
		
		boolean z = s.contains( cs ) ; // 【 boolean contains( CharSequence ) 】
		System.out.println( z );
		
		// 整个字符串中的每个字符的索引 一律 从 "左" 开始统计 ( 与数组相同 )
		int index = s.indexOf( '天' ) ; // 获取 '天' 在变量 s 所指向的字符串中首次出现的位置( 索引 )
		System.out.println( index );
		
		index = s.indexOf( "好风光" ) ; // 获取 "好风光" 在变量 s 所指向的字符串中首次出现的位置( 索引 )
		System.out.println( index );
		
		System.out.println( s.indexOf( '雨' ) ); // 若不存在即返回 -1 
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		int last = s.lastIndexOf( '天' ); //  获取 '天' 在变量 s 所指向的字符串中最后一次出现的位置( 索引 )
		System.out.println( last );
		
		last = s.lastIndexOf( "好风光" ); // 获取 "好风光" 在变量 s 所指向的字符串中最后一次出现的位置( 索引 )
		System.out.println( last );
		
		System.out.println( s.indexOf( "下雨" ) ); // 若不存在即返回 -1 
		
	}

}
