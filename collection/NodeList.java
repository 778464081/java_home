package ecut.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 用 链表 的方式 实现 List 接口
 */
public class NodeList<E> implements List<E>{
	
	private Node<E> first ; // 指向链表中第一个节点的指针
	private Node<E> last ; // 指向链表中最后一个节点的指针
	
	// 声明一个私有的嵌套类，用于封装 链表 中的一个节点
	private static class Node<E> {
		
		E item ; // 实例变量 item 用于保存【数据项】
		Node<E> next ; // 实例变量 next 用于引用下一个节点
		@SuppressWarnings("unused")
		Node<E> previous ; // 实例变量 previous 用于引用前一个节点
		
		Node( Node<E> previous , E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.previous = previous;
        }
		
	}
	
	@Override
	public String toString() {
		final String separator = "," ;
		StringBuilder builder = new StringBuilder( "[" );
		// 将 链表中的每个 节点 中的 数据项 连接成字符串返回
		Node<E> node = first ; 
		while( node != null ) {
			builder.append( node.item ); // 将每个节点的数据项连接到字符串中
			builder.append( separator );
			node = node.next ; // 获取下一个节点
		}
		int index = builder.lastIndexOf( separator );
		builder.deleteCharAt( index ) ;
		builder.append( ']' );
		
		return builder.toString() ;
	}
	
	@Override
	public boolean add( E element ) {
		// 实现将元素添加到 链表 末尾
		if( first == null ) { // 如果 链表 中不存在第一个节点
			// 则根据 参数值 来创建 一个新的节点，并将其当做 链表 中的第一个节点
			first = new Node<E>( null , element , null );
			last = first ; // 同时，第一个也就是最后一个 ( 因为只有一个 )
		} else { // 如果链表中已经存在节点
			// 根据 参数值 创建一个新的节点
			Node<E> node = new Node<E>( last , element , null ); // 新的节点以曾经的 last 节点为 前一个节点
			last.next = node ; // 让 曾经的 last 节点指向 新创建的节点
			last = node ; // 以新创建的节点为 最后一个节点
		}
		return true ;
	}
	
	@Override
	public void add( int index, E element ) {
		//【找到指定的索引，并将元素插入到该位置】
	}
	
	@Override
	public E remove( int index ) {
		//【根据索引删除指定位置的元素】
		return null;
	}
	
	@Override
	public boolean remove(Object o) {
		return false;
	}
	
	@Override
	public E get(int index) {
		return null;
	}
	
	@Override
	public E set(int index, E element) {
		return null;
	}
	
	@Override
	public void clear() {
		// 将 表示 元素个数 的 实例变量修改为 零
		// 将 first 改为 null ，将 last 改为 null
	}
	
	@Override
	public int size() {
		// 统计 链表 中的 元素个数
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// 判断集合是否为空
		return false;
	}
	
	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	
	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

}
