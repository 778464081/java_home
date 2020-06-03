package cn.edu.ecut;

public class CellPhoneTest {

	public static void main(String[] args) {
		
		/*
		// 引用变量 p 指向了 一个 CellPhone 类型的实例
		CellPhone p = new CellPhone();
		// 引用变量 s 指向了一个 Screen 类型的实例
		CellPhone.Screen s = p.new Screen();
		*/
		
		// 创建 实例内部类 Screen 类的实例
		CellPhone.Screen s = new CellPhone().new Screen();
		System.out.println( s );
		s.show();
		
		CellPhone p = s.getOuter();
		System.out.println( p );

	}

}
