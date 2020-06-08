package ecut.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1、接口 java.util.Deque 是 java.util.Queue 接口的子接口
 * 2、java.util.Deque 表示双端队列 ( double ended queue )
 * 3、为了方便区分队列头和队列为，建议使用 队列对象的字符串形式 来区分
 *       比如: 
 *             以 "字符串形式" 左侧为头部，以 "字符串形式" 右侧为尾部
 *             以 "字符串形式" 右侧为头部，以 "字符串形式" 左侧为尾部
 * 4、如果 以 "字符串形式" 左侧为头部，以 "字符串形式" 右侧为尾部 则
 * 			offerLast / peekFirst / pollFirst 分别表示 在队列尾部添加元素 、检查队列头部元素、移除并返回队列头部元素
 * 			addLast / getFirst / removeFirst
 */
public class DequeTest1 {

	public static void main(String[] args) {
		
		Deque<String> deque = new LinkedList<>();
		
		// 将 deque 所指向的 对象当做一个普通集合来使用
		deque.add( "韩信" );
		deque.add( "晁错" );
		deque.add( "窦婴" );
		
		// 输出 deque 所指向对象的字符串形式
		System.out.println( deque ); // 通过 字符串 形式 来 区分 哪里是头，哪里是尾
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		/* = = = = 以 "字符串形式" 左侧为头部，以 "字符串形式" 右侧为尾部 = = = = */
		deque.offerLast( "李广" ); // 通过 offerLast 方法在队列尾部添加元素
		deque.offerLast( "李敢" );
		deque.offerLast( "李凌" );
		
		System.out.println( deque ); // 再次输出字符串形式
		
		String head = deque.peekFirst(); // 通过 peekFirst 方法可以检查队列头部的元素 (但不删除)
		System.out.println( head );
		
		System.out.println( deque );
		
		head = deque.pollFirst(); //  通过 pollFirst 方法可以移除队列头部元素(并返回该元素)
		System.out.println( head );
		
		System.out.println( deque ); 
		
		deque.clear(); // 清空集合 ( 将双端队列对象 当做集合使用 )
		System.out.println( deque.peekFirst() ); // null
		System.out.println( deque.pollFirst() ); // null
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		deque.addLast( "李广" ); // 通过 addLast 方法在队列尾部添加元素
		deque.addLast( "李敢" );
		deque.addLast( "李凌" );
		
		System.out.println( deque );
		
		System.out.println( deque.getFirst() );
		System.out.println( deque.removeFirst() );
		
		System.out.println( deque );
		
		deque.clear();
		
		// System.out.println( deque.getFirst() ); // NoSuchElementException
		// System.out.println( deque.removeFirst() ); // NoSuchElementException


	}

}
