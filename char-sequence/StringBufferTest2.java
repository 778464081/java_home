package cn.oracle;

public class StringBufferTest2 {

	public static void main(String[] args) {
		
		// 使用 StringBuffer 有参数构造创建一个 包含了指定字符串 str 中所有字符 的 字符串缓冲区
		StringBuffer buffer = new StringBuffer( "hello" ); // capacity  : super( str.length() + 16 );
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		buffer.append( true ).append( 100 ).append( 'A' ).append( "你好" ).append( 3.14 );
		
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		buffer.insert( 5 , "X" ).insert( 10 ,  'Y' );
		
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		buffer.reverse(); // 翻转
		
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		buffer.reverse();

		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
		buffer.append( "world" );
		
		System.out.println( "length : " + buffer.length() + " , capacity : " + buffer.capacity() + " , toString : " + buffer );
		
	}

}
