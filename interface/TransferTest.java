package org.malajava;

public class TransferTest {

	public static void main(String[] args) {
		
		Transfer t = null ; // 变量 t 的编译时类型是 Transfer 类型
		
		t = new UGreen();
		
		// 通过 变量 t 只能调用直接在 Transfer 中声明的方法 和 Object 类中声明的方法
		t.transmission();
		
		String s = t.toString() ; // 调用 Object 类中声明的方法
		System.out.println( s );
		
		Class<?> c = t.getClass(); // 获得 运行时类型
		System.out.println( c.getName() );
		
	}

}
