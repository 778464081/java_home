package ecut.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListTest {

	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		
		list.add( 100 );
		list.add( 10 );
		list.add( 20 );
		list.add( 1000 );
		
		System.out.println( list );
		
		Queue<String> queue = new LinkedList<>();
		
		queue.offer( "刘彻" );
		queue.offer( "刘启" );
		queue.offer( "刘恒" );
		
		System.out.println( queue );
		
		Deque<String> deque = new LinkedList<>();
		
		deque.offerLast( "刘彻" );
		deque.offerLast( "刘启" );
		deque.offerLast( "刘恒" );
		
		System.out.println( deque );
		
		Deque<String> stack = new LinkedList<>();
		
		stack.push( "刘彻" );
		stack.push( "刘启" );
		stack.push( "刘恒" );
		
		System.out.println( deque );

	}

}
