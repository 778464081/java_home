package cn.edu.ecut;

public class Test {

	public static void main(String[] args) {
		
		Removable r = null ;
		
		// 接口不是类，没有构造方法，不能实例化
		// r = new Removable() ; // Cannot instantiate the type Removable
		
		// 接口类型的引用变量 指向了 其实现类类型的实例
		r = new Tiger();
		r.move(); // 移动
		
		Class<?> c = r.getClass() ; // 获得 运行时类型
		System.out.println( c.getName() );
		
		// Class 类的 getSuperclass() 方法用于获得 某个类的直接父类
		Class<?> p = c.getSuperclass(); // 获得 c 所表示的类的父类
		System.out.println( p.getName() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 任意一个类型都可以通过 .class 来获取该类型对应的 Class 对象
		Class<?> rc = Removable.class ; 
		System.out.println( rc.getName() );
		
		Class<?>  rp = rc.getSuperclass(); // 获得 rc 所表示的类的父类
		System.out.println( rp == null ? "没有父类" : rp.getName() );
		
		// Class 类中的 getInterfaces() 方法 用于 获得 某个接口继承的所有父接口对应的数组 或 获得某个类直接实现的所有接口组成的数组
		Class<?>[] interfaces = rc.getInterfaces();
		System.out.println( interfaces );
		System.out.println( interfaces.length );

	}

}
