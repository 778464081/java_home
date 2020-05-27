package cn.edu.ecut;

// 可移动的
public interface Removable {
	
	// 在 接口 中只能声明 常量 ，不能声明 普通成员变量
	char UNIT = '米' ; // 等同于 public static final char UNIT = '米' ;
	
	// 在 接口 中所有的 没有方法体 的方法默认都是 public abstract 修饰的
	void move(); // 等同于 public abstract void move() ;
	
	// 接口不可以有构造方法
	//public Removable() { } // Interfaces cannot have constructors
	
	// 从 Java 8 开始 允许在 接口中声明 default 修饰的 、非抽象的 实例方法
	public default void welcome() { // 实现类可以重写 由接口提供的 default 方法
		System.out.println( this ); // 实例方法中可以使用 this 关键字
		System.out.println( "Removable#welcome()" );
	}
	
	
	// 从 Java 8 开始 允许在接口中声明 static 修饰的方法 ( 被 static 修饰的方法绝对不可能是抽象的 )
	public static void hello() {
		System.out.println( "Removable.hello()" );
	}
	
	// 因为  从 Java 8 开始 可以在接口中声明 static 修饰的方法，所以定义一个 main 方法也不足为奇
	public static void main(String[] args) {
		Removable.hello();  // 通过 接口名 来调用 接口中声明的 static 方法
		
		Removable r = null ;
		// r.hello(); // 对于接口来说，不允许使用 接口类型的引用变量 来调用 其内部的 static 方法
		r = new Tiger();
		r.welcome(); // 调用在 接口中声明的 default 修饰的 实例方法
	}

}
