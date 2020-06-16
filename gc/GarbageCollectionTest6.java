package cn.edu.ecut;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、使用 Thread.sleep( long ) 方法可以让当前的线程睡眠
 * 2、线程睡眠时即可通过 jconsole 来启动 "Java监视和管理控制台" 并连接到该程序对应的 JVM 进程
 */
public class GarbageCollectionTest6 {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println( "JVM启动" );
		
		Thread.sleep( 20000 ); // 让当前线程(main)睡眠 (以毫秒为单位)
		
		System.out.println( "开始创建对象" );
		
		List<String> list = new ArrayList<>();
		
		String s = "" ;
		
		for( int i = 0 ; i < 10000 ; i++ ) {
			s += i ;
			list.add( s );
		}
		
		Thread.sleep( 15000 ); // 让当前线程(main)睡眠 (以毫秒为单位)
		
		System.out.println( "准备垃圾回收" );
		
		s = null ;
		list = null ;
		
		// 建议 垃圾回收器 执行 垃圾回收操作
		System.gc();
		
		System.out.println( "垃圾回收后" );
		
		Thread.sleep( 150000 );
		
	}

}
