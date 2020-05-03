
public class BaseMinusOneComplement {

    public static void main(String[] args) {
        
          // 【计算机组成原理】正数的原码 : 00001011  【 11 】 
          byte first = 0b00001011 ;
          System.out.println( first );

          // 【计算机组成原理】正数的反码 : 00001011  【 11 】 
          byte second = 0b00001011 ;
          System.out.println( second );

          System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
  
          // 【计算机组成原理】负数的原码 : 10001011   【 -11 】 
          byte fourth = (byte)0b10001011 ; // 默认将 0b10001011 当做 int 对待
          System.out.println( fourth );

           // 【计算机组成原理】负数的反码 : 11110100 
           byte fifth = (byte)0b11110100 ; // 默认将 0b11110100 当做 int 对待
           System.out.println( fifth );
  

    }

}
