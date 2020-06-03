package cn.edu.ecut.singleton;

/**
 * "饿汉式"单例
 * 1、将所有的构造方法私有化，以避免在该类之外创建其实例
 * 2、提供一个 类变量 用来缓存本类唯一的实例
 * 3、提供一个可以返回当前类的实例的类方法 ( 静态工厂方法 : static factory method )
 */
public class Sun {
	
	private static final Sun SUN = new Sun(); // 直接创建 Sun 实例
	
	// 构造被私有化
	private Sun() {
	}
	
	// 提供一个用来获取本类的实例的类方法
	public static Sun getInstance() {
		return SUN ;
	}

}
