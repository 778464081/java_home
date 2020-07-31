package cn.edu.ecut.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test6 {

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
						// 【切面( Aspet)】 =  Pointcut + Advice
						System.out.println( "方法【"+ name +"】即将执行" ); // 在连接点 织入 的代码 就是 Advice
						// 切面: 在哪里 加什么
						value = method.invoke( target , args ); // 通过 代理目标 执行 指定的方法 【执行点】
						System.out.println( "方法【"+ name +"】执行后返回了【" + value + "】" );
					} catch ( Throwable t ) {
						System.out.println( "方法【"+ name +"】执行发生错误【" + t.getMessage() + "】" );
					} finally {
						System.out.println( "方法【"+ name +"】执行结束" );
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
