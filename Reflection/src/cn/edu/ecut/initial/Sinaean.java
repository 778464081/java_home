package cn.edu.ecut.initial;

public class Sinaean extends Human {
	
	public static String school ;
	
	private String name ;
	
	static { // 类初始化器 (static initializer)
		System.out.println( "Sinaean : static initializer" );
		System.out.println( school );
	}
	
	{ // 实例初始化器 (instance initializer)
		System.out.println( "Sinaean : instance initializer" );
		System.out.println( name );
		name = "邹鑫杰" ;
	}
	
	public Sinaean() {
		super(); // 调用父类无参构造
		System.out.println( "Sinaean : constructor" );
		System.out.println( name );
	}

}
