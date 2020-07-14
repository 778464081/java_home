package cn.edu.ecut.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 实现 RowMapper接口以便于将 结果集中的 单行数据 封装到某种类型的对象中
 * @param <T> 类型参数 T表示封装后的对象的类型
 */
public interface RowMapper<T> {
	
	/**
	 * 将结果集中的当前行数据封装到 T类型的对象中
	 * @param rs 
	 * @return
	 * @throws SQLException
	 */
	T wrap(ResultSet rs) throws SQLException ;

}
