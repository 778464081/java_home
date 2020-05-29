package cn.oracle;

/**
 * 1、通过 String 类型的 变量 理解 == 运算符 和 equals 方法分别比较什么
 * 2、通过 System.identityHashCode( reference ) 可以获得任意引用类型变量所引用的对象的 哈希码值 
 *      ( 由 Object 类提供的 hashCode 方法所返回的 哈希码值 是根据内存地址转换而来的 )
 */
public class StringTest1 {

	public static void main(String[] args) {
		
		String s = "中国是世界上最伟大的国家，没有之一" ;
		
		String x = "中国是世界上最伟大的国家，没有之一" ;
		
		// 使用 == 运算符 比较两个变量时，一定是比较两个变量的值
		System.out.println( s == x ); // true : 说明 变量 s 和 变量 x 存储的值是相同的
		System.out.println( s.equals( x ) ); // true : String 类重写后的 equals 会比较两个字符串的内容
		
		System.out.println( System.identityHashCode( s ) );
		System.out.println( System.identityHashCode( x) );
		
		System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		
		String t = new String( "中国是世界上最伟大的国家，没有之一" );
		
		System.out.println( s == t ); // false : 说明 变量 s 和 变量 t 存储的值是不同的
		System.out.println( s.equals( t ) ); // true : String 类重写后的 equals 会比较两个字符串的内容
		
		System.out.println( System.identityHashCode( s ) );
		System.out.println( System.identityHashCode( t ) );

	}

}
