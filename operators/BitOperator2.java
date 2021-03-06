
/**
 * 位运算符 - 移位
 * 1、>> 向右移位，使用方法为 x >> n 表示 x 向右移动 n 位
 *      对于正数来说，向右移位时，高位补0，低位被挤掉
 *      对于负数来说，向右移位时，高位补1，低位被挤掉
 * 
 * 2、<< 向左移位，使用方法为 x << n 表示 x 向左移动 n 位
 *      不论是正数还是负数，向左移位时，都是挤掉高位，低位补0
 * 
 * 3、>>> 无符号右移
 *      不论是正数还是负数，向右移位时，高位一律补0，低位被挤掉
 * 
 * 4、Java 中没有 <<< 运算符 【划重点】
 */
public class BitOperator2 {

    public static void main(String[] args) {
        
        final int x = 5 ; // 0b00000000_00000000_00000000_00000101
        final int y = -5 ; // 0b1111_1111_1111_1111_1111_1111_1111_1011

        System.out.println( x >> 1 ); // 0b0_00000000_00000000_00000000_0000010
        System.out.println( y >> 1 ); // 0b1_1111_1111_1111_1111_1111_1111_1111_101

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        System.out.println( x >>> 1 ); // 0b0_00000000_00000000_00000000_0000010
        System.out.println( y >>> 1 ); // 0b0_1111_1111_1111_1111_1111_1111_1111_101

    }

}
