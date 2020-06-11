package cn.edu.ecut.exception;

public class ExceptionHandlingTestC {
	
	public static void main(String[] args) {
		System.out.println( "main begin ..." );
		Integer  a = 100 ;
		Integer b = 0 ;
		divide​( a ,  b );
		System.out.println( "main end ." );
	}
	
	/**
	 * 实现 除法运算
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @return 返回 第一个参数 除以 第二个参数 的 商
	 * @throws Exception 抛出一个 受检查异常 ( 受 编译器 检查 )
	 */
	public static Integer divide​( Integer dividend , Integer divisor ){
		Integer result = null ;
		try {
			result = dividend / divisor ; // 商  =  被除数 / 除数 ;
		} catch( NullPointerException | ArithmeticException cause ) {
			String message = "执行除法运算时发生错误" ;
			//【异常转译】以已经捕获到的异常为原因创建另外一个异常实例
			SuanShuException sse = new SuanShuException( message , cause ); // 创建新的异常实例
			throw sse ; // 抛出异常实例
		}
		return result ;
	}

}
