package org.malajava;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 1、对于 implements 之前的 Packet 类来说，其中指定的 X 属于 形式上 的类型参数
 * 2、对于 implements 之后的 Collection 接口来说，其中指定的 X 属于 实际 的类型参数
 */
public class Packet<X> implements Collection<X> {
	
	// 定义表示 默认初始容量 的 常量
	private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

	// 定义表示 容器最大容量 的 常量
	private static final int MAXIMUM_CAPACITY = 1 << 30;

	// 定义表示 默认加载因子 的 常量
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	// 定义一个表示 容器内部 数组的某个位置 尚未被使用的 标志
	private static final Object UNUSED = new Object();
	
	// 声明一个数组类型的引用变量
	private Object[] elements;
	// 声明一个 int 类型的变量用来统计容器中的元素个数
	private int counter; // 既表示当前容器中的元素个数也表示下次添加元素时的位置
	// 声明一个 float 类型的变量用来确定扩容时机
	private float loadFactor;

	public Packet() {
		this( DEFAULT_INITIAL_CAPACITY , DEFAULT_LOAD_FACTOR );
	}

	public Packet( int initialCapacity ) {
		this( initialCapacity , DEFAULT_LOAD_FACTOR );
	}

	public Packet( int initialCapacity, float loadFactor ) {
		// 注意这里的 initialCapacity 的取值范围是 [ 0 , MAXIMUM_CAPACITY ]
		if (initialCapacity < 0 || initialCapacity > MAXIMUM_CAPACITY ) {
			// 创建异常实例 ( 创建 RuntimeException 实例 )
			RuntimeException ex = new RuntimeException("初始容量必须是 [ 0 , " + MAXIMUM_CAPACITY + " ] 之间的正整数值");
			throw ex; // 抛出异常实例，导致当前方法立即结束
		}

		if (loadFactor <= 0 || loadFactor >= 1) {
			// 创建异常实例 ( 创建 RuntimeException 实例 )
			RuntimeException ex = new RuntimeException("加载因子必须是 ( 0 , 1 ) 之间的浮点数");
			throw ex; // 抛出异常实例，导致当前方法立即结束
		}

		// 如果前面两个 if 语句块都未进去执行，则会执行后续操作
		this.elements = new Object[initialCapacity]; // 使用默认初始容量创建数组实例
		this.loadFactor = loadFactor; // 保存用户指定的 加载因子
		this.mark(); // 将整个数组中的所有位置都标记为 UNUSED
	}
	
	private void mark() {
		// 将整个 elements 数组 填充为 UNUSED
		Arrays.fill( elements ,  UNUSED );
	}
	
	private void ensureCapacity() {
		// 当达到某个条件时，就对容器进行扩容
		if ( counter > elements.length * loadFactor) {
			// 将 原来的数组 的地址 暂存到 temp 变量中
			final Object[] temp = this.elements;
			// 扩容方式就是在原来基础上增长约 1.5 倍
			int newLength = temp.length * 3 / 2 + 1 ; 
			if( newLength > MAXIMUM_CAPACITY ) {
				RuntimeException x = new RuntimeException( "容器容量超过最大值" );
				throw x ; // 抛出异常实例导致整个方法立即结束
			}
			// 创建新数组 ( 创建一个新的、更大的数组 ) 并将新数组地址赋值到 elements 变量
			this.elements = new Object[ newLength ];
			// 将原数组中的[ 0 , counter ) 之间的元素拷贝到新数组中
			System.arraycopy(temp, 0, elements, 0, counter);
			// 后续就使用新数组 (放弃老数组) 了 ( 因为 elements 变量中存储了 新数组的地址 )
		}
	}
	
	@Override
	public boolean add( X element ) {
		this.ensureCapacity(); // 确保容器内部的数组容量足以容纳新的元素
		// 将 element 添加到 elements 数组的 counter 处
		elements[ counter ++ ] = element; // 先使用 counter 原来的值，再执行 counter 增加 1 操作
		// counter 自增之后的值既表示元素个数又表示下次添加元素时的存放位置
		return true;
	}

	@Override
	public int size() {
		return counter ;
	}

