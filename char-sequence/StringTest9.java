package cn.oracle;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 1、在 String 实例内部封装的 byte 数组中存储 是 字符串 按照 UTF-16LE字符集 编码后的字节序列
 * 2、在通过 String 实例 的 getBytes 方法获取字节序列时，可以指定 任意字符集
 * 3、将一组字节序列构成为 String 实例时，必须指定 将字符串编码为字节序列时 所采用的 字符集 才能保证不乱码
 */
public class StringTest9 {

	public static void main(String[] args) {
		
		final String s = "中国威武" ;
		StringHelper.perspective( s );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Charset utf = Charset.forName( "UTF-16LE" ); // 16-bit 
		
		byte[] bytes = s.getBytes( utf ) ; // 使用 UTF-16LE 字符集 将 字符串中的字符 编码为 字节序列
		System.out.println( Arrays.toString( bytes ) );
		
		byte[] array = { 45, 78, -3, 86, 1, 90, 102, 107 } ;
		String x = new String( array , utf ) ; // 使用 UTF-16LE 字符集 将 字节序列 解码为 字符串中的字符
		System.out.println( x );
		
	}

}
