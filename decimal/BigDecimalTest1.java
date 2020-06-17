package cn.edu.ecut;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest1 {

	public static void main(String[] args) {
		
		BigDecimal a = new BigDecimal( 100 ); // int
		System.out.println( a );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigDecimal b = new BigDecimal( "200300400500600700800900" ); // String
		System.out.println( b );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigDecimal c = new BigDecimal( 3.14 ); // double
		System.out.println( c );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~" );

		BigDecimal d = new BigDecimal( "3.14" ); // String
		System.out.println( d );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigInteger unscaledValue = new BigInteger( "FFFFFFFFFFFFFFFF" , 16 );
		int scale = -1000 ;
		
		BigDecimal f = new BigDecimal( unscaledValue , scale ); // ( BigInteger , int )
		System.out.println( f );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~" );

	}

}
