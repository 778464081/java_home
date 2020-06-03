package cn.edu.ecut;

import java.util.Arrays;

/**
 * 创建继承了某个抽象类并实现其中所有抽象方法的匿名类的实例
 */
public class AnonymousClassTest2 {

	public static void main(String[] args) {
		
		Human h = null ;
		
		// h = new Human( "张三丰" ); // 抽象类有构造方法，但是抽象类不能实例化
		
		// 形式上，似乎是在通过 new 关键字 创建抽象类 Human 的实例 【尸体】
		// 本质上，创建一个继承了 Human 类 并实现了其中所有抽象方法的 匿名类 的实例  【借尸还魂】
		h = new Human(  "张三丰" ) { // 匿名类开始 【魂】
			@Override
			public void eat(String food) {
				System.out.println( this.name + "吃" + food );
			} 
		} ; // 匿名类结束
		
		h.eat( "西瓜" );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		h = new Human() {
			@Override
			public void eat(String food) {
				System.out.println( this.name + "吃" + food );
			} 
		};
		h.name = "张君宝" ;
		h.eat( "冬瓜" );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Class<?> c = h.getClass() ;  // 获得运行时类型
		System.out.println( c.getName() ); // 全限定名称
		System.out.println( c.getCanonicalName() ); // 规范化类名 ( 注意这里是 null )
		
		Class<?> p = c.getSuperclass(); // 获得 c 所表示类型的父类
		System.out.println( p.getName() );
		
		Class<?>[] interfaces = c.getInterfaces(); // 获得 c 所表示的类所实现的接口
		System.out.println( Arrays.toString( interfaces ) );

	}

}
