package cn.oracle;

/**
 * 1、StringBuilder 类的设计 与 StringBuffer 基本一致 ( 父类 、实现接口 、构造 、方法 )
 * 2、StringBuilder 类中的 方法都没有 synchronized 修饰的，
 * 		 而 StringBuffer 中所有 public 方法都是有 synchronized 修饰的
 * 3、不论是 StringBuilder 还是 StringBuffer ，都可以使用 setLength 方法有效字符数 、通过 trimToSize 来调整容量 
 */
public class StringBuilderTest {

	public static void main(String[] args) {
		
		StringBuilder builder = new StringBuilder( "hello" );
		System.out.println( "length : " + builder.length() + " , capacity : " + builder.capacity() + " , toString : " + builder );
		
		builder.setLength( 0 ); // 设置 length 为 零 ( 有效字符数 为 零 )
		
		System.out.println( "length : " + builder.length() + " , capacity : " + builder.capacity() + " , toString : " + builder );
		
		builder.append( true );
		
		System.out.println( "length : " + builder.length() + " , capacity : " + builder.capacity() + " , toString : " + builder );
		
		builder.trimToSize();
		
		System.out.println( "length : " + builder.length() + " , capacity : " + builder.capacity() + " , toString : " + builder );
		
	}

}
