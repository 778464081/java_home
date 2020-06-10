package ecut.map;

import java.util.Arrays;

public class HashTest3 {
	
	private static class Node {
		Object item ; // 存储数据的实例变量
		Node next ;
		public Node( Object item , Node next ) {
			super();
			this.item = item;
			this.next = next;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append( String.valueOf( item ) ) ;
			if( next != null ) {
				builder.append( "|" );
				builder.append( next.toString() ) ;
			}
			return builder.toString() ;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		Object[] table = new Object[ 10 ];
		System.out.println( Arrays.toString( table ) );
		
		add( 77 , table);
		System.out.println( Arrays.toString( table ) );
		
		add( 7 , table );
		System.out.println( Arrays.toString( table ) );
		
		add( 177 , table );
		add( 277 , table );
		System.out.println( Arrays.toString( table ) );
		
		add( 22 , table );
		System.out.println( Arrays.toString( table ) );

	}

	public static void add( int value , Object[] table) {
		int index = hash( value , table.length ); 
		if( table[ index ] == null ) { //如果 index 处不存在元素 ( 假设 null 就表示不存在元素 )
			// 就将 参数传入的值 直接放入该位置
			table[ index ] = value ; // auto-boxing
		} else { // 如果 index 处已经存在数据
			Object o = table[ index ] ; // 获取 在 index 处所存放的数据
			if( o instanceof Node ) { // 按照链表方式处理 ( 遍历链表，找最后一个，把 新的 Node 添加到末尾 )
				Node node = (Node) o ;
				while( node.next != null ) {
					node = node.next ;
				}
				Node newNode = new Node( value , null ); // 创建新节点
				node.next = newNode ; // 让曾经的最后一个节点指向 新的节点
			} else {
				// 根据 参数传入的值 构造一个新的 Node 对象
				Node newNode = new Node( value , null ); // 第二个参数使用 null 表示它是最后一个
				// 根据 index 处已经存在的元素 创建第一个节点
				Node firstNode = new Node( o , newNode ); // 第一个节点指向 新数据 对应的节点
				// 将第一个节点添加到 index 处
				table[ index ] = firstNode ;
			}
		}
	}
	
	public static int hash( int value , int length ) {
		// 根据 某个值 和 数组 长度 计算 该值应该在数组的哪个位置存放
		return value % length ;
	}

}
