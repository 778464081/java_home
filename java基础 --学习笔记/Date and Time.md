# Date

## 类 Date 表示特定的 瞬间 ，精确到毫秒 

通过 自己的 Date 类理解 java.util.Date 类的内部设计

```java
public class MyDate {
	
	private transient long fastTime ; // 用来存储毫秒值
	
	public MyDate() {
		this( System.currentTimeMillis() ); // 调用另外一个构造方法
	}

	public MyDate( long date ) {
		super();
		fastTime = date ;
	}
	
	public void setTime(long time) {
        fastTime = time;
    }
	
	public long getTime() {
        return this.fastTime ;
    }

}
```

Date 类的实例内部封装了一个 毫秒值 ( 从 历元 至 某一瞬间 所经历的 毫秒值 )

历元( Epoch ) : 1970 年 1 月 1 日 00:00:00 GMT ( GMT : 格林尼治标准时间 )



```java
// 使用 Date 类的 无参构造 创建 Date 实例
		Date now = new Date(); 
		System.out.println( now );
```

```java
long millis = System.currentTimeMillis() ; // 获取 从 历元 至 现在所经历的 毫秒数 ( 毫秒值 )
		System.out.println( millis );
		// 使用 Date 类带有一个 long 类型参数的构造 创建 Date 实例
		Date date = new Date( millis ); 
		System.out.println( date ); // date.toString()
```

## Date中的方法

比较两个 Date 实例是否相等: **public boolean equals( Object o )**

判断 当前Date实例 所表示瞬间 是否 早于 另一个Date实例所表示的瞬间: **boolean before( Date when )**

判断 当前Date实例 所表示瞬间 是否 晚于 另一个Date实例所表示的瞬间: **boolean after( Date when )**

# Calender

##  1、java.util.Calendar 类是个抽象类

​	java.util.GregorianCalendar 类是 Calendar 的子类

### **Calendar 为特定瞬间与一组日历字段之间的转换提供了一些方法，并为操作日历字段提供了一些方法**

 日历字段 ( calendar field ) 就是表示 特定瞬间 中某个部分的 字段 ，比如:

Calendar.YEAR 表示年 、

Calendar.MONTH 表示月、

Calendar.DATE 表示天 、

Calendar.HOUR 表示小时 ( 12 小时进制 ，分上午和下午 ) 、

Calendar.HOUR_OF_DAY 表示小时 ( 24 小时进制 ) 、

Calendar.MINUTE 表示分钟 、

Calendar.SECOND 表示秒 、

Calendar.MILLISECOND 表示毫秒

**通过 Calendar 实例 调用 get( int) 方法可以获得指定 日历字段 的值**

```java
		// 父类类型的 引用变量 指向了 子类类型的对象
		Calendar calendar = new GregorianCalendar(); // 默认地区 、默认时区
```

### 通过 静态工厂方法 来获取 Calendar 类的实例

### ( 这里的 静态工厂方法 就是 Calendar 类中的 返回 Calendar实例 的 类方法 )

```java
// 父类类型的 引用变量 指向了 子类类型的对象
		Calendar calendar = Calendar.getInstance(); // 默认地区 、 默认时区

	//赋值方法：set()
	/*
		calendar.set( Calendar.YEAR ,  1999 );
		calendar.set( Calendar.MONTH , 5 ); // 注意: 鬼子那边月份从零开始计数
		calendar.set( 1999 , 5 , 10, 7, 50 , 0 );
	*/
```

# Date 与Calendar的转换 

```java
	

	//Calendar 转换成Date

	// 1、获得一个 Calendar 实例
		final Calendar calendar = Calendar.getInstance(); // 默认地区、默认时区
	// 2、清空 Calendar 实例的所有 日历字段值 和 时间值
		calendar.clear(); // 将 当前Calendar实例 的所日历字段值和时间值（从历元至现在的毫秒偏移量）设置成未定义
	// 3、根据实际需要设置 年、月、日、时、分、秒 、毫秒
		calendar.set( 1999 , 9 , 10 , 16, 30, 40 ); // 注意月份从零开始计数
		calendar.set( Calendar.MILLISECOND , 123 );// 如有必要可以单独设置毫秒
		// 4、通过 Calendar 实例来获得 Date 对象
		Date date = calendar.getTime(); // 通过 Calendar实例 获得该实例所表示瞬间对应的 Date 对象	


	// Date 转换 Calendar
		Date date1 =new Date();
		Calendar calendar1 =Calendar.getInstance();
		calendar1.setTime(date1);
		
```

