package cn.edu.ecut.exception;

public class ExceptionHandlingTest8 {

	public static void main(String[] args) {
		
		Integer  a = 100 ;
		Integer b = 0 ;
		
		Integer r = divide​( a , b );
		System.out.println( r );

	}
	
	/**
	 * 实现 除法运算
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @return 返回 第一个参数 除以 第二个参数 的 商
	 * @throws NullPointerException 声明方法可能抛出 空指针异常 ( NullPointerException )
	 * @throws ArithmeticException 声明方法可能抛出 算术异常 ( ArithmeticException )
	 */
	public static Integer divide​( Integer dividend , Integer divisor ) throws NullPointerException , ArithmeticException {
		Integer result = dividend / divisor ; // 商  =  被除数 / 除数 ;
		return result ;
	}

}
