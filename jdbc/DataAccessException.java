package cn.edu.ecut.jdbc;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 4278089023224881622L;

	public DataAccessException() {
		super();
	}
	
	public DataAccessException(String message) {
		super(message);
	}
	
	public DataAccessException(Throwable cause) {
		super(cause);
	}
	
	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
