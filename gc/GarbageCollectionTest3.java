package cn.edu.ecut;

/**
 * 1、使用 Runtime 实例的 exit 方法可以导致 JVM 退出
 * 2、根据惯例，非零的状态码表示非正常终止
 */
public class GarbageCollectionTest3 {

	public static void main(String[] args) {
		
		System.out.println( "main begin" );
		
		// 获取 与 当前 Java 应用程序相关的 运行时 ( Runtime ) 对象
		Runtime runtime = Runtime.getRuntime();
		
		// 通过启动虚拟机的关闭序列，终止当前正在运行的 Java 虚拟机
		runtime.exit( 0 ); // 根据惯例，非零的状态码表示非正常终止
		
		System.out.println( "main end" );
		
	}

}
