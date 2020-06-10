package ecut.map;

import java.time.LocalDate;
import java.util.TreeMap;

public class TreeMapTest2 {

	public static void main(String[] args) {
		
		TreeMap<Monkey,String> ts = new TreeMap<>();
		
		Monkey m = new Monkey( "孙悟空" ,  LocalDate.of( -400 , 10 , 10 ) );
		System.out.println( m );
		ts.put( m, "斗战胜佛" ); // 如果 m 对应的类型 未实现 Comparable 接口则会抛出 ClassCastException
		
		Monkey o = new Monkey( "六耳猕猴" ,  LocalDate.of( -200 , 9 , 10 ) );
		System.out.println( o );
		ts.put( o ,  "疑似佛祖派来的卧底" );
		
		Monkey n = new Monkey( "六师傅" ,  LocalDate.of( 1959 , 4 , 12 ) );
		System.out.println( n );
		ts.put( n ,  "六师傅是个......" );
		
		System.out.println( ts );

	}

}
