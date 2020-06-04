package cn.edu.ecut;

import java.util.Arrays;

/**
 * 1、实现一个可以容纳任意多个、任意类型元素的容器
 * 2、这个容器类中的方法是参照 java.util.Collection 接口中定义的方法来定义的
 */
public class Container {
	
	// 声明一个数组类型的引用变量
	private Object[] elements ; 
	// 声明一个 int 类型的变量用来统计容器中的元素个数
	private int counter ; // 既表示当前容器中的元素个数也表示下次添加元素时的位置
	// 声明一个 float 类型的变量用来确定扩容时机
	private float loadFactor ;
	
	public Container() {
		this( 10 , 0.75F );
	}
	
	public Container( int initialCapacity ) {
		this( initialCapacity , 0.75F );
	}
	
	public Container( int initialCapacity , float loadFactor ) {
		if( initialCapacity <= 0 ) {
			initialCapacity = 10 ;
		}
		this.elements = new Object[ initialCapacity ];
		
		if( loadFactor <= 0 || loadFactor >= 1 ) {
			loadFactor = 0.75F ;
		} 
		this.loadFactor = loadFactor ;
	}
	
	/**
	 * 确保容器的容量 ( 实际上是数组容量 ) 足以容纳下一个元素
	 */
	private void ensureCapacity() {
		// 当达到某个条件时，就对容器进行扩容
		if( counter > elements.length * loadFactor ) {
			// 将 原来的数组 的地址 暂存到 temp 变量中
			final Object[] temp = this.elements ;
			// 创建新数组 ( 创建一个新的、更大的数组 ) 并将新数组地址赋值到 elements 变量
			this.elements = new Object[ temp.length * 3 / 2 + 1 ];
			// 将原数组中的[ 0 , counter ) 之间的元素拷贝到新数组中
			System.arraycopy( temp ,  0 ,  elements ,  0 , counter );
			// 后续就使用新数组 (放弃老数组) 了 ( 因为 elements 变量中存储了 新数组的地址 )
		}
	}
	
	/**
	 * 将 参数对应的 对象 添加到 容器 中
	 * @param element 被添加的元素
	 * @return 当 元素 成功添加到容器 后返回 true ( 因为添加元素导致容器发生了变化 )
	 */
	public boolean add( Object element ) {
		
		this.ensureCapacity();
		
		// 将 element 添加到 elements 数组的 counter 处
		elements[ counter ] = element ;
		// 对 counter 执行 自增操作 ( 增加 1 )
		counter++ ; // 自增之后的值既表示元素个数又表示下次添加元素时的存放位置
		
		return true ;
	}
	
	/**
	 * 返回容器中的有效元素个数
	 * @return
	 */
	public int size() {
		return  this.counter ;
	}
	
	/**
	 * 判断当前容器是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return counter == 0  ;
	}
	
	/**
	 * 清空容器
	 */
	public void clear() {
		this.counter = 0 ;
		Arrays.fill( elements ,  null );
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		builder.append( "\n" );
		builder.append( "容器的当前容量是: " + elements.length );
		builder.append( "\n" );
		builder.append( "容器的元素个数是: " + counter );
		builder.append( "\n" );
		
		if( counter > 0 ) {
			builder.append( "容器中的元素有: " );
			for( int i = 0 ; i < counter ; i++ ) {
				builder.append( elements[ i ] );
				builder.append( i < counter -1 ? " , " : "\n" );
			}
		} else {
			builder.append( "容器中尚未添加有效元素" );
			builder.append( "\n" );
		}
		
		builder.append( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		String s = builder.toString();
		return  s ;
	}

}
