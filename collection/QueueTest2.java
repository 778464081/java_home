package ecut.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 单端队列 : offer( E e ) / peek() / poll()
 */
public class QueueTest2 {

	public static void main(String[] args) {
		
		// 创建一个队列 ( 接口类型的引用变量 指向了 实现类类型的对象 )
		Queue<String> queue = new LinkedList<>(); // "菱形语法"
		
		queue.offer( "唐三藏" ) ; // 在队列尾部添加元素
		queue.offer( "孙悟空" ) ; 
		System.out.println( "queue => " + queue );
		queue.offer( "小白龙" );
		queue.offer( "猪悟能" );
		System.out.println( "queue => " + queue );
		queue.offer( "沙悟净" );
		System.out.println( "queue => " + queue );
		
		String head = queue.peek() ; // 获取队列头部元素
		System.out.println( head );
		System.out.println( queue );
		
		head = queue.poll(); // 移除队列头部元素
		System.out.println( head );
		System.out.println( queue );
		
		queue.clear(); // 因为 Queue 接口继承了 Collection 接口，所以也是 collection
		
		System.out.println( queue.peek() ) ; // null
		System.out.println( queue.poll() ) ;  // null

	}

}
