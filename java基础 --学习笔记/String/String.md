#  String

## String JVM中的存储结构

<img src="C:\Users\ASUS.DESKTOP-9718HKU\Desktop\java学习笔记\String\理解String存储.png" style="zoom: 200%;" />

### 通过String 类型 理解 == 运算符 和 equals方法分别在比较什么

  

```java
String s = "中国是世界上最伟大的国家，没有之一" ;
String x = "中国是世界上最伟大的国家，没有之一" ;
// 使用 == 运算符 比较两个变量时，一定是比较两个变量的值
System.out.println( s == x ); // true : 说明 变量 s 和 变量 x 存储的值是相同的
System.out.println( s.equals( x ) ); // true : String 类重写后的 equals 会比较两个字符串的内容
System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
String t = new String( "中国是世界上最伟大的国家，没有之一" );
System.out.println( s == t ); // false : 说明 变量 s 和 变量 t 存储的值是不同的
System.out.println( s.equals( t ) ); // true : String 类重写后的 equals 会比较两个字符串的内容
```

**其中** 

【 Java 8 及之前 】

  public final class String {

​	  private final char[] value ; // 使用 char 数组保存字符序列

  }

  【 Java 9 及以后 】**(byte[] 数组效果如上图)**

 public final class String {

​      private final byte[] value ; // 使用 byte 数组保存字节序列 ( 字节序列是字符序列根据某种编码转换而来 )

  }

**字符串常量池 与堆内存**

```java
		// 变量 s 直接引用了 存放在 字符串常量 池 中的 String 实例
		String s = "中国是世界上最伟大的国家，没有之一" ;
		// 变量 t 引用的是 在 堆内存中重新创建的 String 实例
		String t = new String( "中国是世界上最伟大的国家，没有之一" );

		String s = "abc123" ;
		s.hashCode() ; // 首次调用 hashCode 方法会将 相应 字符串 的 哈希码值 缓存在 实例变量 hash 中
```

### 将 基本数据类型的值 转换为 字符串形式 : 

1、valueOf( boolean | char | int | long | float | double )

2、public static String valueOf( char[] data )

3、public static String valueOf( char[] data , int offset , int count )

4、public static String valueOf( Object o )

```java
		boolean z = true ;
		String s = String.valueOf( z );
		char[] chars = { '春' , '眠' , '晓' , '处' , '处' , '闻' , '啼' , '鸟' };
		String x = String.valueOf( chars );
		System.out.println( x );
		String t = String.valueOf( chars , 7 , 3 ) ; // 如果超出范围会抛出 StringIndexOutOfBoundsException
		System.out.println( t );//闻啼鸟
		
		Object o = Integer.valueOf( 9527 );
		String u = String.valueOf( o ) ;
		System.out.println( u );//9527
```

### String.format与join

**public static String format( String format , Object... args )**

```java
 		 int one = 123456789;
		 double two = 123456.789;
		 String s = String.format( "第一个参数：%,d 第二个参数：%,.2f", one , two );
		 System.out.println(s);
		//第一个参数：123,456,789 第二个参数：123,456.79
```

**public static String join( CharSequence delimiter , CharSequence... elements ) 【 JDK 1.8 开始提供 】**

```java
		 // JDK 1.8 开始定义了 join 方法
		 String x = String.join( "===" , "张三丰" , "张君宝" , "觉远大师" , "杨过" , "郭襄" );
		 System.out.println( x );
		//张三丰===张君宝===觉远大师===杨过===郭襄

		 // 注意 split 是个实例方法，一定要通过 String 实例来调用
		 String[] array = x.split( "===" ) ; // 将一个 String 实例中的 字符串 按照指定的 表达式 拆分成 String 数组
		 for( int i = 0 ; i < array.length ; i++ ) {
			 System.out.println( array[ i ] );
		 }
		//	张三丰
		//	张君宝
		//  觉远大师
		//	杨过
		//	郭襄
```

### 获取指定字符串对应的字节序列：getByte[]

