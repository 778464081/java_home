package cn.edu.ecut.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test2 {

	public static void main(String[] args) {
		
		final Factory f = new Factory();
		
		// 获得当前线程上下文中的类加载器
		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		Class<?>[] interfaces = { Mi.class };
		
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke( Object proxy , Method method , Object[] args ) throws Throwable {
				String name = method.getName(); // 获得方法名称
				System.out.println( "[" + name +"] 方法将要执行了" );
				System.out.println( "降低成本，控制进货价格" );
				// 通过 method 来调用目标方法
				Object value = method.invoke( f , args ); // instance.methodName( args )
				System.out.println( "提高售价，提升利润空间" );
				return value  ;
			}
		} ;
		
		Object proxyObject = Proxy.newProxyInstance( loader , interfaces , h );
		System.out.println( proxyObject ); // proxyObject.toString()
		
		// proxyObject.produce();
		if( proxyObject instanceof Mi ) {
			Mi m = (Mi) proxyObject;
			String x = m.produce();
			System.out.println( x );
		}
		
	}

}
