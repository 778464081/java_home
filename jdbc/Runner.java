package cn.edu.ecut.jdbc;

public interface Runner {
	
	/**
	 * 实现方法以便于让一组DML语句在同一个事务中执行
	 * @throws DataAccessException
	 */
	void doInTransaction() throws Exception ;

}