```java
		byte[] bytes = { 97 , 98 , 99 , 100 , 101 , 102 , 48 , 49 , 50 , 51 , 52 , 53 };
		// 通过使用 平台的默认字符集 解码 指定的 byte 数组，构造一个新的 String 实例
		String s = new String( bytes );
		System.out.println( s );  //abcdef012345
		
		String x = new String( bytes , 0 , 6 );	//abcdef
		String t = "中国" ; 
		System.out.println( t );
		
		// 使用 平台的默认字符集 将此 String 编码 为 byte 序列，并将结果存储到一个新的 byte 数组中
		byte[] bs = t.getBytes();
		// java.util 包 中的 Arrays 类的 toString 方法可以将 数组中的元素 链接到一个字符串中
		String u = Arrays.toString( bs ); 
		System.out.println( u );//[-28, -72, -83, -27, -101, -67]
		
		String n = new String( bs );
		System.out.println( n );//中国
		
		// String m = new String( new byte[]{ -28, -72, -83, -27, -101, -67 } )  ;
		
		byte[] b = new byte[]{ -28, -72, -83, -27, -101, -67 } ;
		String m = new String( b )  ;
		System.out.println( m );  //中国
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 获得 平台的默认字符集
		Charset defaultCharset = Charset.defaultCharset() ;
		System.out.println( defaultCharset );  //UTF-8  /*指你自己编码器的使用的编码方式*/
```

## 字符集

#### 常用字符集

  GBK : 简体中文

​			全称《汉字内码扩展规范》（GBK即“国标”、“扩展”汉语拼音的第一个字母，英文名称：Chinese Internal Code Specification）

**Unicode 编码共有三种具体实现，分别为utf-8,utf-16,utf-32，其中utf-8占用一到四个字节，utf-16占用二或四个字节，utf-32占用四个字节**

  UTF-8 : 可以表示 西欧诸国字符 、东亚诸国字符 (但是不是全部)

   		8位元，Universal Character Set/Unicode Transformation Format）是针对 Unicode 的一种可变长度字符编码

ISO-8859-1 : 

​		   编码是单字节编码，向下兼容ASCII，其编码范围是0x00-0xFF，0x00-0x7F之间完全和ASCII一致，0x80-0x9F之间是控制字符，0xA0-0xFF之间是文字符号

Latin1 : 

 	   Latin1 是ISO-8859-1的别名，有些环境下写作 Latin-1

Big 5 : 繁体中文（正体中文）

##### 通过 Charset.forName( name ) 方法可以获得指定名称的字符集对应的 Charset 实例

```java
	// 如果为 Charset.forName( name ) 指定的参数 ( 一个字符编码的名称) 是不被JVM支持的，则会抛出 ava.nio.charset.UnsupportedCharsetException
		Charset first = Charset.forName( "GBK" );
		System.out.println( first + " , " + first.getClass().getName() );  // 输出 字符串形式 和 运行时类型的名称
		//输出为：GBK , sun.nio.cs.GBK
```

```java

		String s = "中国威武" ;
		
		// 使用 平台的默认字符集 将此 String 编码 为 byte 序列，并将结果存储到一个新的 byte 数组中
		byte[] defaultBytes = s.getBytes();
		System.out.println( "默认的 : " + Arrays.toString( defaultBytes ) );
		Charset first = Charset.forName( "GBK" );
		// 使用给定的 charset 实例 将此 String 编码 为 byte 序列，并将结果存储到新的 byte 数组
		byte[] firstBytes = s.getBytes( first );  // GBK
		System.out.println( first + " : " + Arrays.toString( firstBytes ) );
		//输出为：默认的 : [-28, -72, -83, -27, -101, -67, -27, -88, -127, -26, -83, -90]
		//		GBK : [-42, -48, -71, -6, -51, -2, -50, -28]
```

```java

		final String s = "中国威武" ;
		System.out.println( s); // 正常
		
		Charset first = Charset.forName( "GBK" ); // 每个汉字占两个字节
		Charset second = Charset.forName( "UTF-8" );
		
		byte[] firstBytes = s.getBytes( first ); // 使用 GBK 字符集 将 字符串 编码 为 字节序列
		System.out.println( Arrays.toString( firstBytes ) );
	
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String x = new String( firstBytes , second ); // 使用 指定的字符集 将 字节序列 解码 为 字符串
		System.out.println( x ); // 乱码
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String y = new String( firstBytes , first ); // 使用 指定的字符集 将 字节序列 解码 为 字符串
		System.out.println( y ); // 正常
```

