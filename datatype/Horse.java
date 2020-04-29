
/**
 * 1、基本数据类型 之 整数类型 : byte 、short 、int 、long
 * 2、Java 语言中为 8 中基本数据类型提供了相应的包装类
 *         byte  <===>  Byte
 *         short <===>  Short
 *         int   <===>  Integer
 *         long  <===>  Long
 * 3、基本数据类型中整数类型对应包装类都可以通过 MAX_VALUE 获取最大值，通过 MIN_VALUE 获取最小值
 * 4、从 JDK 1.7 开始允许在 Java 源代码中使用 二进制形式 来书写整数值 ( 以 0b 或 0B 为前缀 )
 * 5、在 Java 源代码中可以使用 十六进制 形式来书写整数值 ( 以 0x 或 0X 为前缀 )
 */
public class Horse {

   public static void main( String[] args ) {

      // 在 Java 语言中，byte 类型的数值 占 8 Bit (二进制位)
      // byte first = 200 ; // 不兼容的类型: 从int转换到byte可能会有损失
      byte first = 100 ; // 在 Java 源代码中直接书写的 整数都是 int 类型
      System.out.println( first );  
      // 在 "" 内部直接书写的内容就是 字符串 ( 对应 String 类型 )
      System.out.print( "byte min value : " ); // 注意 print 方法可以输出数据但不换行
      System.out.println( Byte.MIN_VALUE ); // 通过 Byte 类的 MIN_VALUE 来获取 byte 最小值

      // 在 Java 语言中，与基本数据类型 byte 对应的 包装类类型是 Byte 类 ( 以后会讲 )

      System.out.print( "byte max value : " );
      System.out.println( Byte.MAX_VALUE ); // 通过 Byte 类的 MAX_VALUE 来获取 byte 最大值

      // 在 Java 语言中 short 类型的数值 占 16 Bit (二进制位)
      short second = 30000 ;
      System.out.println( second );

      System.out.print( "short min value : " );
      System.out.println( Short.MIN_VALUE ); // 通过 Short 类的 MIN_VALUE 来获取 short 最小值
      
      System.out.print( "short max value : " );
      System.out.println( Short.MAX_VALUE ); // 通过 Short 类的 MAX_VALUE 来获取 short 最大值

      // 在 Java 语言中 int 类型的数值 占 32 Bit (二进制位) 
      // int third = 0b0000_0000_0000_0000_0000_0000_0000_0000 ; // 以 0b 或 0B 为前缀
      int third = 0b1000_0000_0000_0000_0000_0000_0000_0000 ;
      // int third = 0b0111_1111_1111_1111_1111_1111_1111_1111 ; 
      System.out.println( third );

      System.out.print( "int min value : " );
      System.out.println( Integer.MIN_VALUE ); // 通过 Integer 类的 MIN_VALUE 来获取 int 最小值

      System.out.print( "int max value : " );
      System.out.println( Integer.MAX_VALUE ); // 通过 Integer 类的 MAX_VALUE 来获取 int 最大值

      // 在 Java 语言中 long 类型的数值 占 64 Bit (二进制位)
      long fourth = 0b01111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111L ;
      System.out.println( fourth ); // Long.MAX_VALUE 

      long fifth = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L ;
      System.out.println( fifth ); // Long.MIN_VALUE 

      long sixth = 0x8000_0000_0000_0000L ; // 以十六进制形式表示整数，以 0x 或 0X 为前缀
      System.out.println( sixth ); 
      
   }

}