**其中getTime（）与setTime（） 的源码如下：**

```java
public final Date getTime() {
        return new Date(getTimeInMillis());
    }
```

```java
public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
    }
```

#  地区：Locale  时区：TimeZone

**获得 Calendar 实例时需要综合考虑 地区 和 时区 的影响**

```java
		// 获得 默认的地区 ( 用一个 Locale 对象表示 )
		Locale defaultLocale = Locale.getDefault(); // 类方法

		Locale first = new Locale( "zh" , "CN" );
		System.out.println( first );

		// 获得 默认的时区 ( 用一个 TimeZone 对象表示 )
		TimeZone defaultTimeZone = TimeZone.getDefault() ; // 类方法

		String id = "Asia/Chongqing" ;
		TimeZone tz = TimeZone.getTimeZone( id );

		Calendar calendar = Calendar.getInstance( tz , first );
```

```java
		String id = "Asia/Chongqing" ;
		TimeZone tz = TimeZone.getTimeZone( id );
		//查看各个时区	
		String[] ids = TimeZone.getAvailableIDs();
		for( int i = 0 ; i < ids.length ; i++ ) {
			System.out.println( ids[ i ] );
		}
```

# DateFormat

**DateFormat 提供的 静态工厂方法 可以获得 DateFormat 实例，但是通常不会这样用**

 \*    DateFormat.getInstance()

 \*    DateFormat.getDateInstance()

 \*    DateFormat.getTimeInstance()

**通过 DateFormat 实例的 format 方法可以将一个 Date实例 格式化为 特定模式 的字符串**

```java
		final Calendar c = Calendar.getInstance();
		c.clear();
		c.set( 1999 , 9, 30, 19, 30 , 50 );
		
		final Date d = c.getTime();
		System.out.println( d );
		//Sat Oct 30 19:30:50 CST 1999
		DateFormat df = DateFormat.getInstance(); // 获取默认语言环境的默认格式化风格
		
		// 将 Date实例 所表示的瞬间 用 特定格式 的 字符串 来表示
		String s = df.format( d ) ; // 将 Date实例 格式化 为特定的字符串 形式
		System.out.println( s );
		//1999/10/30 下午7:30
		df = DateFormat.getDateInstance(); // 仅处理日期
		System.out.println( df.format( d ) );
		//1999年10月30日
		df = DateFormat.getTimeInstance(); // 仅处理时间
		System.out.println( df.format( d ) );
		//下午7:30:50
```

## SimpleDateFormat

1、通过创建 SimpleDateFormat 类的实例来完成 日期格式化操作

2、在创建 SimpleDateFormat 对象时，一定要注意 日期模式

```java
		final Calendar c = Calendar.getInstance();
		c.clear();
		c.set( 1999 , 9, 30, 19, 30 , 50 );
		
		final Date d = c.getTime();
		System.out.println( d );
		//Sat Oct 30 19:30:50 CST 1999
		final String pattern = "Gyyyy年MM月dd日 EEEE HH:mm:ss.SSS" ;
		// 父类类型的引用 变量 指向了 子类类型的对象
		DateFormat df = new SimpleDateFormat( pattern );
		
		String s = df.format( d ); // 将 Date实例 格式化为 特定模式 的 字符串
		System.out.println( s );
		//公元1999年10月30日 星期六 19:30:50.000
```

 **通过 SimpleDateFormat实例 来完成 将符合 特定模式 的 字符串 解析为 Date实例**