#### 小知识

**1、在 String 实例内部封装的 byte 数组中存储 是 字符串 按照 UTF-16LE字符集 编码后的字节序列**

**2、在通过 String 实例 的 getBytes 方法获取字节序列时，可以指定 任意字符集**

**3、将一组字节序列构成为 String 实例时，必须指定 将字符串编码为字节序列时 所采用的 字符集 才能保证不乱码**

```java
		final String s = "中国威武" ;
		Charset utf = Charset.forName( "UTF-16LE" ); // 16-bit 
		byte[] bytes = s.getBytes( utf ) ; // 使用 UTF-16LE 字符集 将 字符串中的字符 编码为 字节序列
		System.out.println( Arrays.toString( bytes ) );//[45, 78, -3, 86, 1, 90, 102, 107]
		
		byte[] array = { 45, 78, -3, 86, 1, 90, 102, 107 } ;
		String x = new String( array , utf ) ; // 使用 UTF-16LE 字符集 将 字节序列 解码为 字符串中的字符
		System.out.println( x );
		
```

## String 中的方法

1、 **int length()** ： 获取字符串长度 ( 字符串中所包含的字符个数 )

2、**char charAt( int )** ：获取指定索引处的单个字符

3、**boolean contains( CharSequence )** ：判断指定的 字符序列 是否存在于 当前字符串中，若存在即返回 true 否则返回 false

4、**int indexOf()**:

​	**int indexOf( int ch )** 查询 指定字符 在 当前字符串中首次出现的位置，若存在即返回该索引，否则返回 -1 

​	**int indexOf( String s )** 查询 指定字符串 在 当前字符串中首次出现的位置，若存在即返回该索引，否则返回 -1 
​	 **int indexOf( int ch , int from )**   从 当前字符串中 指定位置(from) 开始寻找 指定字符 ( ch ) 首次出现的位置，若存在即返回该索引，否则返回 -1 

​	 **int indexOf( String s , int from )** 从 当前字符串中 指定位置(from) 开始寻找 指定字符串 ( s ) 首次出现的位置，若存在即返回该索引，否则返回 -1 

5、**int lastindexOf():**

​		**int lastIndexOf( int ch )** 查询 指定字符 在 当前字符串中最后一次出现的位置，若存在即返回该索引，否则返回 -1 

​		**int lastIndexOf( String s )** 查询 指定字符串 在 当前字符串中最后一次出现的位置，若存在即返回该索引，否则返回 -1 

​		**int lastIndexOf( int ch , int from )** 从 当前字符串中 指定位置(from) 开始反向寻找 指定字符 ( ch ) 最后一次出现的位置，若存在即返回该索引，否则返回 -1   即获取在 from 处及其之前 ch 最后一次出现的位置是什么 ( 反向寻找的顺序是 from 、from - 1 、from - 2 、........ )

​	**int lastIndexOf( String s , int from )** 从 当前字符串中 指定位置(from) 开始反向寻找 指定字符串 ( s ) 最后一次出现的位置，若存在即返回该索引，否则返回 -1 即获取在 from 处及其之前 s 最后一次出现的位置是什么

6、**String concat( String )** 将当前 字符串 与 参数给定的字符串 拼接到一个新的字符串中并返回新字符串实例

7、**String toUpperCase()** 将当前 字符串 中所有的小写英文字符转换为大写后返回新的字符串实例

​		x.toUpperCase();

8、**boolean equals( Object )** String 类重写了 equals 方法用于比较 两个 String 实例中所包含的字符串是否相等

9、**boolean equalsIgnoreCase( String )** 比较两个 String 实例中所包含的字符串是否相等 ( 忽略英文字母大小写 )

10**、boolean contentEquals( CharSequence )** 用于比较参数指定的 字符序列 是否与 当前 String 实例所包含的 字符串内容 相等

