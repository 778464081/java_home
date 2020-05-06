
/**
 * 算术运算符
 * 1、+ 加法
 * 2、- 减法
 * 3、* 乘法
 * 4、/ 除法
 * 5、% 取模 ( 整除取余数 ) 【 注意 整数 和 浮点数 都可以实现 模运算】
 * 6、++ 自增 【 注意 i++ 与 ++i 的区别 】
 * 7、-- 自减 【 注意 i-- 与 --i 的区别 】
 */
public class Arithmetic {

    public static void main(String[] args) {
        
        long first = 0x7FFF_FFFF_FFFF_FFFFL ; // 取 long 类型的最大值
        long second = 10000L ;
        // 不论两数相加后是多大，都从最低位开始取够64位
        long result1 = first + second ; // 两个 long 类型的数值相加后如果超出 long 取值范围 ( -9223372036854765809 )
        System.out.println( result1 );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int third = 0x8000_0000 ; // byte third = 100 ;
        short fourth = 300 ;
        int result2 = third - fourth ; // fourth 变量中的值自动提升为 int 然后再参与减法运算( 两数相减的差可能超出int的取值范围 )
        System.out.println( result2 );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int fifth = 0x7FFF_FFFF ;
        long sixth = 9 ; // int sixth = 9 ;

        long result3 = fifth * sixth ;
        System.out.println( result3 );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        System.out.print( "5 / 2 = " ) ;
        System.out.println( 5 / 2 ); // 整除

        System.out.print( "5 / 2.0 = " ) ; 
        System.out.println( 5 / 2.0 ); // 除尽 ( 与数学中的除法相同 )

        // System.out.print( "5 / 0 = " ) ; 
        // System.out.println( 5 / 0 ); // 运行时出错: java.lang.ArithmeticException

        System.out.print( "5 / 0.0 = " ) ; 
        System.out.println( 5 / 0.0 ); // Infinity ( 正无穷大 )

        System.out.print( "-5 / 0.0 = " ) ; 
        System.out.println( -5 / 0.0 ); // -Infinity ( 负无穷大 )

        System.out.print( "5 / ( 5 / 0.0 ) = " ) ; 
        System.out.println( 5 / ( 5 / 0.0 ) ); // 0.0

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        System.out.print( "5 % 2 = " ) ;
        System.out.println( 5 % 2 ); // 取模 : 整除取余数 ( 1 )

        System.out.print( "5.45 % 2.2 = " ) ;
        System.out.println( 5.45 % 2.2 ); // 取模 : 整除取余数 ( 1.05 )

        System.out.print( "5 % 0.0 = " ) ;
        // System.out.println( 5 % 0 ); // 运行时错误 : java.lang.ArithmeticException
        System.out.println( 5 % 0.0 );  // NaN : Not a Number , 不是一个数字

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
    
        int x = 100 ;
        System.out.println( x ); // 100
        System.out.println( x++ ); // 100【先输出原来的值、再执行自增操作】
        System.out.println( x ); // 101

        short s = 100 ;
        System.out.println( s ); // 100
        System.out.println( ++s ); // 101 【先执行自增操作、再执行输出操作】
        System.out.println( s ); // 101

        byte b = 100 ;
        byte y = b-- ; // 【先将b变量原来的值赋值给y变量、再执行b变量的自减操作】
        System.out.println( "y = " + y + " , b = " + b ); // y = 100 , b = 99

        long c = 1000L ;
        long z = --c ; // 【先执行c变量的自减操作，再将b变量的值赋值给z变量】
        System.out.println( "z = " + z + " , c = " + c ); // z = 999 , c = 999

    }

}