package cn.edu.ecut.reflect;

public class ClassTest3 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// 使用 Class.forName( String ) 来加载一个类并得到该类对应的 Class实例
		Class<?> c = Class.forName( "java.lang.reflect.Method" );
		System.out.println( c );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 指示被加载的类
		String className = "java.util.ArrayList" ;
		// 确定是否在加载完成后就立即初始化指定类
		boolean initialize = true ;
		// 指定加载该类的【类加载器】
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		c = Class.forName( className , initialize, loader );
		System.out.println( c );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		className = "cn.edu.ecut.loader.Panda" ;
		initialize = true ;
		loader = new EcutClassLoader( "D:/test" );
		c = Class.forName( className , initialize, loader );
		System.out.println( c );
		
	}

}
