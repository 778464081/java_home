
/*
 * 1、认识 Java 语言中的 8 种基本数据类型
 * 2、在Java源代码中直接书写的整数值默认是 int 类型
 * 3、在Java源代码中直接书写的浮点数默认是 double 类型
 * 4、在Java语言中使用 boolean 类型表示逻辑值，其取值只有 true 、false
 * 5、对于 char 类型变量取值来说，可以使用 单引号直接将字符引起来，也可以使用 Unicode 编码
 */
public class Loong {

   public static void main( String[] args ) {

      // 基本数据类型(也称作原始数据类型或原生类型)
      byte first = 100 ;
      System.out.println( first );

      short second = 30000 ;
      System.out.println( second );

      int third = 66666 ;
      System.out.println( third );
 
      // long fourth = 12345678901234 ; // 错误: 整数太大
      long fourth = 12345678901234L ; // long 类型的数值之后加上 L 或 l 
      System.out.println( fourth );

      // float fifth = 3.141592653589793 ; // 不兼容的类型: 从double转换到float可能会有损失
      float fifth = 3.141592653589793F ; // float 类型的数值之后加上 F 或 f
      System.out.println( fifth );

      // double 类型的数值之后 可以加上 D 或 d ，也可以不加
      double sixth = 3.141592653589793238462643383279D ;
      System.out.println( sixth );

      // 在 C / C++ 有 非零即真 的说法，在Java只能使用 true 或 false 来表示
      boolean seventh = false ; // boolean 类型的取值只有两个 true 、false
      System.out.println( seventh );

      char ch1 = '中' ; // char 类型的取值 可以是 单引号 引起来的 单个字符
      System.out.println( ch1 );

      // 直接将某个范围内的整数赋值给 char 类型的变量，这个整数会根据 Unicode 编码转换为相应的字符 ( ASC II 码 是 Unicode 编码的子集 )
      char ch2 = 100 ;
      System.out.println( ch2 );

      char ch3 = '\u8fa3' ; // 在单引号中可以使用 Unicode 编码来表示单个字符
      System.out.println( ch3 );
   }

}

