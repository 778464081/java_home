package cn.edu.ecut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 Runtime 实例的 gc 方法向 JVM 建议 回收垃圾
 */
public class GarbageCollectionTest5 {

	public static void main(String[] args) throws IOException {
		
		Runtime runtime = Runtime.getRuntime();
		show( runtime );
		
		List<String> list = new ArrayList<>();
		
		String s = "" ;
		
		for( int i = 0 ; i < 10000 ; i++ ) {
			s += i ;
			list.add( s );
		}
		
		show( runtime );
		
		s = null ;
		list = null ;
		
		// 建议 垃圾回收器 执行 垃圾回收操作
		runtime.gc();
		
		show( runtime );
		
	}
	
	public static void show( Runtime runtime ) {
		long total = runtime.totalMemory();
		long free = runtime.freeMemory() ;
		System.out.println( "总内存 " + total + " Bytes , 空闲内存 " + free + " Bytes");
		System.out.println( "已使用 " + ( total - free ) + " Bytes.");
	}

}