```java
		String source = "公元2044年10月30日 星期日 19:30:50.000" ;
		
		final String pattern = "Gyyyy年MM月dd日 EEEE HH:mm:ss.SSS" ;
		// 父类类型的引用 变量 指向了 子类类型的对象
		DateFormat df = new SimpleDateFormat( pattern );
		
		Date d = df.parse( source ); // 可能触发 ParseException 异常
		System.out.println( d );
		//Sun Oct 30 19:30:50 CST 2044
```

# LocalDate

1、了解 LocalDate 中的常量: MIN / MAX / EPOCH

```java
		System.out.println( LocalDate.MIN ); //-999999999-01-01
		System.out.println( LocalDate.EPOCH ); // 历元//1970-01-01
		System.out.println( LocalDate.MAX ); //+999999999-12-31
```

 2、熟练使用 LocalDate 类中的 静态工厂方法 : now() / of( int , int , int ) / ofYearDay( int , int )

```java
		LocalDate today = LocalDate.now(); // 获得当前日期
		System.out.println( today );2020-06-02
		
		LocalDate birthdate1 = LocalDate.of( 1999 ,  5 , 10 ); // 注意这里的月份从一开始
		System.out.println( birthdate1 );//1999-05-10

		System.out.println( today.plusDays( 15 ) ); // 增加 N 天
		System.out.println( today.plusWeeks( 3 ) ); // 增加 N 周
		System.out.println( today.plusMonths( -5 ) );
		System.out.println( today.plusYears( -10 ) );

		LocalDate date = LocalDate.ofYearDay( 2020 , 200 ); // 获取 指定年份 的 第 N 天对应的 日期
		//2020-07-18
		System.out.println( date );
		System.out.println( date.isLeapYear() ); // 判断 指定日期 所在年份是否是闰年
		System.out.println( date.lengthOfMonth() ); // 获取 当前日期 所在月份的总天数
		System.out.println( date.lengthOfYear() ); // 获取 当前日期 所在年份的总天数

```

 3、理解 LocalDate 内部设计: 

 \*     LocalDate 类是 final 修饰的 、

 \*     LocalDate 类的构造方法都是私有的、

 \*     LocalDate 类中表示 年、月、日的 实例变量全部都是 私有 且 不可更改的:

​	 \*      private final int year ;

​	 \*      private final short month ;

​	 \*      private final short date ;

4、LocalDate 类是一个最终类，同时 LocalDate 类的实例 也是不可变的

# LocalTime

**java.time.LocalTime 表示某一天当中的时间**

通过 LocalTime 类的 类方法 来获取 LocalTime 实例: now() / now(ZoneId) / of( int , int ) / of( int , int , int ) / of ( int , int , int , int)

```java
		LocalTime now = LocalTime.now(); // 根据默认时区获取当地的当前时间
		System.out.println( now );
		ZoneId zone = ZoneId.of( "US/Alaska" );
		now = LocalTime.now( zone ); // 根据 指定时区 获取该地当前时间
		System.out.println( now );
		
	 	LocalTime third = LocalTime.of( 22 , 44 ,  55 , 100200300 ); // 时、分、秒、纳秒
```

```java
 		 System.out.println( LocalTime.MIN );//00:00
		 System.out.println( LocalTime.MAX );//23:59:59.999999999
		 System.out.println( LocalTime.MIDNIGHT );//00:00
		 System.out.println( LocalTime.NOON );//12:00
```

# LocalDateTime

**java.time.LocalDateTime 表示 日期时间，其中既有日期又有时间** 

LocalDateTime类中的类方法: now() / now(ZoneId) / of( ... )

```java
		System.out.println(LocalDateTime.MIN);//-999999999-01-01T00:00
		System.out.println(LocalDateTime.MAX);//+999999999-12-31T23:59:59.999999999
```

```java
		LocalDateTime now = null;

		// 使用操作系统使用默认时区获得 LocalDateTime 实例
		now = LocalDateTime.now();
		System.out.println(now); // now.toString()

		// 根据 指定时区 获取该时区对应的 日期时间
		now = LocalDateTime.now(ZoneId.of("US/Alaska"));
		System.out.println(now);
```

