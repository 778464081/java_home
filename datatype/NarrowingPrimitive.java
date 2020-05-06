
public class NarrowingPrimitive {

    public static void main(String[] args) {

        // 【 1 】In the first step, 
        // the floating-point number is converted either to a long , if T is long, or to an int, if T is byte, short, char, or int, as follows:

        // 【 1.1 】If the floating-point number is NaN ( Not a Number ), the result of the first step of the conversion is an int or long 0 .
        double nan = Double.NaN ; // NaN 是 Double 类中声明的一个常量
        System.out.println( nan );
        System.out.println( "byte : " + (byte) nan + " , short : " + (short) nan + " , int : " + (int) nan + " , long : " + (long) nan );
        System.out.println( "  1.1~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 【 1.2 】Otherwise, if the floating-point number is not an infinity, the floating-point value is rounded to an integer value V, 
        //              rounding toward zero using IEEE 754 round-toward-zero mode (§4.2.3). Then there are two cases:

        // 【 1.2.1 】If T is long, and this integer value can be represented as a long, then the result of the first step is the long value V
        double lv = 0xFFFFFFFFL + 0.625; // 假设 double 变量中存储的数值的整数部分恰好是 long 类型可以表示的整数
        System.out.println( lv );
        System.out.println( "long : " + (long) lv );
        System.out.println( "1.2.1 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 【 1.2.2 】Otherwise, if this integer value can be represented as an int, then the result of the first step is the int value V.
        double iv = 0xFFFFFF + 0.625; // 假设 double 变量中存储的数值的整数部分恰好是 int 类型可以表示的整数
        System.out.println( iv );
        System.out.println( "int : " + (int) iv );
        System.out.println( "1.2.2~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 【 1.3 】Otherwise, one of the following two cases must be true:

        // 【 1.3.1 】The value must be too small ( a negative value of large magnitude or negative infinity ), 
        //                 and the result of the first step is the smallest representable value of type int or long.
        // double negative = Double.NEGATIVE_INFINITY ; // NEGATIVE_INFINITY 是 Double 类中定义的常量，表示负无穷大
        double negative = 0x8000_0000_0000_0000L - 10000.0 ; // 一定要让 long 类型的值 减去 double 类型的数值
        System.out.println( negative );
        System.out.println( "int : " + (int) negative + " , long : " + (long) negative );
        // int min value : 0x8000_0000 ( 0b1000_0000_0000_0000_0000_0000_0000_0000 )
        // long min value : 0x8000_0000_0000_0000L

        System.out.println( "1.3.1~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 【 1.3.2 】The value must be too large ( a positive value of large magnitude or positive infinity ), 
        //                 and the result of the first step is the largest representable value of type int or long.
        // double positive = Double.POSITIVE_INFINITY ; // POSITIVE_INFINITY 是 Double 类中定义的常量，表示正无穷大
        double positive = 0x7FFF_FFFF_FFFF_FFFFL + 10000.0 ; // 一定要让 long 类型的值 加上 double 类型的数值 
        System.out.println( positive );
        System.out.println( "int : " + (int) positive + " , long : " + (long) positive );
        // int max value : 0x7FFF_FFFF ( 0b0111_1111_1111_1111_1111_1111_1111_1111 )
        // long max value : 0x7FFF_FFFF_FFFF_FFFFL

        double x = 0xFFFF + 0.1415926 ;
        //【 2 】In the second step:
        //【 2.1 】 If T is int or long, the result of the conversion is the result of the first step.
        System.out.println( "int : " + (int) x + " , long : " + (long) x );

        //【 2.2 】 If T is byte, char, or short, the result of the conversion is the result of a narrowing conversion to type T of the result of the first step
        System.out.println( "byte : " + (byte) x + " , char : " + (char) x + " , short : " + (short) x );

        System.out.println( "2.2~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

         // (byte) positive 表示从 long max value 中截取 低 8 位 : 1111_1111
         System.out.println( (byte)0b1111_1111 );
         // 将8位的 1111_1111 当做补码，可以获取到相应的反码为 1111_1110 ，遂后保持符号位不变、数值部分逐位取反得到原码 1000_0001
 
         // (short) positive 表示从 long max value 中截取 低 16 位 : 1111_1111_1111_1111
         System.out.println( (short)0b1111_1111_1111_1111 );
         // 将16位的 1111_1111_1111_1111 当做补码，可以获取到相应的反码为 1111_1111_1111_1110 ，遂后保持符号位不变、数值部分逐位取反得到原码 1000_0000_0000_0001 

    }

}
