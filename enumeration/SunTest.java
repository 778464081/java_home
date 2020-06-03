package cn.edu.ecut.singleton;

public class SunTest {

	public static void main(String[] args) {
		
		// Sun s = new Sun(); // 不能直接实例化
		Sun s = Sun.getInstance() ; // 通过  静态工厂方法 来获取 Sun 类的实例
		System.out.println( s );
		
		Sun u = Sun.getInstance() ;
		System.out.println( u );
		
		Sun n = Sun.getInstance() ;
		System.out.println( n );

	}

}