```java
		LocalDate date = LocalDate.of(1998, 6, 10);
		LocalTime time = LocalTime.of(14, 20, 30, 111222333);

		LocalDateTime first = LocalDateTime.of(date, time);
		System.out.println(first);//1998-06-10T14:20:30.111222333

		LocalDateTime second = LocalDateTime.of(1999, 7, 8, 5, 30);
		System.out.println(second);//1999-07-08T05:30
		LocalDateTime third = LocalDateTime.of(1999, 7, 8, 5, 30, 40);
		System.out.println(third);//1999-07-08T05:30:40
		
```

# ZoneId

1、了解 java.time.ZoneId 表示 时区

2、ZoneId.systemDefault() 获取当前操作系统使用的时区

```java
// 使用 ZoneId 类中的 systemDefault 方法获取当前操作系统使用的时区
		ZoneId zid = ZoneId.systemDefault() ;
```

3、ZoneId.getAvailableZoneIds() 获得当前JVM所支持的所有的 时区编号

```java
// 获得当前JVM所支持的所有 时区编号( zoneId )
		Set<String>  set = ZoneId.getAvailableZoneIds();		
		Object[] array = set.toArray(); // 将 Set 集合转换为 数组
		for( int i = 0 , n = array.length ; i < n ; i ++ ) {
			String id = (String)array[ i ] ;
			ZoneId zoneId = ZoneId.of( id );
			System.out.println( id + " : " + zoneId.getDisplayName( TextStyle.FULL , defaultLocale ) );
		}

```

4、ZoneId.of( String zoneId ) 根据 指定的 时区编号 获得相应的 ZoneId实例

```java

		// 根据指定的 时区编号( zoneId ) 来获取 相应的 ZoneId实例
		ZoneId zone = ZoneId.of( "US/Alaska" );
```

5、对于 LocalDate 来说，时区不同，所表示的 日期也可能不同





# 各类互相转换

## LocalDateTime <===> LocalDate

### LocalDateTime ==>LoaclDate

```java
		LocalDateTime now = LocalDateTime.now(); // 默认时区
		System.out.println( now );
		//2020-06-02T21:02:45.790006900
		// LocalDateTime ===>  LocalDate
		LocalDate date = now.toLocalDate();
		System.out.println( date );
		//2020-06-02
```

### LocalDateTime <==LoaclDate

```java

		LocalDate date = LocalDate.ofYearDay( 1999 ,  200 );
		System.out.println( date );	//1999-07-19
		// 获得 date 所表示日期的 00:00:00.000000000 对应的 LocalDateTime实例
		LocalDateTime first = date.atStartOfDay(); 
		System.out.println( first );
		//1999-07-19T00:00
		LocalDateTime second = date.atTime( 5 , 30 );
		System.out.println( second );
		//1999-07-19T05:30
		LocalDateTime thrid = date.atTime( 5 , 30 , 40 );
		System.out.println( thrid );
		//1999-07-19T05:30:40
		LocalDateTime fourth = date.atTime( 5 , 30 , 40 , 100200300 );
		System.out.println( fourth );
		//1999-07-19T05:30:40.100200300
		LocalTime time = LocalTime.of( 17 ,  20 , 30, 400500600 );
		LocalDateTime fifth = date.atTime( time );
		System.out.println( fifth );
		//1999-07-19T17:20:30.400500600
```

##  LocalDateTime <===> LocalTime

### LocalDateTime ===> LocalTime

```java
		LocalDateTime now = LocalDateTime.now(); // 默认时区
		System.out.println( now );
		
		// LocalDateTime ===>  LocalTime
		LocalTime time = now.toLocalTime();
		System.out.println( time );
		//21:02:45.790006900
```

### LocalDateTime <=== LocalTime

```java
		LocalTime time = LocalTime.of( 16 ,  50 , 30, 400500600 );
		System.out.println( time );
		//16:50:30.400500600
		LocalDate date = LocalDate.now(); // 默认时区
		LocalDateTime first = time.atDate( date );
		System.out.println( first );
		//2020-06-02T16:50:30.400500600
```

## Date <==>DateTime

1、java.util.Date ===> java.time.LocalDateTime

