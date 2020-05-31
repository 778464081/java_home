package cn.oracle;

/**
 * 1、字符串 ( character strings ) 缓冲区 ( buffer ) : string buffer 根据 Java 中类的命名规范命名为 StringBuffer
 * 2、与 String 类的实例一样，StringBuffer 类的实例 也用于 封装 字符串 ( character strings )
 * 3、与 String 类的实例 不可变 不同，StringBuffer 类的实例 是 可变的，因此每次操作 都会影响 StringBuffer 实例
 * 4、StringBuffer 类中定义了大量的用来操作 字符串缓冲区 的方法: append / insert / replace / deleteCharAt / delete
 */
public class StringBufferTest1 {

	public static void main(String[] args) {
		
		// 使用 StringBuffer 无参数构造创建一个 空的 字符串缓冲区
		StringBuffer buffer = new StringBuffer();
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		buffer.append( false ); // 在 字符缓冲区中 追加内容
		
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		buffer.insert( 0 , "hello," );
		
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		buffer.replace( 5 , 6 , "，" );
		
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		int index = buffer.indexOf( "，" );
		
		buffer.deleteCharAt( index );
		
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		buffer.delete( 5 , 10 );
		
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );

	}

}
