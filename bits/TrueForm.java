
/**
 * 1、在 Java 语言中整数可以采用 二进制 、八进制、十进制、十六进制 形式来书写 字面量
 *      二进制: 0b 或 0B 【从 Java 1.7 开始支持】
 *      八进制: 0
 *      十进制: 没有前缀，默认就是
 *      十六进制: 0x 或 0X
 * 2、不将计算机组成原理中所说的原码应用到 Java 程序中
 */
public class TrueForm {

    public static void main(String[] args) {
        
         // 【计算机组成原理】正数的原码 : 00001011  【 11 】 
         byte first = 0b00001011 ;
         System.out.println( first );

        // 【计算机组成原理】负数的原码 : 10001011   【 -11 】 
        byte fourth = (byte)0b10001011 ; // 默认将 0b10001011 当做 int 对待
        System.out.println( fourth );

    }

}
