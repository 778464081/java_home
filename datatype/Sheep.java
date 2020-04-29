
/*
 * 1、不论是 float 还是 double 都遵循 IEEE 754 标准
 * 2、float 类型的数值占 32 个二进制位
 * 3、double 类型的数值占 64 个二进制位
 * 4、在 Java 源代码中直接书写的 浮点数 默认都是 double 类型
 */
public class Sheep {
   public static void main( String[] args ) {

      // 在 Java 语言中 double 类型的数值 占 64 Bit ( 二进制位 )
      double first = 3.14 ;
      System.out.println( first );

      // 这里使用的 + 运算符表示 拼接字符串
      System.out.println( "double min value : " + Double.MIN_VALUE );
      System.out.println( "double max value : " + Double.MAX_VALUE );

      // 在 Java 语言中 float 类型的数值 占 32 Bit ( 二进制位 )
      float second = 3.14F ; // 在直接书写的浮点数末尾增加 F 或 f 后缀来表示 float 类型数值 
      System.out.println( second );

      System.out.println( "float min value : " + Float.MIN_VALUE );
      System.out.println( "float max value : " + Float.MAX_VALUE );

   }
}

