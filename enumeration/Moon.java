package cn.edu.ecut.singleton;

/**
 * "懒汉式"单例
 */
public class Moon {
	
	private static Moon moon ; // 没有直接创建 Moon 类的实例
	
	private Moon() {
	}
	
	public static Moon getInstance() {
		// 我们期望 getInstance 方法首次执行时才创建 Moon 实例
		if( moon == null ) {
			moon = new Moon();
		}
		return moon ;
	}

}
