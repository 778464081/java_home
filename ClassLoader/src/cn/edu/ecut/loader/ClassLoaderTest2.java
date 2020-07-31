package cn.edu.ecut.loader;

/**
 *  获得 某个 【类加载器】 的父【类加载器】
 */
public class ClassLoaderTest2 {

	public static void main(String[] args) {
		
		// 获得当前线程实例
		Thread t = Thread.currentThread(); // java.lang.Thread 类的实例表示【线程】
		// 获得【上下文】【类加载器】
		ClassLoader loader = t.getContextClassLoader() ;
		do {
			System.out.println( "current => " + loader );
			//Class<?> c = loader.getClass(); // 获得 loader 实例的运行时类型
			//Class<?> pc = c.getSuperclass(); // 获得 loader 的运行时类型的父类类型
			//Class<?> gc = pc.getSuperclass(); // 获得 pc所表示的类的父类类型
			//System.out.println( "父类 : " + gc.getName() );
			// 获得 loader 的 父 【类加载器】
			loader = loader.getParent();
			System.out.println( "parent : " +  loader );
			System.out.println( "- - - - - - - - - - - -" );
		} while ( loader != null ) ;

	}

}
