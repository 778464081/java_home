
public class Lion {

    public static void main( String[] args ) {

        // Integer.MAX_VALUE : 2147483647
        System.out.println( 0x7FFF_FFFF ); // 0b0111_1111_1111_1111_1111_1111_1111_1111
        // Integer.MIN_VALUE : -2147483648
        System.out.println( 0x8000_0000 ); // 0b1000_0000_0000_0000_0000_0000_0000_0000

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 2147483648.625
        System.out.println( 0b1000_0000_0000_0000_0000_0000_0000_0000L );

        // float x =  992147483647.625F ;
        // IEEE 754 double :  S : 1  、E : 11 、M : 52
        // IEEE 754 float :     S : 1  、E : 8 、 M : 23
        float x =  2147483648.625F ;
        // 2147483648.625F 的二进制形式: 10000000000000000000000000000000.101
        // 1.0000000000000000000000000000000101 * 2 ^ 31
        // 确定指数 : 127 + 31 : 01111111 + 00011111 ==>  10011110
        // 确定尾数 : 1.0000000000000000000000000000000101  ===> 0000000000000000000000000000000101
        // 确定浮点数的机器码: 0  1001_1110  0000_0000_0000_0000_0000_000
        
        System.out.println( x );

        int y = (int) x ;
        System.out.println( y );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        short s = (short) x ;
        System.out.println( s );
        System.out.println( Short.MAX_VALUE );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        byte b = (byte) x ;
        System.out.println( b );
        System.out.println( Byte.MAX_VALUE );

    }

}
