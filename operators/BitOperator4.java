
/**
 * 位运算符 
 * 1、|  按位或 ( 逐位或 )
 * 2、&  按位与 ( 逐位与 )
 * 3、^ 按位异或 (逐位异或 )
 * 4、~ 按位取反 (逐位取反) 【注意连符号位也一起取反】
 */
public class BitOperator4 {

    public static void main(String[] args) {
        
        final int x = 5 ; // 0b00000000_00000000_00000000_00000101
        final int y = 7 ; // 0b00000000_00000000_00000000_00000111

        //【 5 】0b00000000_00000000_00000000_00000101
        //【 7 】0b00000000_00000000_00000000_00000111
        int a = x | y ; // 按位或: 0b00000000_00000000_00000000_00000111
        System.out.println( a );

        //【 5 】0b00000000_00000000_00000000_00000101
        //【 7 】0b00000000_00000000_00000000_00000111
        int b = x & y ; // 按位与: 0b00000000_00000000_00000000_00000101
        System.out.println( b );

        //【 5 】0b00000000_00000000_00000000_00000101
        //【 7 】0b00000000_00000000_00000000_00000111
        int c = x ^ y ; // 按位异或: 0b00000000_00000000_00000000_00000010
        System.out.println( c );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int r = 5 ; // 0b00000000_00000000_00000000_00000101
        int s = 7 ; // 0b00000000_00000000_00000000_00000111
        System.out.println( "r = " + r + " , s = " + s );

        // int temp = s ; s = r ; r = temp ;
        r = r ^ s ; // 0b00000000_00000000_00000000_00000010
        s = r ^ s ; // 0b00000000_00000000_00000000_00000101
        r = r ^ s ; // 0b00000000_00000000_00000000_00000111

        System.out.println( "r = " + r + " , s = " + s );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int j = 5 ; // 0b00000000_00000000_00000000_00000101
        // 注意使用 ~ 按位取反时，会对整数的符号位也取反
        int k = ~j ; //0b11111111_11111111_11111111_11111010
        //【补码】 11111111_11111111_11111111_11111010
        //【反码】 11111111_11111111_11111111_11111001
        //【原码】 10000000_00000000_00000000_00000110
        System.out.println( "j = " + j + " , k = " + k );

    }

}
