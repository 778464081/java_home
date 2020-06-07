package org.malajava;

/**
 * 1、指定具体的类型参数
 * 2、从 JDK 1.7 开始支持 "菱形语法"
 */
public class PacketTest1 {

	public static void main(String[] args) {
		
		// 声明 Packet 类型的变量时，可以指定具体的类型参数 ( 实参 )
		Packet<String> packet ;
		// 创建 Packet 实例时，也可以指定具体的类型参数 ( 实参 )
		packet = new Packet<String>();
		packet.add( "张三丰" ); // boolean add( String e )
		System.out.println( packet );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 因为 声明 Packet 类型的变量时指定的类型参数 必须与 该变量指向的 Packet 实例对应的 类型参数相同
		// Packet<Integer> p = new Packet<Integer>();
		// 所以 从 JDK 1.7 开始，可以省略 new 语句中 <> 内部的类型 ( 所谓的自动感应 = 之前所声明变量的类型参数 )
		Packet<Integer> p = new Packet<>(); // 鬼子那边将这种写法称作 "菱形语法"
		p.add( 9527 ) ; // boolean add( Integer e )
		System.out.println( p );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		var x = new Packet<>(); // Packet<Object> x = new Packet<>() ;
		System.out.println( x );
		
		x.add( "张君宝" );
		x.add( new Object() );
		x.add( 12345 );
		
		System.out.println( x );
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		var itor = x.iterator();
		while( itor.hasNext() ) {
			var e = itor.next();
			System.out.println( e);
		}

	}

}
