package cn.edu.ecut.reflect;

public class Sheep {
	
	private static String school ; // 类变量
	
	static {
		System.out.println( "类初始化器( static initializer)" );
	}
	
	private String name ; // 实例变量
	
	Sheep() {
		super();
	}
	
	private Sheep(String name) {
		super();
		this.name = name;
	}

	public static void showSchool() { // 类方法
		System.out.println( Sheep.school );
	}
	
	public void showName() { // 实例方法
		System.out.println( this.name );
	}

}
