package cn.edu.ecut;

import java.math.BigDecimal;
import java.math.MathContext;

// JDK 1.5 老特性之 "import static" ( 国内资料上号称的 "静态导入" )
import static java.math.RoundingMode.HALF_UP ;

public class BigDecimalTest6 {

	public static void main(String[] args) {
		
		final BigDecimal x = BigDecimal.valueOf( 31415926 , 7 ) ;
		System.out.println( x + " : " + System.identityHashCode( x ) );
		
		BigDecimal abs = x.abs() ;
		System.out.println( abs + " : " + System.identityHashCode( abs ) );
		
		BigDecimal y = x.negate() ; // -this : this * -1
		System.out.println( y + " : " + System.identityHashCode( y ) );
		
		BigDecimal p = x.plus() ; // +this : this * 1
		System.out.println( p + " : " + System.identityHashCode( p ) );
		
		BigDecimal z = y.plus(); // +this : this * 1 
		System.out.println( z + " : " + System.identityHashCode( z ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		MathContext mc = new MathContext( 5 , HALF_UP ); // 使用 "静态导入" 后，书写简单了，但可读性变差了
		
		BigDecimal w = x.round( mc ); // 将 x 所表示的 十进制数 按照指定的 MathContext 进行取舍
		System.out.println( w + " : " + System.identityHashCode( w ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigDecimal u = x.movePointLeft( 2 ); // 将小数点向左移动两位
		System.out.println( u + " : " + System.identityHashCode( u ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		BigDecimal h = x.movePointRight( 2 ); // 将小数点向右移动两位
		System.out.println( h + " : " + System.identityHashCode( h ) );	
		

	}

}
