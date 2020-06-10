package ecut.map;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest3 {

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
		
		TreeMap<Rabbit,String> ts = new TreeMap<>( comparator );
		
		Rabbit r = new Rabbit( "玉兔" ,  LocalDate.of( 1996 , 10 , 10 ) );
		System.out.println( r );
		ts.put( r , "月宫捣药" );
		
		Rabbit a = new Rabbit( "流氓兔" ,  LocalDate.of( 1990 , 6 , 6 ) );
		System.out.println( a );
		ts.put( a ,  "流氓" );
		
		System.out.println( ts );

	}

}
