package cn.edu.ecut;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest5 {

	public static void main(String[] args) {
		
		BigDecimal x = BigDecimal.valueOf( 12 , 1 ); // ( 1212 , 1 ) 、( 12 , 2 )
		System.out.println( x );
		
		BigDecimal y = BigDecimal.valueOf( 37 , 1 ) ;
		System.out.println( y );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		System.out.println( x + " + " + y + " = " + x.add( y ) );
		System.out.println( x + " - " + y + " = " + x.subtract( y ) );
		System.out.println( x + " * " + y + " = " + x.multiply( y ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// System.out.println( x + " / " + y + " = " + x.divide( y ) ); // ArithmeticException
		
		MathContext mc = new MathContext( 5 , RoundingMode.HALF_UP ) ;
		// public BigDecimal divide​( BigDecimal divisor , MathContext mc )
		System.out.println( x + " / " + y + " = " + x.divide( y , mc ) );
		
		mc = new MathContext( 3 , RoundingMode.HALF_UP ) ;
		// public BigDecimal divide​( BigDecimal divisor , MathContext mc )
		System.out.println( x + " / " + y + " = " + x.divide( y , mc ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// public BigDecimal divide​( BigDecimal divisor , int scale , RoundingMode mode )
		System.out.println( x + " / " + y + " = " + x.divide( y , 4 , RoundingMode.HALF_UP ) );
		System.out.println( x + " / " + y + " = " + x.divide( y , 3 , RoundingMode.HALF_UP ) );
		System.out.println( x + " / " + y + " = " + x.divide( y , 2 , RoundingMode.HALF_UP ) );
		System.out.println( x + " / " + y + " = " + x.divide( y , 1 , RoundingMode.HALF_UP ) );
		System.out.println( x + " / " + y + " = " + x.divide( y , 0 , RoundingMode.HALF_UP ) );
		System.out.println( x + " / " + y + " = " + x.divide( y , -1 , RoundingMode.HALF_UP ) );
		

	}

}
