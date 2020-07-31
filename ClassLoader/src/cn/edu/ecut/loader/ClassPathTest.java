package cn.edu.ecut.loader;

public class ClassPathTest {

	public static void main(String[] args) {
		
		String classpath = System.getProperty( "java.class.path" );
		System.out.println( classpath );
		
		System.out.println( "- - - - - - - - - - - - - - - -" );
		
		final String path = "D:/test" ; // 不属于类路径
		System.out.println( path );

	}

}
