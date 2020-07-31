package cn.edu.ecut.proxy2;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Test1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		// 获得当前线程上下文中的类加载器
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		Class<?>[] interfaces = { Mi.class };
		
		// 第一个参数 表示 用哪个类加载器 去加载 动态产生的 类
		// 第二个参数 表示 将来动态产生的类 所实现的接口
		Class<?> proxyClass = Proxy.getProxyClass( loader, interfaces ); // 返回 动态产生的类 对应的 Class 实例
		// 动态代理类的 源代码 、字节码文件 都不存在，其相应的字节码内容被直接存放在内存中
		System.out.println( proxyClass.getName() );
		
		Class<?> p = proxyClass.getSuperclass();
		// 所有的动态代理类的直接父类都是 java.lang.reflect.Proxy 类
		System.out.println( p.getName() );
		
		Class<?>[] inters = proxyClass.getInterfaces();
		System.out.println( Arrays.toString( inters ) );
		
		// 动态代理类 内部有 哪些字段？ 有哪些方法？ 有哪些构造?
		// 通过反射计数来 偷窥 一下 动态代理类
		
	}

}
