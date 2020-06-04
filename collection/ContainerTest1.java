package cn.edu.ecut;

public class ContainerTest1 {

	public static void main(String[] args) {
		
		// 创建一个 初始容量 是 5 ，加载因子是 0.75 的 容器实例
		Container c = new Container( 5 );
		System.out.println( "size : " +  c.size() + " , isEmpty : " + c.isEmpty() );
		System.out.println( c.toString() );
		
		// 首次添加元素
		boolean x = c.add( 1000 ) ; // auto-boxing : 200 ---> Integer.valueOf( 1000 )
		System.out.println( x );
		
		// 第二次添加元素
		x = c.add( "两万" ) ;
		System.out.println( x );
		
		System.out.println( c.size() ); // 元素个数
		System.out.println( c.isEmpty() ); // 判断容器是否为空
		
		System.out.println( c.toString() );
		
		c.add( "王百万" );
		c.add( "杭州马" );
		c.add( "深圳马" );
		
		System.out.println( c.toString() );
		
		// 此时所添加的元素已经超过 初始容量 5 
		c.add( "东理马" );
		
		System.out.println( c.toString() );
		
		c.clear();
		
		System.out.println( "size : " +  c.size() + " , isEmpty : " + c.isEmpty() );
		System.out.println( c.toString() );
		
	}

}
