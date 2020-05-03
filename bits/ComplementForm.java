
public class ComplementForm {

    public static void main(String[] args) {
        
          // 【计算机组成原理】正数的原码 : 00001011  【 11 】 
          byte first = 0b00001011 ;
          System.out.println( first );

          // 【计算机组成原理】正数的反码 : 00001011  【 11 】 
          byte second = 0b00001011 ;
          System.out.println( second );

          // 【计算机组成原理】正数的补码 : 00001011  【 11 】 
          byte third = 0b00001011 ;
          System.out.println( third );

          System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
  
          // 【计算机组成原理】负数的原码 : 10001011   【 -11 】 
          byte fourth = (byte)0b10001011 ; // 默认将 0b10001011 当做 int 对待
          System.out.println( fourth );

           // 【计算机组成原理】负数的反码 : 11110100
           byte fifth = (byte)0b11110100 ; // 默认将 0b11110100 当做 int 对待
           System.out.println( fifth ); // -12

           // 【计算机组成原理】负数的补码 : 11110101 
           byte sixth = (byte)0b11110101 ; // 默认将 0b11110100 当做 int 对待
           System.out.println( sixth ); // -11

           System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

           int x = 0b1111_1111_1111_1111_1111_1111_1001_0110 ; // 【补码】
           // 0b1111_1111_1111_1111_1111_1111_1001_0101 【反码: 补码 减去 1 得到 反码 ，符号位不变】
           // 0b1000_0000_0000_0000_0000_0000_0110_1010 【原码: 反码除符号位外逐位取反】
           System.out.println( x );

           System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

           // 1001_0110_1011_0100_0011_1
           System.out.println( (short)0b1101_0110_1000_0111 );
           // 【补码】1101_0110_1000_0111
           // 【反码】1101_0110_1000_0110
           // 【原码】1010_1001_0111_1001
           System.out.println( (short)1234567.89 ); // 1001_0110_1011_0100_0011_1.111_0001_1110_1011_1000_0101_0001_11101

           System.out.println( 0b0010_1001_0111_1001 );
  
    }

}