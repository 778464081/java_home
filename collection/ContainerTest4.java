package cn.edu.ecut;

public class ContainerTest4 {

	public static void main(String[] args) {
		
		// 创建一个容器实例
		Container c = new Container( 10 , 0.8F );
		
		c.add( "唐三藏" );
		c.add( "扈三娘" );
		c.add( "贾宝玉" );
		c.add( "猪八戒" );
		c.add( "扈三娘" );
		c.add( "贾宝玉" );
		c.add( "扈三娘" );
		c.add( "猪八戒" );
		c.add( "扈三娘" );
		
		System.out.println( c );
		
		System.out.println( c.size() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		System.out.println( c.indexOf( "扈三娘" ) );
		System.out.println( c.lastIndexOf( "扈三娘" ) );
		
	}

}
