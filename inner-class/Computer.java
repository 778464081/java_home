package cn.edu.ecut;

// Computer 是个外部类，它对应的 字节码 文件是 Computer.class
public class Computer { // 电脑
	
	// 直接在 外部类 的 类体括号中声明的 类，就是 嵌套类 ( Nested Classes )
	// 嵌套类 也被称作 成员内部类

	// 有 static 修饰的 嵌套类，也被称作 静态嵌套类 或 静态内部类
	static class Brand { // 铭牌
		// 对应的 字节码 文件名称是 Computer$Brand.class
	}
	
	// 没有 static 修饰的 嵌套类，也被称作 非静态嵌套类 或 非静态内部类 或 实例嵌套类 或 实例内部类
	class Mainboard { // 主板
		// 对应的 字节码 文件名称是 Computer$Mainboard.class
	}
	
	public void show() {
		
		// 局部内部类
		class Printer { 
			// 对应的 字节码 文件名称是 Computer$1Printer.class
		}
		
		Printer p = new Printer();
		System.out.println( p );
		
	}
	
	public void hello() {
		
		// 局部内部类
		class Printer { 
			// 对应的 字节码 文件名称是 Computer$2Printer.class
		}
		
		Printer p = new Printer();
		System.out.println( p );
		
	}
	
	public void welcome() {
		Object o = new Object() { 
			// 只有类体括号、不能显式指定类名
		};
		System.out.println( o.getClass() );
	}
	
	public static void main(String[] args) {
		Computer c = new Computer();
		c.welcome();
	}

}
