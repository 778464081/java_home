package cn.edu.ecut.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcHelper {
	
	private String driver ; // 用来保存数据库驱动类
	private String url ;
	private String user ;
	private String password ;
	
	// 声明一个用来缓存 数据库连接 对象的 实例变量
	private Connection connection ;
	
	public static JdbcHelper getInstance( DatabaseType databaseType ) {
		JdbcHelper helper = new JdbcHelper(); // 创建实例
		helper.read(); // 读取属性文件中的所有内容
		helper.db( databaseType ); // 设置需要连接的数据库
		helper.init() ; // 初始化
		helper.load() ; // 加载驱动
		helper.connect(); // 建立连接
		return helper ;
	}
	
	private Properties properties ; // 用来保存属性文件中的内容
	
	/** 读取 默认位置 默认名称的 属性文件 */
	private void read() {
		
		Class<?> c = JdbcHelper.class;
		
		// 从 默认位置 (类路径根目录) 读取 默认名称 (jdbc.properties) 的 属性文件
		InputStream in = c.getResourceAsStream( "/jdbc.properties" );
		
		if( in == null ) {
			throw new DataAccessException( "类路径根目录下不存在 jdbc.properties文件" );
		} 
		
		properties = new Properties();
		
		try {
			properties.load( in );
		} catch ( IOException cause ) {
			throw new DataAccessException( "读取属性文件时发生错误" , cause );
		}
		
		
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private final StringBuffer buffer = new StringBuffer();
	private final String driverPattern = "jdbc.connection..driver";
	private final String urlPattern = "jdbc.connection..url";
	private final String usernamePattern = "jdbc.connection..username";
	private final String passwordPattern = "jdbc.connection..password";
	
	/** 根据参数指定的 pattern 和 数据库名称( name ) 来确定 需要从属性文件中读取的属性名*/
	private String naming( String pattern , String name ) {
		buffer.setLength(0); // "重置" 字符串缓冲区
		buffer.append( pattern ); // 将 driverPattern 添加到字符串缓冲区
		int last = buffer.lastIndexOf("."); // 获取最后一个圆点的索引值
		buffer.insert( last , name ); // 插入数据库名称
		return buffer.toString();
	}
	
	// 声明一个表示 当前 JdbcHelper 所支持连接的 数据库类型 的 实例变量
	private DatabaseType databaseType ; 
	
	/** 设置数据库类型  */
	private void db( DatabaseType databaseType ) {
		this.databaseType = databaseType ;
	}
	
	/** 根据指定的数据库名称来获取其相应的数据库连接信息 */
	private void findProperties(String dbname) {
		String propName = this.naming( driverPattern , dbname );
		this.driver = properties.getProperty( propName );
		propName = this.naming( urlPattern , dbname );
		this.url = properties.getProperty( propName );
		propName = this.naming( usernamePattern , dbname );
		this.user = properties.getProperty( propName );
		propName = this.naming( passwordPattern , dbname );
		this.password = properties.getProperty( propName );
	}
	
	/** 提供数据库配置信息 */
	private void init() {
		// 暂且先把数据库的配置信息用 字符串字面量 直接设置
		switch( databaseType ) {
			case MYSQL : 
				findProperties("mysql");
				break ;
			case ORACLE : 
				findProperties("oracle");
				break ;
			default : 
				throw new RuntimeException( "暂不支持该数据库" );
		}
	}
	
	// 定义一个实例变量，用来表示是否已经加载果数据库驱动
	private boolean unload = true ; // unload 为 true 表示尚未加载
	
	/** 定义专门用来加载数据库驱动类的方法 */
	private void load() {
		System.out.println( "load : 尝试加载数据库驱动" );
		if( this.unload ) { // 如果尚未加载数据库驱动
			try {
				Class.forName( this.driver ); // 加载驱动类
				this.unload = false ; // 加载成功后将 unload 修改为 false
			} catch ( ClassNotFoundException cause ) {
				// 根据捕获到的异常创建一个新的 RuntimeException 对象
				DataAccessException re = new DataAccessException( "驱动类[ " + driver +" ]加载失败" , cause ) ;
				throw re ; // 重新抛出 RuntimeException 实例
			} 
		}
	}
	
	/** 定义一个方法用于判断 Connection 是否是 "无效的" */
	private boolean isInvalid() {
		
		if( this.connection == null ) {
			// 如果 实例变量 connection 取值为 null 则认为 连接无效 ( 因为无法用 null 创建 Statement 对象 )
			return true ;
		}
		
		try {
			// boolean isValid( int timeout ) : 如果连接尚未关闭并且仍然有效，则返回 true
			// connection.isValid( 1 ) 作用是 在 1秒 中的时间内判断 数据库连接是否是 "有效的"
			return !connection.isValid( 1 ) ;  // 注意 感叹号
		} catch (SQLException e) {
			// 如果在判断 connection 是否有效时发生故障，则认为 connection 是无效的
			return true ;
		}
		
	}
	
	/** 定义专门用来获取数据库连接的方法 */
	private void connect() {
		System.out.println( "connect : 尝试建立数据库连接" );
		
		// 检查 connection 是否是无效的
		if( this.isInvalid() ) {
			try {
				// 获取新的连接
				this.connection = DriverManager.getConnection( url , user, password ) ;
			} catch ( SQLException cause ) {
				throw new DataAccessException( "数据库连接失败" , cause );
			}
		}

	}
	
	/**
	 * 根据参数指定的SQL语句来创建 PreparedStatement 对象
	 * @param sql 可能带有参数占位符的SQL语句
	 * @return 返回用来执行指定SQL的 PreparedStatement 对象
	 */
	private PreparedStatement prepare( String sql ) {
		try {
			return connection.prepareStatement( sql , Statement.NO_GENERATED_KEYS );
		} catch ( SQLException cause ) {
			throw new DataAccessException( "创建PreparedStatement实例时发生错误" , cause );
		}
	}
	
	/**
	 * 判断指定的 SQL语句是否【不是】 DML语句
	 * @param sql 被判断的SQL语句
	 * @return 当参数指定的SQL语句【不是DML语句】时返回 true
	 */
	private boolean notDML( String sql ) {
		return !sql.startsWith( "INSERT" ) && !sql.startsWith( "UPDATE" ) && !sql.startsWith( "DELETE" ) ;
	}
	
	/**
	 * 执行一个DML语句并返回受该语句影响的记录数 <br>
	 * 该方法依赖于事务的自动提交 ( connection.getAutoCommit() 返回结果为 true )
	 * @param sql 被执行的 INSERT / UPDATE / DELETE 等语句
	 * @param params 表示在DML语句中各个参数占位符的参数值 ( 需要依次序对应 : 参数值 需要与 参数占位符 的顺序一致 )
	 * @return 返回受DML语句影响的记录数
	 */
	public int update( final String sql , Object... params ) {
		
		if( notDML( sql ) ) {
			throw new DataAccessException( "[ " + sql +" ]不是DML语句" ); // 抛出自定义异常
		}
		
		// 根据参数传入的 DML语句来获得 PreparedStatement实例
		PreparedStatement ps = this.prepare( sql );
		
		// 如果被执行的DML语句中存在参数占位符的话
		if( params != null && params.length > 0 ) {
			// 就需要为参数占位符设置参数值
			this.setParameter( ps , params );
		}
		
		try {
			int count = ps.executeUpdate(); // "执行" DML 语句
			return count ;
		} catch( SQLException cause ) {
			throw new DataAccessException( "通过PreparedStatement实例执行DML操作时发生错误" , cause );
		} finally {
			// 因为 ps 变量是 update 方法的局部变量，因此必须在方法内部将其关闭
			this.close( ps ); 
		}
		
	}
	
	/**
	 * 为 PreparedStatement实例设置参数占位符的值 
	 * @param ps 需要为占位符设置参数值的 PreparedStatement对象
	 * @param params 参数值列表 ( 参数值 需要与 参数占位符 的顺序一致 )
	 */
	private void setParameter( PreparedStatement ps , Object[] params ) {
		try {
			for( int i = 0 ; i < params.length ; i++ ) {
				int paramIndex = i + 1 ;
				Object paramValue = params[ i ] ;
				ps.setObject( paramIndex , paramValue );
			}
		} catch ( SQLException cause ) {
			throw new DataAccessException( "为PreparedStatement实例的参数占位符设置参数值时发生错误" , cause );
		}
	}
	
	/** 禁用自动提交 */
	private void disable() {
		try {
			connection.setAutoCommit( false );
		} catch (SQLException cause) {
			throw new DataAccessException( "关闭自动提交时时发生错误" , cause );
		}
	}
	
	/** 启用自动提交 */
	private void enable() {
		try {
			connection.setAutoCommit( true );
		} catch (SQLException cause) {
			throw new DataAccessException( "启用自动提交时时发生错误" , cause );
		}
	}
	
	/** 提交事务 */
	private void commit() {
		try {
			connection.commit(); // 提交事务
		} catch (SQLException cause) {
			throw new DataAccessException( "提交事务时发生错误" , cause );
		}
	}
	
	/** 回滚事务 */
	private void rollback() {
		try {
			connection.rollback(); // 回滚事务
		} catch (SQLException cause) {
			throw new DataAccessException( "提交事务时发生错误" , cause );
		}
	}
	
	/**
	 * 通过该方法可以让多个DML操作在一个事务中执行。(暂不考虑多线程)
	 * @param runner 是一个用来完成多个DML操作的对象，多个DML操作可以在 Runner对象的 doInTransaction方法中完成
	 */
	public void execute( Runner runner ) {
		this.disable(); // 关闭自动提交
		try {
			this.commit(); // 开启新事务 ( 终结事务意味着另外一个事务开启)
			runner.doInTransaction(); // Exception
			this.commit(); // 提交事务
		} catch (Exception cause) {
			this.rollback(); // 回滚事务
			throw new DataAccessException( "同一个事务中执行多个DML操作时发生错误" , cause );
		} finally {
			this.enable(); // 启用自动提交
		}
	}

	/**
     * 根据查询语句返回的数据，使用指定的RowMapper将结果集封装成单个对象
	 * @param sql
     * @param rowMapper
     * @param params
     * @param <X>
     * @return
     */
	public <X> X single(String sql , RowMapper<X> rowMapper , Object...params ) {
		// 根据参数传入的 DML语句来获得 PreparedStatement实例
		PreparedStatement ps = this.prepare( sql );
				
		// 如果被执行的DML语句中存在参数占位符的话
		if( params != null && params.length > 0 ) {
			// 就需要为参数占位符设置参数值
			this.setParameter( ps , params );
		}
		
		ResultSet rs = null ;
				
		try {
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				X x = rowMapper.wrap( rs );
				return x ;
			}
			
			return null ; // 如果结果集是空的就返回null
		} catch( SQLException cause ) {
			throw new DataAccessException( "通过PreparedStatement实例执行DQL操作时发生错误" , cause );
		} finally {
			this.close( rs ); 
			this.close( ps ); 
		}
	}

	/**
     * 根据查询语句返回的数据，使用指定的RowMapper将结果集中的每行数据封装成一个对象后添加集合中并返回该集合
	 * @param sql
     * @param rowMapper
     * @param params
     * @param <X>
     * @return
     */
	public <X> List<X> list(String sql , RowMapper<X> rowMapper , Object...params ) {
		// 根据参数传入的 DML语句来获得 PreparedStatement实例
		PreparedStatement ps = this.prepare( sql );

		// 如果被执行的DML语句中存在参数占位符的话
		if( params != null && params.length > 0 ) {
			// 就需要为参数占位符设置参数值
			this.setParameter( ps , params );
		}

		ResultSet rs = null ;

		try {
			rs = ps.executeQuery();

			List<X> list = new ArrayList<>();
			while( rs.next() ) {
				X x = rowMapper.wrap( rs );
				list.add( x );
			}

			return list ;
		} catch( SQLException cause ) {
			throw new DataAccessException( "通过PreparedStatement实例执行DQL操作时发生错误" , cause );
		} finally {
			this.close( rs );
			this.close( ps );
		}
	}
	
	/**
	 * 定义一个可以关闭任意的 AutoCloseable 实例 的方法
	 * @param ac 被关闭的对象
	 */
	private void close( AutoCloseable ac ) {
		if( ac != null ) {
			try {
				ac.close();
			} catch ( Exception cause ) {
				throw new DataAccessException( "释放 " + ac.toString() + " 时发生故障" , cause );
			}
		}
	}

	/** 定义一个用于释放当前的 JdbcHelper 实例 所占用的资源的方法 */
	public void release() {
		this.close( this.connection );; // 调用已经定义好的方法
	}
	
}
