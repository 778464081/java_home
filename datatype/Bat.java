
/**
 * 1、强制类型转换的使用方法:
 *           目标类型 变量名称    = (目标类型)  源变量名或数值 ;
 * 2、整数类型的强制类型转换会舍弃高位、留下低位 （舍弃多少高位、留下多少低位，取决于源类型和目标类型）
 * 3、反码和补码 : 补码 = 反码 + 1 ========>  反码 =  补码 - 1 
 * 4、原码和反码 : 原码按位取反得到反码 ，反码按位取反得到原码
 * 5、原码和补码 : 原码 + 补码 = 0 
 */
public class Bat {

    public static void main( String[] args ) {

        int first = 100 ; // 0000_0000_0000_0000_0000_0000_0110_0100
        System.out.println( first );

        // byte second = first ; // 不兼容的类型: 从 int 转换到 byte 可能会有损失
        // 
             byte        second      =      (byte)       first ; // 0110_0100
        System.out.println( second );

        short third = (short) first ; // 0000_0000_0110_0100
        System.out.println( third );

        //           130 : 0000_0000_0000_0000_0000_0000_1000_0010 【32bit】
        // (byte)130 : 1000_0010 【8bit】
        byte fourth = (byte) 130 ;
        System.out.println( fourth );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        //              (byte)130 : 1000_0010 【8bit】 -126
        //  得到某个数的反码 :  1000_0001 【8bit】-127
        //安危取反得到某个数:  0111_1110  【8bit】  126

        System.out.println( (byte)0b1000_0010 );
        System.out.println( (byte)0b1000_0001 );
        System.out.println( (byte)0b0111_1110 );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
        
        System.out.println( (byte)0b0111_1111 ); // 将一个正数的二进制形式当做 【原码】
        System.out.println( (byte)0b1000_0000 ); // 将正数的原码按位取反得到 【反码】
        System.out.println( (byte)0b1000_0001 ); // 反码加一得到【补码】

    }

}
