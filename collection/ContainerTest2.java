package cn.edu.ecut;

import java.util.Arrays;

public class ContainerTest2 {

	public static void main(String[] args) {
		
		// 创建一个容器实例 ( 初始容量为 16 、加载因子为 0.75F )
		Container c = new Container();
		System.out.println( c.toString() );
	
		c.add( '汉' ); // auto-boxing : '汉' ----> Character.valueOf( '汉' )
		c.add( 97 ); // auto-boxing : 97 ----> Integer.valueOf( 97 )
		c.add( null ) ; // 将 null 作为一个元素添加到 容器中
		
		System.out.println( c.toString() );
		
		c.add( "中国" );
		
		System.out.println( c.toString() );
		
		System.out.println( c.contains( "中国" ) );
		System.out.println( c.contains( "武汉" ) );
		System.out.println( c.contains( null ) );
		System.out.println( c.contains( '汉' ) );
		
		Object[] array = c.toArray();
		array[ 0 ] = '华' ;
		System.out.println( Arrays.toString( array ) );
		
		System.out.println( c.toString()  );
		
	}

}
