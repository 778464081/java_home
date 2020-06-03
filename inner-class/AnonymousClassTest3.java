package cn.edu.ecut;

import java.util.Arrays;

/**
 * 1、创建继承了某个具体类的匿名类的实例
 * 2、可以在匿名类中重写被继承类中的某些方法
 */
public class AnonymousClassTest3 {

	public static void main(String[] args) {
		
		Aircraft a = new Aircraft();
		a.fly();
		a.travel();
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Aircraft b = new Aircraft() { } ; // 父类引用 指向 子类对象 ( 因为最后的 { } 就是一个匿名类的类体 )
		System.out.println( b.getClass() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 调用 父类无参数构造方法
		Aircraft c = new Aircraft() {
			// 在匿名类中声明实例变量
			String name = "航天飞机" ;
			@Override
			public void fly() { // 重写从父类 中继承的 fly 方法
				System.out.println( this.name + "正在飞行" );
			}
		} ;
		
		c.fly(); // 调用重写后的方法
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 调用 父类有参数构造方法
		Aircraft d = new Aircraft( "飞船" ) {
			// 在匿名类中声明实例变量
			String name = "嫦娥二号" ;
			@Override
			public void fly() { // 重写从父类 中继承的 fly 方法
				System.out.println( this.name + this.type + "正在月球上空飞行" );
			}
		} ;
		
		d.fly(); // 调用重写后的方法
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Class<?> cc = d.getClass() ;  // 获得运行时类型
		System.out.println( cc.getName() ); // 全限定名称
		System.out.println( cc.getCanonicalName() ); // 规范化类名 ( 注意这里是 null )
		
		Class<?> p = cc.getSuperclass(); // 获得 c 所表示类型的父类
		System.out.println( p.getName() );
		
		Class<?>[] interfaces = cc.getInterfaces(); // 获得 c 所表示的类所实现的接口
		System.out.println( Arrays.toString( interfaces ) );

	}

}
