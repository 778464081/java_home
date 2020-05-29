package cn.oracle;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 1、常用字符集
 *      GBK :  简体中文
 *      	全称《汉字内码扩展规范》（GBK即“国标”、“扩展”汉语拼音的第一个字母，英文名称：Chinese Internal Code Specification）
 *      UTF-8 : 可以表示 西欧诸国字符 、东亚诸国字符 (但是不是全部)
 *      	8位元，Universal Character Set/Unicode Transformation Format）是针对 Unicode 的一种可变长度字符编码
 *      ISO-8859-1 : 
 *      	编码是单字节编码，向下兼容ASCII，其编码范围是0x00-0xFF，0x00-0x7F之间完全和ASCII一致，0x80-0x9F之间是控制字符，0xA0-0xFF之间是文字符号
 *      Latin1 : 
 *      	Latin1 是ISO-8859-1的别名，有些环境下写作 Latin-1
 *      Big 5 : 繁体中文（正体中文）
 *      
 * 2、通过 Charset.forName( name ) 方法可以获得指定名称的字符集对应的 Charset 实例
 * 
 * 3、根据指定的 字符集 将 字符串 编码为 字节序列
 * 
 * 4、同一个字符串(尤其是东亚诸国字符)通过不同的字符集编码后的字节序列是不相同的
 */
public class StringTest7 {

	public static void main(String[] args) {
		
		// 如果为 Charset.forName( name ) 指定的参数 ( 一个字符编码的名称) 是不被JVM支持的，
		// 则会抛出 ava.nio.charset.UnsupportedCharsetException
		Charset first = Charset.forName( "GBK" );
		System.out.println( first + " , " + first.getClass().getName() );  // 输出 字符串形式 和 运行时类型的名称
		
		Charset second = Charset.forName( "UTF-8" );
		System.out.println( second + " , " + second.getClass().getName()  );
		
		Charset third = Charset.forName( "Big5" );
		System.out.println( third  + " , " + third.getClass().getName() );
		
		Charset fourth = Charset.forName( "ISO-8859-1" );
		System.out.println( fourth  + " , " + fourth.getClass().getName() );
		
		Charset fifth = Charset.forName( "Latin1" );
		System.out.println( fifth  + " , " + fifth.getClass().getName() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String s = "中国威武" ;
		
		// 使用 平台的默认字符集 将此 String 编码 为 byte 序列，并将结果存储到一个新的 byte 数组中
		byte[] defaultBytes = s.getBytes();
		System.out.println( "默认的 : " + Arrays.toString( defaultBytes ) );
		
		// 使用给定的 charset 实例 将此 String 编码 为 byte 序列，并将结果存储到新的 byte 数组
		byte[] firstBytes = s.getBytes( first );  // GBK
		System.out.println( first + " : " + Arrays.toString( firstBytes ) );
		
		byte[] secondBytes = s.getBytes( second ); // UTF-8
		System.out.println( second + " : " + Arrays.toString( secondBytes ) );
		
		byte[] thirdBytes = s.getBytes( third ); // Big5
		System.out.println( third + " : " + Arrays.toString( thirdBytes ) );
		
		byte[] fourthBytes = s.getBytes( fourth ); // ISO-8859-1
		System.out.println( fourth + " : " + Arrays.toString( fourthBytes ) );
		
	}

}
