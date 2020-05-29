package cn.oracle;

import java.nio.charset.Charset;
import java.util.Arrays;

public class StringTest8 {

	public static void main(String[] args) {
		
		final String s = "中国威武" ;
		System.out.println( s); // 正常
		
		Charset first = Charset.forName( "GBK" ); // 每个汉字占两个字节
		Charset second = Charset.forName( "UTF-8" );
		
		byte[] firstBytes = s.getBytes( first ); // 使用 GBK 字符集 将 字符串 编码 为 字节序列
		System.out.println( Arrays.toString( firstBytes ) );
	
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String x = new String( firstBytes , second ); // 使用 指定的字符集 将 字节序列 解码 为 字符串
		System.out.println( x ); // 乱码
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String y = new String( firstBytes , first ); // 使用 指定的字符集 将 字节序列 解码 为 字符串
		System.out.println( y ); // 正常
		
	}

}
