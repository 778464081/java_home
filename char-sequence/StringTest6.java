package cn.oracle;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 1、获取指定字符串对应的字节序列: getBytes()
 * 2、将一组字节序列编码为一个字符串: String( byte[] ) 、String( byte[] , int , int )
 * 3、编码 : 将人类易读的字符串 转换为 一组字节序列 的过程 
 *      "中国"  ===========》{ -28, -72, -83, -27, -101, -67 }
 * 4、解码 : 将一组字节序列 转换为 人类易读的字符串 的过程
 *       { -28, -72, -83, -27, -101, -67 }  ===========》"中国"
 * 5、字符集: 从 JDK 1.4 开始 增加了 java.nio.charset.Charset 类表示字符集
 */
public class StringTest6 {

	public static void main(String[] args) {
		
		byte[] bytes = { 97 , 98 , 99 , 100 , 101 , 102 , 48 , 49 , 50 , 51 , 52 , 53 };
		
		// 通过使用 平台的默认字符集 解码 指定的 byte 数组，构造一个新的 String 实例
		String s = new String( bytes );
		System.out.println( s );
		
		String x = new String( bytes , 0 , 6 );
		System.out.println( x );
		
		bytes[ 0 ] = 65 ;
		
		System.out.println( s );
		System.out.println( x );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String t = "中国" ; 
		System.out.println( t );
		
		// 使用 平台的默认字符集 将此 String 编码 为 byte 序列，并将结果存储到一个新的 byte 数组中
		byte[] bs = t.getBytes();
		// java.util 包 中的 Arrays 类的 toString 方法可以将 数组中的元素 链接到一个字符串中
		String u = Arrays.toString( bs ); 
		System.out.println( u );
		
		String n = new String( bs );
		System.out.println( n );
		
		// String m = new String( new byte[]{ -28, -72, -83, -27, -101, -67 } )  ;
		
		byte[] b = new byte[]{ -28, -72, -83, -27, -101, -67 } ;
		String m = new String( b )  ;
		System.out.println( m );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 获得 平台的默认字符集
		Charset defaultCharset = Charset.defaultCharset() ;
		System.out.println( defaultCharset );
		
	}

}
