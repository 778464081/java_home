package cn.edu.ecut;

import java.util.Arrays;

/**
 * 【最常见的应用】使用 匿名类 实现 接口，并创建该类的实例
 */
public class AnonymousClassTest1 {

	public static void main(String[] args) {
		
		// 声明 Flyable 类型的引用变量，并将 null 赋值给该变量
		Flyable f = null ; // 引用变量 f  的 编译时类型 是 Flyable
		 
		// f = new Flyable() ; // 接口都没有构造方法，也不能被实例化
		
		// 形式上，似乎是在通过 new 关键字 创建 Flyable 接口的实例 【尸体】
		// 本质上，创建一个实现了 Flyable 接口的 匿名类 的实例  【借尸还魂】
		f = new Flyable() { // 匿名类开始   【魂】
			@Override
			public void fly() { // 在匿名类中实现 Flyable 接口中所有的抽象方法
				System.out.println( "飞飞飞，在梦里飞，想飞哪里飞哪里" );
			}
		}; // 匿名类结束
		
		f.fly();
		
		Class<?> c = f.getClass() ;  // 获得运行时类型
		System.out.println( c.getName() ); // 全限定名称
		System.out.println( c.getCanonicalName() ); // 规范化类名 ( 注意这里是 null )
		
		Class<?> p = c.getSuperclass(); // 获得 c 所表示类型的父类
		System.out.println( p.getName() );
		
		Class<?>[] interfaces = c.getInterfaces(); // 获得 c 所表示的类所实现的接口
		System.out.println( Arrays.toString( interfaces ) );

	}

}
