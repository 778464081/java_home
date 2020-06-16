package cn.edu.ecut;

import java.io.IOException;

/**
 * 1、使用 Runtime 实例的 exec 放可以执行指定的命令
 * 2、可以尝试使用 Java 程序 让自己的 Windows 系统 注销/关闭/重启
 */
public class GarbageCollectionTest4 {

	public static void main(String[] args) throws IOException {
		
		System.out.println( "main begin" );
		
		// 获取 与 当前 Java 应用程序相关的 运行时 ( Runtime ) 对象
		Runtime runtime = Runtime.getRuntime();
		
		//runtime.exec( "notepad" );// 在 Windows 环境下会执行 C:\Windows\notepad.exe 
		//runtime.exec( "mspaint" );// 在 Windows 环境下会执行 C:\Windows\System32\mspaint.exe 
		runtime.exec( "jconsole" );// 运行 JAVA_HOME 下 bin 目录中的 jconsole 命令
		
		System.out.println( "main end" );
		
	}

}
