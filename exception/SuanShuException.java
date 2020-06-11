package cn.edu.ecut.exception;

/**
 * 1、通过 直接 或 间接 继承 RuntimeException 类来定义 运行时异常 类型
 * 2、通过 直接 或 间接 继承 Exception 类来定义 受检查异常 类型 ( 不能继承 RuntimeException 类 )
 * 3、建议 参照 父类中的构造方法 生成 自定义异常类型 的构造方法
 */
@SuppressWarnings("serial")
public class SuanShuException extends RuntimeException {
	
	public SuanShuException() {
		super();
	}

	public SuanShuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SuanShuException(String message, Throwable cause) {
		super(message, cause);
	}

	public SuanShuException(String message) {
		super(message);
	}

	public SuanShuException(Throwable cause) {
		super(cause);
	}
	
}
