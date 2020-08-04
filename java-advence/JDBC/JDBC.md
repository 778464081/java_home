# JDBC介绍

## 什么是JDBC

JDBC 全称是 **Java Database Connectivity** 

**它是⼀种基于Java语⾔的数据库访问技术**，由 Sun 公司于 1996 年制定的⼀种技术规范 

⽐ JDBC 更早的是由 Microsoft 制定的 ODBC ( Open Database Connectivity )

## JDBC可以做什么

使⽤ JDBC 可以连接到数据库服务器 ( 通常被称作连接数据库 ) 

通过 JDBC 可以在 Java 应⽤程序向数据库服务器发送需要执⾏的SQL 语句 ( 通常被称作”执⾏"SQL语句 ) 

通过 JDBC 可以获取数据库返回的结果 (⽐如返回数据库执⾏SQL语句后的返回结果、获取元数据等)

## JDBC是如何工作的

![](C:\Users\要不要买菜\Desktop\java-advence\Snipaste_2020-07-03_20-52-49.jpg)

Sun公司(JCP)提供访问数据库的接⼝，各数据库⼚商提供对这些接⼝的实现 

Java程序员并不需要知道数据库⼚商具体怎么实现，只需要针对接⼝进⾏编程即可 

编程时所需要的接⼝和类被定义在 java.sql 和 javax.sql 包中

## JDBC Driver

数据库⼚商对 JDBC API 的实现统称做JDBC驱动 

JDBC驱动是JDBC应⽤程序跟数据库之间的转换层，它负责将JDBC调⽤映射成数据库调⽤

## JDBC Core Api

![](C:\Users\要不要买菜\Desktop\java-advence\Snipaste_2020-07-03_20-56-13.jpg)

![](C:\Users\要不要买菜\Desktop\java-advence\Snipaste_2020-07-03_20-57-16.jpg)

# JDBC中常用的类和接口

## Connection接口

connection接口代表与特定的数据库的连接。

**常用方法：**

​		createStatement（）： 创建Statement对象

​		createStatement（int resultSetType, int resultSetConcurrency）: 创建一个statement对象，该对象将生成具有给定类型、并发性、和可保存性的ResultSet对象

​		preparedStatement() : 创建预处理对象preparedStatement

​		isReadOnly(): 查看当前connection对象的读取模式是否为只读形式

​		setReadOnly(): 设置当前对象的读写模式，默认是非只读模式

​		commit()： 使所有上一次的提交/回滚后进行的更改成为持久更改，并释放此connection对象当前持有的所有数据库锁

​		rollback(): 取消在当前事务中进行的所有更改，并释放此connection对象当前持有的所有数据库锁。

​		close(): 立即释放此对象的数据库和JDBC资源，而不是等待它们被自动释放。

## Statement接口

statement接口用于咋在已经建立连接的基础上向数据库发送SQL语句。

在JDBC中有三种statement对象，分别是statement、preparedstatement、和callablestatement。

statement对象用于执行不带参数的简单的SQL语句、

preparedstatement继承了statement，用来执行动态的SQL语句、

callablestatement继承了preparedstatement，用于执行对数据库的存储过程的调用。

**常用方法：**

​	execute（String sql）： 执行静态select语句，该语句可能返回多个结果集

​	executeQuery（String sql）：执行给定的SQL语句，该语句返回单个ResultSet对象

​	clearBatch() ：清空此Statement对象的当前SQL命令列表

​	executeBatch(): 将一批命令提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组。数组元素的排序与SQL语句的添加顺序对应。

​	addBatch(String sql)：将给定的SQL命令添加到此statement对象的当前命令列表中，如果驱动程序不支持批量处理，将抛出异常

​	close():释放statement实例占用的数据库和JDBC资源。



## PreparedStatement接口

该接口用来动态地执行SQL语句。

常用方法：参见《Java从入门到精通》P368

## DriverManager类

该类用来管理数据库中的所有驱动程序。它是JDBC的管理层，作用于用户和驱动程序之间，跟踪可用的驱动程序，并在数据库的驱动程序之间建立连接。

如果通过getConnection（）方法可以建立连接，则经连接返回，否则抛出异常。

常用方法：

​	getConnection（url,user,password）：获取数据库的连接

​	setLoginTimeout():获取驱动程序试图登录到某一数据库时可以等待的最长时间，以秒为单位。

​	println（String message）: 将一条消息打印到当前JDBC日志流中。

## ResultSet接口

Resultset接口类似于一个临时表，用来暂时存放数据库查询操作所获得的结果集。

ResultSet实力具有指向当前数据行的指针，指针开始的位置在第一条记录的前面，通过next()方法向下移动。

​	在JDBC2.0（jdk1.2之后），给接口添加了一组更新方法updateXXX（），该方法有两个重载方法，可根据列的索引号和列的名称来更新指定列。但该方法并没有将对数据进行的操作同步到数据库中，需要执行update（）或insertRow() 更新数据库。

常用方法：

参见《Java从入门到精通》P368

# 使用JDBC

## 工作步骤：

![](C:\Users\要不要买菜\Desktop\java-advence\Snipaste_2020-07-03_21-00-35.jpg)

## 加载驱动：

**loading the Driver：**

```java
// 创建驱动类的实例 ( 创建类的实例，将导致类加载器加载并初始化该驱动类 )

 java.sql.Driver driver = **new** com.mysql.jdbc.Driver() ; // MySQL  之前可以使⽤ com.mysql.jdbc.Driver 

 java.sql.Driver driver = **new** com.mysql.**cj**.jdbc.Driver() ; // 从**MySQL 8** 开始，使⽤ com.mysql.cj.jdbc.Driver 替代了com.mysql.jdbc.Driver 

// 通过 反射 加载驱动类 

 Class.forName( "oracle.jdbc.OracleDriver" ); // 从 Oracle 10g 开始，建议使⽤ oracle.jdbc.OracleDriver 类⽽不是 oracle.jdbc.driver.OracleDriver类
```

**Register the JDBC driver:**

```java
// 创建驱动类的实例 ( 创建类的实例，将导致类加载器加载并初始化该驱动类 )
 java.sql.Driver driver = new com.mysql.cj.jdbc.Driver() ; // 这⾥使⽤了 MySQL . 的驱动类 
// 当创建驱动类的实例之后，需要将该实例注册给 DriverManager ( 驱动管理器 )
 DriverManager.registerDriver( driver ); 
// 只有向 DriverManager 注册驱动后，才能通过 DriverManager 来获得数据库连接 
// 获得数据库连接必须指定数据库的 连接地址(url) 、⽤⼾名(user) 、密码(password)，这将在之后予以说明
 Connection connection = DriverManager.getConnection( url , user, password );
```

通过 DriverManager 类的静态⽅法 registerDriver 可以注册⼀个驱动 

因为 DriverManager 会尽可能试着加载它可以找到的驱动程序 ，因此⼤多数时候不需要执⾏该操作 

⽐如通过 反射加载 某个数据库驱动类时，即使不显式注册相应的驱动，DriverManager也会找到该驱动类并完成实例化和注册操作

**上述代码可总结为：**

```java
// 通过反射加载数据库驱动类
 Class.forName( "oracle.jdbc.OracleDriver" ); 
// 加载驱动后，即可通过 DriverManager 类的静态⽅法来获得取数据库连接
 Connection connection = DriverManager.getConnection( url , user, password );
```

DriverManager 管理⼀组 JDBC 驱动程序的基本服务 

在加载某⼀ Driver 类时，它应该创建⾃⼰的实例并向 DriverManager 注册该实例 

这意味着⽤⼾可以通过调⽤以下程序来 **加载** 和 **注册** ⼀个驱动程序: 

Class.forName( "oracle.jdbc.OracleDriver" ) 

DriverManager 会找到该驱动类并完成实例化和注册操作

## 加载连接

![](C:\Users\要不要买菜\Desktop\java-advence\Snipaste_2020-07-03_21-12-52.jpg)

**连接Oracle数据库：**

```java
// 指定数据库驱动类的名称(连接Oracle数据库，因此写的是Oracle驱动类名)
final String driver = "oracle.jdbc.OracleDriver" ; 
// 指定数据库连接地址(请根据实际情况更换数据库实例名称(SID))
final String url = "jdbc:oracle:thin:@127.0.0.1:1521:malajava" ; // 这⾥的 malajava 即为 SID
// 指定连接数据库使⽤的⽤⼾名(请根据实际情况更换⽤⼾名)
final String user = "malajava" ; 
// 指定连接数据库使⽤的密码(请根据实际情况更换密码)
final String password = "malajava" ; 
// 加载数据库驱动
 Class.forName( driver ); 
// 获取数据库连接
 Connection connection = DriverManager.getConnection( url , user, password );
```

**连接MySQL数据库（MySQL 5.7）：**

```java
// 指定数据库驱动类的名称(连接MySQL数据库，因此写的是MySQL驱动类名)
final String driver = "com.mysql.jdbc.Driver" ; // 这⾥采⽤ MySQL  之前的驱动
 // 在 MySQL 早期版本中，建议指定连接 MySQL 数据库时使⽤的参数信息 ( 参数useUnicode⽤来指定是否使⽤Unicode，参数characterEncoding⽤来指定编码名称 )
 final String params = "?useUnicode=true&characterEncoding=utf8&useSSL=false" ; 
// 指定数据库连接地址
final String url = "jdbc:mysql://127.0.0.1:3306/information_schema" + params ;
// 创建 Properties 集合
 Properties props = new Properties(); 
// 指定连接数据库使⽤的⽤⼾名(请根据实际情况更换⽤⼾名)
props.setProperty( "user" , "root" ); 
// 指定连接数据库使⽤的密码(请根据实际情况更换密码)
props.setProperty( "password" , "root" ); 
// 加载数据库驱动
 Class.forName( driver ); 
// 获取数据库连接
 Connection connection = DriverManager.getConnection( url , props );
```

## 创建Statement对象

```java
// 指定数据库驱动类的名称(连接MySQL数据库，因此写的是MySQL驱动类名)
final String driver = "com.mysql.cj.jdbc.Driver" ; // 这⾥采⽤ MySQL 8 的驱动
// 指定数据库连接地址( 连接 MySQL  时，其它⼏个参数可以省略，但必须指定 serverTimezone 参数 )
final String url = "jdbc:mysql://127.0.0.1:3306/malajava?serverTimezone=Asia/Shanghai" ; // Asia/Shanghai 表⽰时区编号( timezone ID )
final String user = "root" ; // 请根据实际情况确定⾃⼰的⽤⼾名
final String password = "root" ; // 请根据实际情况确定⾃⼰的密码 
 Class.forName( driver ); // 加载数据库驱动
 Connection connection = DriverManager.getConnection( url , user , password ); // 获取数据库连接
 Statement statement = connection.createStatement(); // 创建 Statement 对象
```

![](C:\Users\要不要买菜\Desktop\java-advence\Snipaste_2020-07-03_21-20-26.jpg)

## 发送SQL语句

```java
// 创建需要"执⾏"的 SQL 语句 ( 这⾥"执⾏"的是 适⽤于MySQL数据库的 DDL 语句 )
 String SQL = "CREATE TABLE t_users ( id INT(10) PRIMARY KEY auto_increment , name VARCHAR(150) , gender CHAR(3) ) " ; 
// ⽤ executeUpdate ⽅法"执⾏" SQL 语句 ( 可以⽤来 "执⾏" DML 语句或 DDL 语句 ) 
int n = statment.executeUpdate( SQL ) ; 
 System.out.println( n );
```

​			**DCL**:data control language,数据控制语言：grant 、revoke

​			**DDL**:data definition language,数据定义语言：create table、alter table、truncate table、drop table

​			**DML:**data manipulation language ,数据操纵语言:insert、update、delete

​			**TCL:**transaction control language,事务控制语言:commit 、rollback、set transaction

​			**DQL:**data query language ,数据查询语言

```java
// 创建需要 "执⾏" 的查询语句
 String SQL = "SELECT id , name , gender FROM t_users WHERE name LIKE '张%' " ; 
// "执⾏" 查询语句
 ResultSet rs = statement.executeQuery( SQL );
 System.out.println( rs ) ;
```

**public** ResultSet executeQuery( String SQL )  执⾏给定的 SQL 语句，该语句返回单个 ResultSet 对象



```java
String SQL = "SELECT id , name , gender FROM t_users " ; 
// 如果 "执⾏" 的 SQL 语句是 查询语句 (导致Statement返回的第⼀个结果是ResultSet) 则 execute ⽅法返回 true 
// 如果 "执⾏" 的是 DML(导致数据库返回受影响的记录数) 或 DDL(数据库没有结果返回) 则 execute ⽅法返回 false 
boolean executeResult = statment.execute( SQL ); 
 System.out.println( executeResult ) ;
```

**Statement接口中的execute方法可以执行任意SQL语句**



![](C:\Users\要不要买菜\Desktop\java-advence\Snipaste_2020-07-03_21-37-49.jpg)

```java
final String driver = "com.mysql.cj.jdbc.Driver" ; 
final String url = "jdbc:mysql://127.0.0.1:3306/malajava?serverTimezone=Asia/Shanghai" ; 
final String user = "root" ; 
final String password = "root" ; 
 Class.forName( driver ); // 加载数据库驱动
 Connection connection = DriverManager.getConnection( url , user , password ); // 获取数据库连接
 Statement statment = connection.createStatement(); // 创建 Statement 对象
 String SQL = " CREATE TABLE t_student ( id INT(10) PRIMARY KEY auto_increment , name VARCHAR(150) , gender CHAR(3) , birthdate DATE ) " ; 
// 使⽤ executeUpdate 或 executeLargeUpdate ⽅法 执⾏ DDL 语句 
long count = statment.executeLargeUpdate( SQL );
 System.out.println( count );
```

**如果 executeUpdate 或 executeLargeUpdate 执⾏的是 DDL 语句，则⽅法的返回值是 0** 

但绝不能因为⽅法执⾏后返回 0 就断定执⾏的⼀定是 DDL 语句，因为执⾏DML语句也有可能导致⽅法返回 0

**若 executeUpdate 或 executeLargeUpdate 执⾏的是 DML 语句，则⽅法返回受当前 DML 语句影响的记录数**

## 使用PreparedStatement



```java
final String driver = "com.mysql.cj.jdbc.Driver" ; 
final String url = "jdbc:mysql://127.0.0.1:3306/malajava?serverTimezone=Asia/Shanghai&useServerPrepStmts=true&cachePrepStmts=true" ; 
final String user = "root" ; 
final String password = "root" ; 
 Class.forName( driver ); 
 Connection conn = DriverManager.getConnection( url , user , password ); 
// 创建带有 参数占位符 的 SQL 语句 ( 问号 即为 参数占位符 )
 String SQL = "INSERT INTO t_student ( name , gender ) VALUES ( ? , ? ) " ; 
// 创建 PreparedStatement 对象，并将带有 参数占位符 的 SQL 语句发送给 数据库服务器
 PreparedStatement ps = conn.prepareStatement( SQL ) ; 
ps.setString( 1 , "赵敏" ) ; // 为特定位置的 参数占位符 指定 参数值
ps.setString( 2 , "⼥" ) ; // // 第⼀个参数表⽰ 参数占位符 的位置，第⼆个参数表⽰ 参数占位符 的 参数值
int count = ps.executeUpdate() ; // 将各个 参数占位符 的 参数值 发送给数据库服务器，并获取执⾏结果
```

**执⾏带有参数占位符的SQL时须⽤不带参数的 execute() 、executeUpdate() 、executeLargeUpdate() 、executeQuery() 等⽅法来执⾏；**

```java
String SQL = "INSERT INTO t_student ( name , birthdate ) VALUES ( ? , ? ) " ; 
 PreparedStatement ps = conn.prepareStatement( SQL ) ; 
ps.setString( 1 , "张⽆忌" ) ; 
ps.setDate( 2 , new java.sql.Date( System.currentTimeMillis() ) ) ; // 参数值必须是 java.sql.Date 类型 
int count = ps.executeUpdate() ;
```

## 释放资源

```java
final String driver = "com.mysql.cj.jdbc.Driver" ; 
final String url = "jdbc:mysql://127.0.0.1:3306/malajava?serverTimezone=Asia/Shanghai" ; 
final String user = "root" ; 
final String password = "root" ; 
 Class.forName( driver ) ; // 加载驱动程序
 Connection conn = DriverManager.getConnection( url , user , password ) ; // 创建数据库连接
 Statement stmt = conn.createStatement() ; // 创建 Statement 对象
if( !stmt.isCloseOnCompletion() ) { // 判断该 Statement 对象 是否未打开 "closeOnCompletion" ( 注意条件中的 感叹号 )
 stmt.closeOnCompletion() ; // 此⽅法执⾏后，依赖于该 Statement 对象的所有 ResultSet 都被关闭时，⾃动关闭该对象
 } 
 ResultSet rs = stmt.executeQuery( "SELECT id , name , gender , birthdate FROM t_student" ) ;
rs.close() ; // 当依赖于某个 Statement 对象的所有 ResultSet 都被关闭时 , ⾃动关闭该 Statement 对象
```

# Metadatas

**什么是Metadatas：**

​			⽤来描述数据的数据、描述信息的信息叫做元数据( MetaData )；

```java
final String driver = "com.mysql.cj.jdbc.Driver" ; 
final String url = "jdbc:mysql://127.0.0.1:3306/malajava?serverTimezone=Asia/Shanghai" ; 
final String user = "root" ; 
final String password = "root" ; 
 Class.forName( driver ) ; 
 Connection conn = DriverManager.getConnection( url , user , password ) ; 
 DatabaseMetaData meta = conn.getMetaData() ; // 获取数据库元数据
 System.out.println( "数据库名称: " + meta.getDatabaseProductName() ) ; 
 System.out.println( "数据库版本: " + meta.getDatabaseProductVersion() ) ; 
 System.out.println( "数据库驱动名称: " + meta.getDriverName() ) ; 
 System.out.println( "数据库驱动版本: " + meta.getDriverVersion() ) ;
```

**⽤ Connection 的 getMetaData() 可以获得 数据库元数据**





**Database Metadata:**

```java
 DatabaseMetaData meta = connection.getMetaData(); 
// 判断此数据库驱动是否⽀持给定结果集类型 ( 在 java.sql.ResultSet 中定义 )
boolean t = meta.supportsResultSetType( ResultSet.TYPE_SCROLL_INSENSITIVE ) ; 
 System.out.println( t ); 
// 判断此数据库驱动是否⽀持与给定结果集类型结合在⼀起的给定并发性类型 (在 java.sql.ResultSet 中定义 )
boolean c = meta.supportsResultSetConcurrency( ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE ) ; 
 System.out.println( c ); 
// 判断此数据库驱动是否⽀持给定结果集可保存性 ( 在 java.sql.ResultSet 中定义 )
boolean h = meta.supportsResultSetHoldability( ResultSet.HOLD_CURSORS_OVER_COMMIT ) ; 
 System.out.println( h );
```





**ResultSet MetaDate:**

```java
// 执⾏查询操作，获得结果集
 ResultSet rs = statement.executeQuery( "SELECT id , name , gender FROM t_student" ); 
// 获取 结果集元数据
 ResultSetMetaData meta = rs.getMetaData(); 
final int count = meta.getColumnCount() ; // 获取结果集中的列数
for( int i = 1 ; i <= count ; i++ ){ // 注意，列索引从 1 开始计数
 System.out.print( "label : " + meta.getColumnLabel( i ) ) ; // 获取⽤于打印输出和显⽰的指定列的建议标题
 System.out.print( " , " ) ; 
 System.out.print( "type : " + meta.getColumnTypeName( i ) ) ; // 获取指定列的数据库特定的类型名称
 System.out.print( " , " ) ; 
 System.out.println( "size : " + meta.getColumnDisplaySize( i ) ) ; // 指⽰指定列的最⼤标准宽度，以字符为单位
 }
```

**⽤ ResultSet 的 getMetaData() 可以获得 结果集元数据**

## Parameter Metadate

**在MySQL中创建 存储结果：**

```sql
 -- 创建 存储过程 ( 仅适⽤于 MySQL 数据库 )
 create procedure getname( in userid int(10) , out uname varchar(150) ) 
 begin
 select u.name into uname from t_users u where u.id = userid ; 
 end
```

**调用存储过程：**

```java
CallableStatement cs = connection.prepareCall( "call getname( ? , ? )" ) ; // 创建 CallableStatement 对象并调⽤存储过程
ParameterMetaData meta = cs.getParameterMetaData() ; // 获取 参数元数据
 System.out.println( "参数个数: " + meta.getParameterCount() ) ; // 获取 参数个数
 System.out.println( "第⼀个参数数据库类型: " + meta.getParameterTypeName( 1 ) ) ; // 获取第⼀个参数对应的数据库类型
 System.out.println( "第⼀个参数Java类型: " + meta.getParameterClassName( 1 ) ) ; // 获取第⼀个参数对应的的 Java 类型
 System.out.println( "第⼀个参数模式: " +meta.getParameterMode( 1 ) ) ; // 获取第⼀个参数的模式 ( 1 表⽰ parameterModeIn )
 System.out.println( "第⼆个参数模式: " +meta.getParameterMode( 2 ) ) ; // 获取数据库元数据 ( 4 表⽰ parameterModeOut )
cs.setInt( 1 , 1 ) ; // 设置第⼀个参数的参数值
cs.setString( 2 , null ) ; // 设置第⼆个参数的参数值 ( 因为第⼆个参数是传出参数，因此可以不传数据 )
boolean executeResult = cs.execute() ;
if( executeResult ) { // true 表⽰执⾏后返回的第⼀个结果是结果集
 ResultSet rs = cs.getResultSet(); 
 System.out.println( rs ); 
 } else { 
 System.out.println( cs.getString( 2 ) ); // 若未返回结果集，则可以⽤ get ⽅法获取传出参数的返回值 ( 类型与传出参数类型⼀致 )
 }
```

# SQLException

**SQLException 可以获取的信息：**

​				描述错误的字符串，通过 SQLException 的 getMessage() ⽅法获得

​				底层数据库返回的实际错误代码，通过 getErrorCode() ⽅法获得

​				SQLState 代码，通过 SQLException 的 getSQLState() ⽅法获得

​				导致当前异常的原因，通过 SQLException 的 getCause() ⽅法获得

​				到下⼀个Exception的链接，通过 getNextException() ⽅法获得

**JDBC API 中⼏乎所有的⽅法都会抛出 SQLException**



## SQLException的分类

**SQLException**

用来处理较为严重的异常情况

常⻅的触发SQLException的情况如: 

传输的 SQL 语句语法的错误

JDBC 程序连接断开

SQL 语句中使⽤了错误的函数



**SQLWarning**

用来处理不太严重的异常情况

对应⾮致命错误或意想不到的条件

它较为罕⻅，通常可以忽略

最常⻅的是DataTruncation警告，

它表示在从数据库读或写数据时存在问题

## SQLException 的子类

​		**SQLTransientException** ：没有任何应⽤程序级功能⼲预时，重试先前失败操作可以成功的情况下抛出的 SQLException ⼦类

​		**SQLNonTransientException：**重试相同操作将失败（除⾮纠正了 SQLException 的 cause）的情况下抛出的 SQLException ⼦类

​		**SQLRecoverableException：**应⽤程序执⾏某些恢复步骤并重试整个事务或事务分⽀（在分布式事务中）后，可以成功执⾏先前失败操作的情况下抛出的 SQLException ⼦类。恢复操作⾄少必须包括关闭当前连接和获得⼀个新连接

​		**BatchUpdateException：**进⾏批量更新操作期间发⽣错误时抛出的 SQLException ⼦类。除了 SQLException 提供的信息以外，BatchUpdateException 还提供批量更新期间成功执⾏的所有命令的更新计数，也就是发⽣错误之前执⾏的所有命令的更新计数。更新计数数组中元素的顺序对应于将命令添加到批处理中的顺序

​		**SQLClientInfoException：**当⽆法在 Connection 上设置⼀个或多个客户端信息属性时，抛出此 SQLException 的⼦类。除了 SQLException 提供的信息外，SQLClientInfoException 还提供未设置的客户端信息属性列表

# 事务控制

**Connection 接口中定义了 五个 表示事务隔离级别的常量:**

```java
 public static final int TRANSACTION_NONE = 0 ;
 public static final int TRANSACTION_READ_UNCOMMITTED = 1 ; // 0001 
 public static final int TRANSACTION_READ_COMMITTED = 2 ; // 0010
 public static final int TRANSACTION_REPEATABLE_READ = 4 ; // 0100
 public static final int TRANSACTION_SERIALIZABLE = 8 ; // 1000
//使用connection接口中的getTransactionIsolation方法去获取其隔离级别
int isolationLevel = connection.getTransactionIsolation() ;
//查看自动提交是否打开
boolean autocommit = connection.getAutoCommit() ;
connection.setAutoCommit( false );
// 设置隔离级别 ( 建议 参数 使用 Connection 接口中定义的常量 )
connection.setTransactionIsolation( Connection.TRANSACTION_SERIALIZABLE );
```

**使用connection接口中的getTransactionIsolation方法去获取其隔离级别**

**使用connection接口中的setTransactionIsolation方法去获取其隔离级别**

**setAutoCommit 用来设置提交模式: true 表示自动提交，false 表示手动提交**

```java
/**
 * JDBC 处理事务的步骤:
 * 1、关闭自动提交 : connection.setAutoCommit( false );
 *    设置事务隔离级别: connection.setTransactionIsolation( level ) ;
 *    注意: 在 Oracle 环境下设置事务隔离级别必须是事务开始时
 * 2、提交或回滚事务:
 *    2.1、提交事务: connection.commit();
 *    2.2、回滚事务: connection.rollabck();
 * 3、启用自动提交: connection.setAutoCommit( true );
 */

		String driverClassName = "oracle.jdbc.driver.OracleDriver"  ;
		String url = "jdbc:oracle:thin:@localhost:1521:ecut" ;
		String user = "ecuter" ;
		String password = "ecuter" ;
		// 1、加载数据库驱动
		Class.forName( driverClassName );
		// 2、获得数据库连接
		Connection connection = DriverManager.getConnection( url , user , password );
		// 设置事务的隔离级别 ( 在 Oracle 环境下设置事务隔离级别必须是事务开始时 )
		connection.setTransactionIsolation( Connection.TRANSACTION_READ_COMMITTED ); // 设置隔离级别
		// 【事务处理第一步】关闭自动提交
		connection.setAutoCommit( false ); 
		// 3、创建 Statement 对象
		Statement statement = connection.createStatement();
		try {
			// 4、执行 DML语句
			int count = statement.executeUpdate( "" ); // SQLException
			// 5、处理结果
			System.out.println( count );
			// 【事务处理第二步】提交事务 (与提交事务是互斥操作)
			connection.commit(); // SQLException
		} catch ( SQLException e ) {
			// 【事务处理第二步】回滚事务 (与提交事务是互斥操作)
			connection.rollback();
		}
		
		// 【事务处理第三步】启用自动提交
		connection.setAutoCommit( true );
		
		// 6、释放资源( 所有已经开启的资源必须都关闭 )
		statement.close();
		connection.close();

	}
```

 **对于同一个 connection 来说，如果一个事务提交了，则意味着有一个新的事务随即开始了**

# JDBC新特性

## ResultSet Type

**public static final int** **TYPE_FORWARD_ONLY** = 1003 ： 该常量指示光标只能向前移动的 ResultSet 对象的类型

**public static final int** **TYPE_SCROLL_INSENSITIVE** = 1004 ：该常量指示可滚动但通常不受 ResultSet 底层数据更改影响的 ResultSet 对象的类型

**public static final int** **TYPE_SCROLL_SENSITIVE** = 1005：该常量指示可滚动并且通常受 ResultSet 底层数据更改影响的 ResultSet 对象的类型

**public static final int** **CONCUR_READ_ONLY** = 1007 ：该常量指示不可以更新的 ResultSet 对象的并发模式

**public static final int** **CONCUR_UPDATABLE** = 1008：该常量指示可以更新的 ResultSet 对象的并发模式

**public static final int** **HOLD_CURSORS_OVER_COMMIT** = 1：该常量指示提交当前事务时，具有此可保存性的打开的 ResultSet 对象将保持开放

**public static final int** **CLOSE_CURSORS_AT_COMMIT** = 2：该常量指示提交当前事务时，具有此可保存性的打开的 ResultSet 对象将被关闭

```java
final int type = ResultSet.TYPE_SCROLL_INSENSITIVE ; // 指定结果集为可滚动类型
final int concurrency = ResultSet.CONCUR_READ_ONLY ; // 指定并发类型为只读类型
boolean support = metadata.supportsResultSetConcurrency( type , concurrency ) ; // 判断是否支持可滚动的、只读的结果集
statement = connection.createStatement( type , concurrency ) ; // 创建 Statement 对象时指定 结果集类型 和 并发类型
```

​		**与 结果集的 可滚动性 、并发类性 、可保持性 有关的常量被定义在 ResultSet 接⼝中** 

​		**其中 结果集的可保持特性是 JDBC 3.0 中才开始提供的 ( 随 JDK 1.4 ⼀起发布 )**

```java
// 通过数据库连接获得数据库元数据
 DatabaseMetaData meta = connection.getMetaData(); 
// 判断当前驱动程序是否⽀持给定结果集类型 ( 可滚动性 )
boolean t = meta.supportsResultSetType( ResultSet.TYPE_SCROLL_INSENSITIVE ) ; 
 System.out.println( t ); 
// 判断当前驱动程序是否⽀持 与给定结果集类型结合在⼀起的给定并发性类型 ( 并发类型必须与结果集类型配合在⼀起使⽤ )
boolean c = meta.supportsResultSetConcurrency( ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE ) ; 
 System.out.println( c ); 
// 判断当前驱动程序是否⽀持给定的结果集可保存性
boolean h = meta.supportsResultSetHoldability( ResultSet.HOLD_CURSORS_OVER_COMMIT ) ; 
 System.out.println( h );
```

**使⽤ DatabaseMetaData 类中定义的⽅法，可以判断 当前驱动程序 是否⽀持结果集的某种特性**

### Scrollable ResultSets

**可滚动的结果集⽀持 相对定位 、绝对定位 、双向滚动 等操作 ( 相应的⽅法被定义在 ResultSet 接⼝中 )**

**public boolean** **absolute( int row )** : 绝对定位，将光标移动到此 ResultSet 对象的指定⾏( 参数 row 表示⾏编号 )，定位成功返回 true

**public void beforeFirst()** : 绝对定位，将光标移动到此 ResultSet 对象的开头，正好位于第⼀⾏之前 ( 当结果集中不包含任何⾏时此⽅法⽆效 )

**public void** afterLast() : 绝对定位，将光标移动到此 ResultSet 对象的末尾，正好位于最后⼀⾏之后 ( 当结果集中不包含任何⾏时此⽅法⽆效 )

**public boolean** first() : 相对定位，将光标移动到此 ResultSet 对象的第⼀⾏ ( 光标位于有效⾏，则返回 true ，否则返回 false )

**public boolean** last() : 相对定位，将光标移动到此 ResultSet 对象的最后⼀⾏ ( 光标位于有效⾏，则返回 true ，否则返回 false )

**public boolean** previous() : 相对定位，将光标从当前位置向上移⼀⾏ ( 光标位于有效⾏，则返回 true ，否则返回 false )

 **public boolean** next() : 相对定位，将光标从当前位置向下移⼀⾏ ( 光标位于有效⾏，则返回 true ，否则返回 false )

**public boolean** relative( **int** rows ) : 相对定位，按相对⾏数（或正或负）移动光标到指定⾏ ( 光标位于有效⾏，则返回 true ，否则返回 false )



**使⽤绝对定位⽅法 ( afterLast() ) 将光标移动到最后⼀⾏数据之后，再从后向前遍历结果集**

```java
 Statement statement = null ; 
 DatabaseMetaData metadata = connection.getMetaData(); 
final int type = ResultSet.TYPE_SCROLL_INSENSITIVE ; // 指定结果集为可滚动类型
final int concurrency = ResultSet.CONCUR_READ_ONLY ; // 指定并发类型为只读类型
boolean support = metadata.supportsResultSetConcurrency( type , concurrency ) ; // 判断是否支持可滚动的、只读的结果集
if( support ) { // 如果支持只读的、可滚动的结果集
	 statement = connection.createStatement( type , concurrency ) ; // 创建 Statement 对象时指定 结果集类型 和 并发类型
 	 String SQL = "SELECT id , name , gender FROM t_users" ; 
 	 ResultSet rs = statement.executeQuery( SQL ); // 执行查询操作
	 rs.afterLast() ; // 将光标移动到最后一行之后
	 while( rs.previous() ){ // 将光标移动到当前位置的上一行
 		System.out.println( rs.getInt( 1 ) + " , " + rs.getString( 2 ) + " , " + rs.getString( 3 ) ); 
 	} 
 }
```

### Updatable Result Sets

**获取可更新的结果集，并更新其中的数据，此更新操作将同步到数据库**

```java
DatabaseMetaData metadata = connection.getMetaData(); 
final int type = ResultSet.TYPE_SCROLL_INSENSITIVE ; // 指定结果集为可滚动类型
final int concurrency = ResultSet.CONCUR_UPDATABLE ; // 指定并发类型为可更新的
boolean support = metadata.supportsResultSetConcurrency( type , concurrency ) ; // 判断是否支持可滚动的、可更新的结果集
if( support ) { // 如果支持只读的、可滚动的结果集
	 statement = connection.createStatement( type , concurrency ) ; // 创建 Statement 对象时指定 结果集类型 和 并发类型
	 String SQL = "SELECT id , name , gender FROM t_users" ; 
	 ResultSet rs = statement.executeQuery( SQL ) ; // 执行查询操作
	 boolean locate = rs.absolute( 2 ) ; // 将光标定位到结果集的第 2 行记录
	 if( locate ) { // 如果定位成功
 		 rs.updateString( "name" , "张翠⼭" ) ; // 更新 名称是 name 的列
		 rs.updateRow() ; // 用此 ResultSet 对象的当前行的新内容更新底层数据库
		 rs.beforeFirst() ; // 将光标定位到结果集第一行之前 
		 // 重新遍历结果集，即可验证修改结果
 		while( rs.next() ){ 
 			System.out.println( rs.getInt( 1 ) + " , " + rs.getString( 2 ) + " , " + rs.getString( 3 ) ); 
		 } 
 	} 
 }
```

**public void** updateByte( **int** index , **byte** value ) : ⽤ byte 值更新指定列

**public void** updateShort( **int** index , **short** value ) : ⽤ short 值更新指定列

**public void** updateInt( **int** index , **int** value ) : ⽤ int 值更新指定列

**public void** updateLong( **int** index , **long** value ) : ⽤ long 值更新指定列

**public void** updateFloat( **int** index , **float** value ) : ⽤ float 值更新指定列

**public void** updateDouble( **int** index , **double** value ) : ⽤ double 值更新指定列

**public void** updateBoolean( **int** index , **boolean** value ) : ⽤ boolean 值更新指定列

**public void** updateBigDecimal( **int** index , BigDecimal value ) : ⽤ java.math.BigDecimal 值更新指定列



理论上讲，updateObject 可以修改任意类型的数据，但实际上必须考虑具体的类型(受驱动影响) 

因此，如果使⽤ updateObject ⽅法，最好明确数据类型，否则可能触发与数据类型有关的异常 

带有 SQLType 参数的 updateObject ⽅法是 JDBC 4.2 中新定义的⽅法 ( 随 JDK 1.8 发布 )

## 插入新的记录

**对于可更新的结果集，可以在结果集中添加新记录，同时新添加的记录将同步到数据库**

```java
Statement statement = null; 
statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE ) ; 
 String SQL = "SELECT id , name , gender FROM t_users"; 
 ResultSet rs = statement.executeQuery( SQL ) ; 
while ( rs.next() ) { 
 System.out.println( rs.getInt(1) + " , " + rs.getString(2) + " , " + rs.getString(3) ); 
 } 
rs.moveToInsertRow() ; 
rs.updateString( "name", "周伯通" ) ; 
rs.updateString( "gender", "男" ) ; 
rs.insertRow(); 
rs.beforeFirst(); 
while ( rs.next() ) { 
 System.out.println( rs.getInt(1) + " , " + rs.getString(2) + " , " + rs.getString(3) ); 
 }
```