	@Override
	public boolean isEmpty() {
		return counter == 0 ;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf( o ) != -1 ;
	}
	
	public int indexOf( Object o ) {
		for( int i = 0 ; i < counter ; i++ ) {
			// 从数组中获取下标i处的元素
			Object e = elements[ i ]; 
			if( e == o || ( e != null && e.equals( o ) ) ) {
				return i ;  // 当找到指定元素时就返回相应的索引
			}
		}
		return -1 ; // 如果未找到相应的元素则返回 -1
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<X> iterator() {
		Object[] array = Arrays.copyOf( elements ,  counter );
		List<X> list = (List<X>)List.of( array );
		// 借助于 List 来获取 迭代器对象
		Iterator<X> itor = list.iterator() ;
		return itor ;
	}

	@Override
	public Object[] toArray() {
		// return Arrays.copyOf( elements ,  counter );
		Object[] array = new Object[ counter ];
		System.arraycopy( elements ,  0 ,  array ,  0 ,  counter );
		return array ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		Class<?> c = a.getClass(); // 获得 a 数组的运行时类型
		Class<?> ct = c.getComponentType(); // 获取 a 数组的 组件类型
		// 通过 java.lang.reflect.Array 类的 newInstance 方法创建一个 与 a 相同类型的数组
		Object array = Array.newInstance( ct , counter ); // counter 就是新数组的长度
		System.arraycopy( elements ,  0 ,  array ,  0 ,  counter );
		/*
		// 将 elements 数组中的 [ 0 , counter ) 之间的元素 依次赋值 给 array 数组的各个元素
		for ( int i = 0 ; i < counter ; i++ ) {
			Array.set( array ,  i , elements[i] ); // 
		}
		*/
		return ( T[] ) array ;
	}

	@Override
	public boolean remove(Object o) {
		int index = this.indexOf( o );
		if( index != -1 ) {
			// 统计需要拷贝的元素个数
			int n = counter - 1 - index ;
			// 将 elements 的 [ index + 1 , counter ) 之间的元素 拷贝 到 elements 的 [ index , counter - 1 ) 之间
			System.arraycopy( elements, index + 1 ,  elements , index , n );//【注意这行代码】
			// 将 原本的 counter - 1 处的元素 重置为 UNUSED
			elements[ counter - 1 ] = UNUSED ;
			// 因为删除了一个元素，所以 counter 需要减去 1
			counter-- ;
			return true ;// 成功删除后返回 true
		}
		return false ; // 如果未对容器造成任何影响则返回 false
	}

	@Override
	public void clear() {
		this.counter = 0;
		this.mark();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean addAll( Collection< ? extends X > c ) {
		
		final int size = counter ; // 将 曾经的 counter 变量的值保存起来
		
		if( c instanceof Packet ) { // 判断 参数传入的 c 是否是 Packet 类型
			Packet p = (Packet) c ;
			// 注意是小于 p.counter 不是小于 p.elements.length
			for( int i = 0 ; i < p.counter ; i++ ) {
				X e = (X)p.elements[ i ]; // 注意是从 p.elements 中获取下标是 i 的元素
				this.add( e ); // 调用本类中的 add 方法将元素添加到集合中 ( add 方法会导致 counter 变化 )
			}
		} else {
			// 其它类型的集合
		}
		
		return size < counter ; // 若 size 小于 后来的 counter 就表示 集合有变化
	}
	
	@Override
	public boolean containsAll( Collection<?> c ) {
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
	
	// 为了在 toString 方法中连接字符串而创建的 StringBuilder 实例
	private final StringBuilder builder = new StringBuilder();
	
	@Override
	public String toString() {
		builder.append( "[" );
		if (counter > 0) {
			for (int i = 0; i < counter; i++) {
				// 将每个元素的字符串形式追加到 builder 末尾
				builder.append( elements[i] ); 
				builder.append( i < counter - 1 ? "," : "" );
			}
		}
		builder.append( "]" );
		String s = builder.toString();
		// 将 builder 的 length 设置为 零 是为了下次使用 builder 时，从缓冲区的 第一个位置开始存放字符
		builder.setLength( 0 ); // 功能上类似于容器的 clear 方法
		return s;
	}

}
