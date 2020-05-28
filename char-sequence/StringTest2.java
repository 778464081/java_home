package cn.oracle;

/**
 * 1、在 Java 语言中直接使用 "" 引起来的多个字符就是 字符串 ( character strings )
 * 
 * 2、在 Java 源代码中直接使用 "" 引起来的 字符串 ( character strings ) 都是 java.lang.String 类的实例 
 * 
 * 3、java.lang.String 类是个 不可变类，将来创建的每个 String 实例也都是 不可变对象 【 Strings are constant 】
 * 
 *      【 Java 8 及之前 】
 *       public final class String {
 *             private final char[]  value ; // 使用 char 数组保存字符序列
 *       }
 *  
 *      【 Java 9 及以后 】
 *       public final class String {
 *             private final byte[]  value ; // 使用 byte 数组保存字节序列 ( 字节序列是字符序列根据某种编码转换而来 )
 *       }
 */
public class StringTest2 {

	public static void main(String[] args) {
		
		// 变量 s 直接引用了 存放在 字符串常量 池 中的 String 实例
		String s = "中国是世界上最伟大的国家，没有之一" ;
		// 变量 t 引用的是 在 堆内存中重新创建的 String 实例
		String t = new String( "中国是世界上最伟大的国家，没有之一" );
		
		System.out.println( s == t ); // false
		System.out.println( s.equals( t ) ); // true
		
		System.out.println( System.identityHashCode( s ) );
		System.out.println( System.identityHashCode( t ) );

	}

}
