package org.malajava;

public class Main {

	public static void main(String[] args) {
		
		// USB u = new USB(); // Cannot instantiate the type USB
		
		USB usb = null ; // USB 是 usb 的 编译时类型
		
		// 接口类型的引用变量 指向了 其实现类类型的实例
		usb = new UGreen() ;
		usb.charge(); // 充电
		usb.transmission(); // 传输数据
		
		usb = new HuaWei();
		usb.charge(); // 充电
		usb.transmission(); // 传输数据
		
	}

}
