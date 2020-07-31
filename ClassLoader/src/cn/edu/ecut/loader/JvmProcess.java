package cn.edu.ecut.loader;

import java.time.LocalDateTime;

/**
 * 启动一个Java程序就会导致一个JVM进程被自动
 */
public class JvmProcess {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println( "main : " + LocalDateTime.now() );
		
		Thread.sleep( 200000 ); // ms
		
		System.out.println( "main : " + LocalDateTime.now() );

	}

}
