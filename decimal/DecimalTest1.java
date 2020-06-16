package cn.edu.ecut;

/**
 * 使用 浮点数 完成的 算术运算 都是不精确的
 */
public class DecimalTest1 {

	public static void main(String[] args) {
		
		double a = 3.1 ;
		double b = 2.7 ;
		
		double c = a + b ;
		System.out.println( c );
		
		double d = a - b ;
		System.out.println( d );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		System.out.println( Double.MAX_VALUE );
		
		double x = 1.8 * Math.pow( 10 , 308 ); // 超出 基本数据类型所表示的数值的 最大范围
		System.out.println( x );
		
		double y = 1.8 * Math.pow( 10 , 1000 ); // 超出 基本数据类型所表示的数值的 最大范围
		System.out.println( y );

	}

}
