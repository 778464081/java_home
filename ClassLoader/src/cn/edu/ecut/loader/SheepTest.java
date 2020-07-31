package cn.edu.ecut.loader;

public class SheepTest {

	public static void main(String[] args) {
		
		//  (主动使用) 访问某个类中直接声明的类变量时会导致该类被"初始化"
		// System.out.println( Sheep.school );
		
		//  (主动使用) 调用某个类中直接声明的类方法时会导致该类被"初始化"
		// Sheep.showSchool();
		
		Sheep s = null ;
		System.out.println( "- - - - - -" );
		//  (主动使用) 创建某个类的实例时会导致该类被"初始化"
		s = new Sheep();
		System.out.println( s );
		
	}

}
