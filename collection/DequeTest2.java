package ecut.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1、如果 以 "字符串形式" 右侧为头部，以 "字符串形式" 左侧为尾部 则
 * 			offerFirst / peekLast / pollLast 分别表示 在队列尾部添加元素 、检查队列头部元素、移除并返回队列头部元素
 * 			addFirst / getLast / removeLast
 */
public class DequeTest2 {

	public static void main(String[] args) {
		
		Deque<String> deque = new LinkedList<>();
		
		/* = = = = 以 "字符串形式" 右侧为头部，以 "字符串形式" 左侧为尾部 = = = = */
		deque.offerFirst( "李广" ); // 通过 offerFirst 方法在队列尾部添加元素 (注意哪里是头部)
		deque.offerFirst( "李敢" );
		deque.offerFirst( "李凌" );
		
		System.out.println( deque ); 
		
		System.out.println( deque.peekLast() ); // 通过 peekLast 方法可以检查队列头部的元素 (但不删除)
		
		System.out.println( deque );
		
		System.out.println( deque.pollLast() ) ; //  通过 pollLast 方法可以移除队列头部元素(并返回该元素)
		
		System.out.println( deque ); 
		
		deque.clear(); // 清空集合 ( 将双端队列对象 当做集合使用 )
		
		System.out.println( deque.peekLast() ); // null
		System.out.println( deque.pollLast() ); // null
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		deque.addFirst( "李广" ); // 通过 addLast 方法在队列尾部添加元素 (注意哪里是队列头)
		deque.addFirst( "李敢" );
		deque.addFirst( "李凌" );
		
		System.out.println( deque );
		
		System.out.println( deque.getLast() );
		
		System.out.println( deque );
		
		System.out.println( deque.removeLast() );
		
		System.out.println( deque );
		
		deque.clear();
		
		// System.out.println( deque.getLast() ); // NoSuchElementException
		// System.out.println( deque.removeLast() ); // NoSuchElementException


	}

}
