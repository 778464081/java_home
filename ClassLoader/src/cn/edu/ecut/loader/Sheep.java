package cn.edu.ecut.loader;

public class Sheep {
	
	public static final int suibian = 0 ;
	public static final long time = System.currentTimeMillis() ;
	
	public static String school ;
	public static String type = "羊" ;
	
	static {
		System.out.println( "static initializer" );
		school = "大肥羊学校" ;
	}
	
	public static void showSchool() {
		System.out.println( school );
	}
	
	//  (主动使用) 含有 main 方法可以直接运行的类就是启动类
	public static void main(String[] args) {
		// 被标记为启动类的类在运行时会被 "初始化"
	}

}
