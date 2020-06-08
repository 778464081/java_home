package ecut.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 单端队列 : add( E e ) / element() / remove()
 */
public class QueueTest1 {

	public static void main(String[] args) {
		
		// 创建一个队列 ( 接口类型的引用变量 指向了 实现类类型的对象 )
		Queue<String> queue = new LinkedList<>(); // "菱形语法"
		
		queue.add( "唐三藏" ) ; // 在队列尾部添加元素
		queue.add( "孙悟空" ) ; 
		queue.add( "小白龙" );
		queue.add( "猪悟能" );
		queue.add( "沙悟净" );
		
		System.out.println( queue );
		
		String head = queue.element() ; // 获取队列头部元素
		System.out.println( head );
		System.out.println( queue );
		
		head = queue.remove(); // 移除队列头部元素
		System.out.println( head );
		System.out.println( queue );
		
		queue.clear(); // 因为 Queue 接口继承了 Collection 接口，所以也是 collection
		// queue.element() ; // java.lang.NoSuchElementException
		// queue.remove(); // java.lang.NoSuchElementException

	}

}