​	 \*     java.util.Date ---> java.time.Instant ---> java.time.ZonedDateTime ---> java.time.LocalDateTime

​				Date实例.toInstant()， instant实例.atZone( zone )，ZonedDateTime实例.toLocalDateTime() ;

2、java.util.Date ===> java.time.LocalDate

​	 \*     java.util.Date ---> java.time.Instant ---> java.time.ZonedDateTime ---> java.time.LocalDate

3、java.util.Date ===> java.time.LocalTime

​	 \*     java.util.Date ---> java.time.Instant ---> java.time.ZonedDateTime ---> java.time.LocalTime



```java
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set( 1999 ,  9 ,  10 ,  20 ,  30 ,  40 );
		final Date utilDate = c.getTime();
		System.out.println( utilDate );
		// 根据 java.util.Date 实例 获得 与之对应的 java.time.Instant 实例
		Instant instant = utilDate.toInstant(); 
		System.out.println( instant );
		ZoneId zone = ZoneId.systemDefault();
		// 根据 Instant 实例获得 带有时区的 日期时间对象 ( ZonedDateTime实例 )
		ZonedDateTime zdt = instant.atZone( zone );
		System.out.println( zdt );
		
		// ZonedDateTime ===> LocalDateTime
		LocalDateTime datetime = zdt.toLocalDateTime() ;
		System.out.println( datetime );
		
		// ZonedDateTime ===> LocalDate
		LocalDate date = zdt.toLocalDate() ;
		System.out.println( date );
		
		// ZonedDateTime ===> LocalTime
		LocalTime time = zdt.toLocalTime() ;
		System.out.println( time );

```

java.time.LocalDateTime ===> java.util.Date

 	\*  java.time.LocalDateTime ---> java.time.ZonedDateTime ---> java.time.Instant ---> java.util.Date

​					ZonedDateTime.of( datetime , zone )  ，Instant.from( zonedDateTime ) ，Date.from( instant ) ;

```java
	
		LocalDate date = LocalDate.of( 1949 , 10 , 1 );
		LocalTime time = LocalTime.of( 10 , 0 );
		LocalDateTime datetime = LocalDateTime.of( date , time );
		System.out.println( datetime );
		
		ZoneId zone = ZoneId.systemDefault() ;
		
		// ZonedDateTime zonedDateTime = ZonedDateTime.of( date , time , zone );
		ZonedDateTime zonedDateTime = ZonedDateTime.of( datetime , zone );
		
		// ZonedDateTime 类 实现了 TemporalAccessor 接口
		Instant instant = Instant.from( zonedDateTime ) ;
		
		// 将一个 java.time.Instant 实例 转换为 java.util.Date 实例
		Date utilDate = Date.from( instant ) ;
		System.out.println( utilDate );
```

1、java.sql.Date 类 和 java.sql.Time 类 都是 java.util.Date 类的子类

2、使用 java.util.Date 类型的引用变量 可以 指向 java.sql.Date 类型的实例 或 指向java.sql.Time 类型的实例

3、因此:

​		 \*   将 java.time.LocalDate 快速转换为 java.util.Date 的方法就是 java.sql.Date.valueOf( java.time.LocalDate ) ，

​		 \*   将 java.time.LocalTime 快速转换为 java.util.Time 的方法就是 java.sql.Time.valueOf( java.time.LocalTime ) ，

​		 \*    但是他们的确是不完美的。

```java
		long millis = 1000L * 60 * 60 * 24 * 365 * 50 ;
// java.sql.Date 类 是 java.util.Date 类的子类，用来表示日期
		java.sql.Date date = new java.sql.Date( millis );
		System.out.println( date ); 
// 直接将 java.sql.Date 实例转换为 java.time.LocalDate 实例
		java.time.LocalDate localDate = date.toLocalDate(); 
		System.out.println( localDate );
		long ms = 1000L * 60 * 60 * 15 ;
		// java.sql.Time 类 是 java.util.Date 类的子类，用来表示日期
		java.sql.Time time = new java.sql.Time( ms );


		LocalTime localTime = time.toLocalTime();

```





























