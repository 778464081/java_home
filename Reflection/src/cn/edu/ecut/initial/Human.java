package cn.edu.ecut.initial;

public class Human {
	
	static { // 类初始化器 (static initializer)
		System.out.println( "Human : static initializer" );
	}
	
	{ // 实例初始化器 (instance initializer)
		System.out.println( "Human : instance initializer" );
	}
	
	public Human() {
		super();
		System.out.println( "Human : constructor" );
	}

}
