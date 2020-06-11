package cn.edu.ecut.exception;

public class ExceptionHandlingTestA {

	public static void main(String[] args) {
		
		Integer  a = 100 ;
		Integer b = 0 ;
		
		try {
			// 作为 divide 方法的调用者，
			// 要么 main 方法继续声明抛出 ( throws )
			// 要么在 main 方法内部把 divide 方法所抛出的异常捕获( try...catch )，
			Integer r = divide​( a , b );
			System.out.println( r );
		} catch (Exception e) {
			System.out.println( "出错了:" );
			e.printStackTrace();
		}
		
		System.out.println( "main end ." );

	}
	
	/**
	 * 实现 除法运算
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @return 返回 第一个参数 除以 第二个参数 的 商
	 * @throws Exception 抛出一个 受检查异常 ( 受 编译器 检查 )
	 */
	public static Integer divide​( Integer dividend , Integer divisor ) throws Exception {
		Integer result = dividend / divisor ; // 商  =  被除数 / 除数 ;
		return result ;
	}

}
