package ecut.map;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {
		
		// 使用 匿名类 实现 Comparator 接口并实现其中的 compare 方法
		Comparator<Rabbit> comparator = new Comparator<>() { 
			// 在 Java 8 中仍然需要书写为 new Comparator<Rabbit>() { ...... }
			// 从 Java 9 开始可以书写为 new Comparator<>() { ...... }
			@Override
			public int compare( Rabbit first , Rabbit second ) {
				LocalDate fd = null ; // LocalDate firstDate = null ;
				LocalDate sd = null ;// LocalDate secondDate = null ;
				// 如果 first 大于 、等于 、 小于 second 则 返回 大于零 、零 、小于零 的整数
				if( first != null && second != null && ( fd = first.getBirthdate() ) != null && ( sd = second.getBirthdate() ) != null ) {
					// 这里仍然是借助于 java.time.LocalDate 实例的 compareTo 方法实现比较
					return fd.compareTo( sd );
				}
				return 0 ;
			}
		} ;
		
		
		Rabbit r = new Rabbit( "玉兔" ,  LocalDate.of( 1996 , 10 , 10 ) );
		Rabbit a = new Rabbit( "流氓兔" ,  LocalDate.of( 1990 , 6 , 6 ) );
		Rabbit b = new Rabbit( "大白兔" ,  LocalDate.of( 1980 , 5 , 12 ) );
		
		final Rabbit[] rabbits = { r , a  , b };
		System.out.println( Arrays.toString( rabbits ) );
		
		Arrays.sort( rabbits , comparator ); // 使用比较器对 数组进行排序
		System.out.println( Arrays.toString( rabbits ) );
		
		System.out.println( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		
		final List<Rabbit> list = new ArrayList<>();
		list.add( r );
		list.add( a );
		list.add( b );
		System.out.println( list );
		
		// Collections.sort(list); // 根据 自然顺序 对 List 中的元素进行排序
		Collections.sort( list , comparator ); // 根据 比较器 对 List 中的元素进行排序
		System.out.println( list );

	}

}