11、**int compareTo( String )** 用于比较两个字符串的 "大小" ( 当两个字符串相等时返回 零 ( 英文字母区分大小写 ) 		

```java
        String str1 = "abc";
        String str2 = "IloveU";
        System.out.println(str1.compareTo(str2));
		//以上代码运行结果为24，str1的第一个字符 a 在ASCII码表中十进制的下标为 97 ，str2的第一个字符 I 是 73 ，97比73多24，所以返回 24 。(如果第一个相等就比第二个，直到有不相等的做比较，否则返回0)
```

12、**int compareToIgnoreCase( String )** 用于比较两个字符串的 "大小" ( 当两个字符串相等时返回 零 ( 英文字母不区分大小写 ) )		

12、**int length()**

 13、**boolean isEmpty()**  用于判断 当前 String 实例 所包含 字符串 是否为 空 ( 即 value.length 为 零 )

14、**boolean isBlank()** 【 JDK 11 新增的方法 】  用于 当前 String 实例 所包含 字符串 是否为 空白 ( 仅包含了 空格 、制表符 等字符 )

 15、**String trim()** 剔除 当前 String 实例 所包含 字符串 中的首尾空白后返回新的 String 实例

16、**boolean startsWith( String )** 判断 当前 String 实例 中所包含的字符串 是否以指定的 字符串 为【前缀】

17、**boolean endsWith( String )** 判断 当前 String 实例 中所包含的字符串 是否以指定的 字符串 为【后缀】

18、**boolean startsWith( String s , int from )** 判断 当前 字符串 从指定位置开始 是否以指定的 字符串 为前缀

19、**void getChars( int begin , int end , char[] array , int start )** 将 当前 String 实例 中所包含的字符串 中 [ begin , end ) 之间的字符 拷贝到 array 数组的 start 位置

​		s.getChars(0,0,array,0);  即拷贝整个s数组到array数组

20、**String substring( int begin )** 从当前字符串中的 begin 位置处开到字符串末尾截取并返回新字符串

21、**String substring( int begin , int end )** 从当前字符串中截取[ begin , end ) 之间的内容并返回新字符串

22、**CharSequence subSequence( int begin , int end )** 从当前字符串中截取[ begin , end ) 之间的内容并返回 CharSequence 实例

## String 中的字符串相加原理：

### 1	第一种情况：使用引号来创建字符串

​	单独（注意是单独）使用引号来创建字符串的方式，字符串都是常量，在编译期已经确定存储在常量池中了。

​	用引号创建一个字符串的时候，首先会去常量池中寻找有没有相等的这个常量对象，没有的话就在常量池中创建这个常量对象；有的话就直接返回这个常量对象的引用。

```java
String str1 = "hello";
String str2 = "hello";
System.out.println(str1 == str2);//true

```

### 2   第二种情况：new的方式创建字符串

```java
String a = new String("abc");
//new String("abc")会在堆中创建一个对象，变量a中存储其地址，如果常量池中有abc ，则堆中对象的成员变量char数组value，coder，hash会将常量池中的abc的char数组value，coder，hash拿来使用。
//如下代码
//如果常量池中没有abc，则在常量池中创建abc对象，随后将其拿来使用。
```

​		

```java
public String(String original) {
   this.value = original.value;  //只是把传入对象的value和引用传给新的对象, 两个对象其实是共用同一个数组
    this.coder =original.coder;
   this.hash = original.hash;
}
```

### 关于 “+” 运算符

**常量直接相加**

```java
String s1 = "hello" + "word";
String s2 = "helloword";
System.out,println(s1 == s2);//true
//这里的true 是因为编译期直接就把 s1 优化成了 String s1 = "helloword"; 所以后面相等
```

**非常量直接相加**

​		 以下 三步 是 Java 8 中的做法

​	1、StringBuilder sb = new StringBuilder( a ) ; // 创建一个字符缓冲区，并在其中存放 '黄' , '沙' , '百' , '战'

​    2、sb.append( "穿金甲" ) ; // 在 字符缓冲区 中 追加 '穿' , '金' , '甲' ，此时在 字符缓冲区中存在 7 个字符

​    3、sb.toString() ; // 在 toString 方法内部创建并返回一个新的 String 实例，其中封装了 "黄沙百战穿金甲"

```java
		String e = a + "穿金甲" ;  // 至少在 JDK 11 中已经是通过 invokedynamic 实现的
		System.out.println( c == e ); // false : 使用 == 比较两个变量时是在比较两个变量中存储的值
		String f = "黄沙百战" + b ;
		System.out.println( c == f ); // false
		// StringBuilder sb = new StringBuilder();
		// sb.append( a );
		// sb.append( b );
		// sb.toString();
```

## intern方法

当通过 某个String实例 来调用其 intern 方法时，

如果 String常量池 中已经包含一个 与该String实例 所包含内容相等 ( 用 equals(Object)确定 ) 的 String实例，

就直接返回在 String常量池 中已经存在的 String实例 ( 不再将当前的 String实例 添加到 String常量池 ) 。

  否则，将 此 String实例 添加到 String常量池 中，并返回 此String实例 的引用 ( 即返回 String常量池 中新增的 String实例 的地址 )



```java
		String a = "黄沙百战" ;
		String b = "穿金甲" ; 
		String c = "黄沙百战穿金甲" ; 
		String d = a + b ;
		System.out.println( c == d );  // false
		String f = d.intern();
		System.out.println( c == f ); // true


		String s = new String( "不破楼兰终不还" );
		String x = new String( "不破楼兰终不还" );
		System.out.println( s == x ); // false
		System.out.println( s.equals( x ) ); // true
		String t = s.intern() ;
		String r = x.intern() ;
		System.out.println( t == r ); // true
```



## StringBuffer

### 概念

 1、字符串 ( character strings ) 缓冲区 ( buffer ) : string buffer 根据 Java 中类的命名规范命名为 StringBuffer

  2、与 String 类的实例一样，StringBuffer 类的实例 也用于 封装 字符串 ( character strings )

  3、与 String 类的实例 不可变 不同，StringBuffer 类的实例 是 可变的，因此每次操作 都会影响 StringBuffer 实例

```java
		
		StringBuffer buffer = new StringBuffer();// 使用 StringBuffer 无参数构造创建一个 空的 字符串缓冲区
 		buffer.length();//查看实例长度
		 buffer.capacity()//查看该实例所拥有的容量
             
             
           
		StringBuffer buffer1 = new StringBuffer( "hello" ); // capacity  : super( str.length() + 16 );
```

### StringBuffer 类中定义了大量的用来操作 字符串缓冲区 的方法: append / insert / replace / deleteCharAt / delete

```java
	buffer.append( false ); // 在 字符缓冲区中 追加内容
	buffer.insert( 0 , "hello," );
	buffer.replace( 5 , 6 , "，" );
	int index = buffer.indexOf( "，" );
	buffer.deleteCharAt( index );
	buffer.delete( 5 , 10 );
```

	## StringBuilder

 1、StringBuilder 类的设计 与 StringBuffer 基本一致 ( 父类 、实现接口 、构造 、方法 )

 2、StringBuilder 类中的 方法都没有 synchronized 修饰的， 而 StringBuffer 中**所有 public 方法**都是有 synchronized 修饰的

​				(Synchronized是Java中解决并发问题的一种最常用最简单的方法 ，他可以确保线程互斥的访问同步代码)

 3、不论是 StringBuilder 还是 StringBuffer ，都可以使用 setLength 方法有效字符数 、通过 trimToSize 来调整容量 

## StringBuffer 与StringBuilder

### 三者速度比较

结论：

（1）速度比较：String < StringBuffer < StringBuilder

（2）String的处理速度比StringBuffer、StringBuilder要慢的多。

原因：

- String是不可变的对象
- StringBuffer是可变对象
- StringBuilder是可变对象

### StringBuffer和StringBuilder的区别？

- StringBuffer是线程安全的
- StringBuilder是非线程安全的， 这也是速度比StringBuffer快的原因

### 使用场景

（1）如果要操作少量的数据用 String
（2）单线程操作字符串缓冲区 下操作大量数据 StringBuilder
（3）多线程操作字符串缓冲区 下操作大量数据 StringBuffer

# String StringBuffer StringBuilder 三者继承关系



![img](https://img-blog.csdn.net/20180411092328691?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTEwMTE3Mw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)











