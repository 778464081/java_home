
/**
 * 特殊的赋值运算符
 * 
 * 1、与算术运算有关的
 *          a += b ; 类似于 a = a + b ;
 *          a -= b ; 类似于 a = a - b ;
 *          a *= b ; 类似于 a = a * b ;
 *          a /= b ; 类似于 a = a / b ;
 *          a %= b ; 类似于 a = a % b ;
 * 
 * 2、与位运算中移位有关的
 *          a >>= b ; 类似于 a = a >> b ;
 *          a >>>= b ; 类似于 a = a >>> b ;
 *          a <<= b ;类似于 a = a << b ;
 * 
 * 3、与其他位运算有关的
 *          a |= b ; 类似于 a = a | b ;
 *          a &= b ; 类似于 a = a & b ;
 *          a ^= b ; 类似于 a = a ^ b ;
 */
public class Assignment {

    public static void main( String[] args ) {

        int first = 5 ; // 默认就是正数
        System.out.println( "first : " + first );

        int second = -5 ; // 注意这里的 等号 之后的 - 表示负号
        System.out.println( "second : " + second );

        int third = +5 ; // 注意这里的 等号 之后的 + 表示 正号
        System.out.println( "third : " + third );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        char x = 100 ; // byte 、short 、char
        System.out.println( "x : " + x );
        x += 2 ; // x += 2 【类似于】 x = x + 2 ，因为 x += 2 不会发生自动类型提升，而 x = x + 2 可能会发生类型提升
        System.out.println( "x : " + x );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        byte p = 7 ; // 00000111
        System.out.println( "p : " + p );
        p >>= 1 ; // p = p >> 1 ;
        System.out.println( "p : " + p );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int r = 5 ;
        int s = 7 ;
        System.out.println( "r : " + r + " , s : " + s );

        r ^= s ; // r = r ^ s ;
        s ^= r ; // s = s ^ r ;
        r ^= s ; // r = r ^ s ;

        System.out.println( "r : " + r + " , s : " + s );

    }

}
