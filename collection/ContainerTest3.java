package cn.edu.ecut;

public class ContainerTest3 {

	public static void main(String[] args) {
		
		// 创建一个容器实例
		Container c = new Container( 10 , 0.8F );
		
		c.add( "华安" );
		c.add( 9527 ); // auto-boxing
		c.add( null );
		c.add( '中' ); // auto-boxing
		
		System.out.println( c );
		
		System.out.println( c.indexOf( null ) );
		System.out.println( c.indexOf( "null" ) );
		System.out.println( c.contains( null ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
	
		boolean x = c.remove( 8526 ); // auto-boxing
		System.out.println( x ); // false
		System.out.println( c );
		
		System.out.println( c.remove( 9527 ) ); // auto-boxing
		System.out.println( c );
		System.out.println( c.remove( '中' ) ); // auto-boxing
		System.out.println( c );
		
		System.out.println( c.remove( "华安" ) );
		System.out.println( c );
		
		System.out.println( c.remove( null ) );
		System.out.println( c );
		
	}

}
