package cn.edu.ecut;

public final class RuntimeHelper {
	
	private RuntimeHelper() {
	}
	
	public static void showMemory() {
		Runtime runtime = Runtime.getRuntime();
		long total = runtime.totalMemory();
		long free = runtime.freeMemory() ;
		System.out.print( "总内存 " + total + " Bytes ，" );
		System.out.print( "已使用 " + ( total - free ) + " Bytes ，");
		System.out.println( "空闲内存 " + free + " Bytes");
	}
	
	public static void gc() {
		System.out.println( "正在向垃圾回收器建议回收垃圾" );
		Runtime.getRuntime().gc();
	}

}
