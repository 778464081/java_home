package cn.edu.ecut.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test5 {

	public static void main(String[] args) {
		
		// 【代理目标】: 谁会被别人所代理，谁就是代理目标
		final Mi target = new Factory();
		
		// 获得当前线程上下文中的类加载器
		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		Class<?>[] interfaces = { Mi.class };
		
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke( Object proxy , Method method , Object[] args ) {
				Object value = null ;
				String name = method.getName(); // 获取即将执行的方法的名称
				// 对连接点进行筛选的条件就是 【切点】
				if( name.equals( "produce" ) ) {
					try {
						// 【连接点】( 执行点 + 方位 )
						value = method.invoke( target , args ); // 通过 代理目标 执行 指定的方法 【执行点】
						// 【连接点】( 执行点 + 方位 )
					} catch ( Throwable t ) {
						// 【连接点】( 执行点 + 方位 )
					} finally {
						// 【连接点】( 执行点 + 方位 )
					}
				}
				return value  ;
			}
		} ;
		
		// 【代理对象】: 谁去代理别人，谁就是代理对象
		Object proxy = Proxy.newProxyInstance( loader , interfaces , h );
		System.out.println( proxy ); // proxyObject.toString()
		
		// proxyObject.produce();
		if( proxy instanceof Mi ) {
			Mi m = (Mi) proxy;
			String x = m.produce();
			System.out.println( x );
		}
		
	}

}
