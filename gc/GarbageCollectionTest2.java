package cn.edu.ecut;

/**
 * 1、获取 java.lang.Runtime 类的实例并测试 availableProcessors / totalMemory / freeMemory / maxMemory
 * 2、小任务:  将 以 long 类型的整数表示的 字节数 ( byte ) 转换为 xxMB xxKB xxBytes 形式
 */
public class GarbageCollectionTest2 {

	public static void main(String[] args) {
		
		// 获取 与 当前 Java 应用程序相关的 运行时 ( Runtime ) 对象
		Runtime runtime = Runtime.getRuntime();
		
		// availableProcessors 方法用于 向 Java 虚拟机返回可用处理器的数目
		int p = runtime.availableProcessors(); // 注意是 "虚拟处理器" 个数
		System.out.println( p );
		
		long total = runtime.totalMemory();// 返回 Java 虚拟机中的内存总量
		long max = runtime.maxMemory() ; // 返回 Java 虚拟机试图使用的最大内存量
		long free = runtime.freeMemory() ; // 返回 Java 虚拟机中的空闲内存量
		System.out.println( total + "Bytes , " + max + "Bytes , " + free + "Bytes");
		
		Runtime rt = Runtime.getRuntime();
		System.out.println( runtime == rt ); // true
		
	}

}
