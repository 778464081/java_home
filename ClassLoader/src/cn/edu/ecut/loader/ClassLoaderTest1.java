package cn.edu.ecut.loader;

/**
 * ClassLoader 类型的实例  表示 【类加载器】
 */
public class ClassLoaderTest1 {

	public static void main(String[] args) {
		
		// 获得 ClassLoaderTest1 类对应的 Class对象
		Class<?> c = ClassLoaderTest1.class ;
		
		// 获得 c 所表示的类的【类加载器】
		ClassLoader loader = c.getClassLoader();
		// jdk.internal.loader.ClassLoaders$AppClassLoader@xxxxxx
		System.out.println( loader ); 
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 获得当前线程实例
		Thread t = Thread.currentThread(); // java.lang.Thread 类的实例表示【线程】
		// 获得【上下文】【类加载器】
		ClassLoader cl = t.getContextClassLoader();
		System.out.println( cl );

	}

}
