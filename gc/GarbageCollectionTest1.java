package cn.edu.ecut;

/**
 * 1、在 Windows 命令提示符 或 Linux 终端 中输入 jconsole 可以启动 "Java监视和管理控制台"
 * 2、在 "Java监视和管理控制台" 中 可以连接指定的 JVM 进程，从而了解 JVM 的运行状况
 */
public class GarbageCollectionTest1 {

	public static void main(String[] args) {
		System.out.println( "main begin" );
		while( true );
		// System.out.println( "main end" ); // Unreachable code
	}

}
