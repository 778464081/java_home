package cn.edu.ecut;

public class ComputerTest {

	public static void main(String[] args) {
		
		// 声明 静态嵌套类 ( 静态内部类 ) 的 引用变量
		Computer.Brand b =  null ;
		
		// 创建 静态嵌套类 ( 静态内部类 ) 的实例
		b = new Computer.Brand();
		System.out.println( b );
		
		// 获得 Brand 类的全限定名称
		System.out.println( b.getClass().getName() );
		
		// 获得 Brand 类的规范化名称
		System.out.println( b.getClass().getCanonicalName() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 声明 非静态嵌套类 ( 实例内部类 ) 的 引用变量
		Computer.Mainboard m = null ;
		
		// 创建 非静态嵌套类 ( 实例内部类 ) 的实例
		Computer c = new Computer() ; // 首先创建外部类的实例
		m = c.new Mainboard(); // 在 外部类实例 基础之上创建 实例内部类 实例
		System.out.println( m );
		System.out.println( m.getClass().getName() ); // 全限定名称
		System.out.println( m.getClass().getCanonicalName() ); //规范化名称

	}

}
