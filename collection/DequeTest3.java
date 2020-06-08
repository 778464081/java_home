package ecut.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest3 {
	
	public static void main(String[] args) {
		
		Deque<String> d = new LinkedList<>();
		
		// 以 "字符串形式" 左侧为头部，以 "字符串形式" 右侧为尾部
		d.offerLast( "韩信" ); // 在队列尾部添加元素
		d.offer( "晁错" ); // 与 offerLast 等效
		d.offerLast( "窦婴" );
		System.out.println( d.toString() );
		
		System.out.println( d.pollFirst() + " 出队" ); // 出队 : 先进先出 ( FIFO : First In , First Out )
		System.out.println( "队列: " + d.toString() );
		
		System.out.println( d.pollFirst() + " 出队"); 
		System.out.println( "队列: " + d.toString() );
		
		System.out.println( d.pollFirst() + " 出队"); 
		System.out.println( "队列: " + d.toString() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 以 "字符串形式" 右侧为头部，以 "字符串形式" 左侧为尾部
		d.offerFirst( "李广" );
		d.offerFirst( "李敢" );
		d.offerFirst( "李凌" );
		
		System.out.println( "队列: " + d.toString() );
		
		System.out.println( d.pollLast() + " 出队"); // 移除 队列头部 元素
		System.out.println( "队列: " + d.toString() );
		
		System.out.println( d.pollLast() + " 出队");
		System.out.println( "队列: " + d.toString() );
		
		System.out.println( d.pollLast() + " 出队");
		System.out.println( "队列: " + d.toString() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 以 "字符串形式" 右侧为【栈顶】，以 "字符串形式" 左侧为【栈底】 
		d.offerLast( "刘彻" ); // 向【栈顶】压入元素
		d.offerLast( "刘启" ); // 向【栈顶】压入元素
		d.offerLast( "刘恒" ); // 向【栈顶】压入元素
		System.out.println( d.toString() );
		
		System.out.println( d.peekLast() ) ; // 检查栈顶元素
		System.out.println( d );
		
		System.out.println( d.pollLast() ) ; // 弹出栈顶元素
		System.out.println( d );
		
		System.out.println( d.pollLast() ) ; // 弹出栈顶元素
		System.out.println( d );
		
		System.out.println( d.pollLast() ) ; // 弹出栈顶元素
		System.out.println( d );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 以 "字符串形式" 左侧为【栈顶】，以 "字符串形式" 右侧为【栈底】 
		d.offerFirst( "乾隆" );
		d.offerFirst( "雍正" ); 
		d.offerFirst( "康熙" ); // 向【栈顶】压入元素
		
		System.out.println( d );
		
		System.out.println( d.peekFirst() ) ; // 检查栈顶元素
		System.out.println( d );
		
		System.out.println( d.pollFirst() ) ; // 弹出栈顶元素
		System.out.println( d );
		
		System.out.println( d.pollFirst() ) ; // 弹出栈顶元素
		System.out.println( d );
		
		System.out.println( d.pollFirst() ) ; // 弹出栈顶元素
		System.out.println( d );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// java.util.Deque 接口中直接定义了 "栈" 操作相关的方法:  push( E item ) / peek() / pop() 
		
		d.push( "武则天" ); // 将元素压入栈顶
		d.push( "李治" );
		d.push( "李世民" );
		d.push( "李渊" );
		
		System.out.println( d );
		
		System.out.println( d.peek() ) ; // 检查栈顶元素
		System.out.println( d );
		
		System.out.println( d.pop() ) ; // 弹出栈顶元素
		System.out.println( d );
		
		System.out.println( d.pop() ) ; // 弹出栈顶元素
		System.out.println( d );
		
		System.out.println( d.pop() ) ; // 弹出栈顶元素
		System.out.println( d );
		
	}

}
