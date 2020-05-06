/**
 * 对比 逻辑运算符 中 & 和 && 的区别 、| 和 || 的区别
 * 逻辑或: || (短路)、|(不短路)
 * 逻辑与: && (短路)、&(不短路)
 */
public class Logic3 {

    public static void main(String[] args) {
        
        int a = 100 ;
        int b = 100 ;
        System.out.println( "a = " + a + " , b = " + b );
        System.out.println( ++a > 99 | ++b > 99 ); // 不短路
        System.out.println( "a = " + a + " , b = " + b );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int c = 100 ;
        int d = 100 ;
        System.out.println( "c = " + c + " , d = " + d ); // c = 100 , d = 100
        System.out.println( ++c > 99 || ++d > 99 ); // 短路
        System.out.println( "c = " + c + " , d = " + d ); // c = 101 , d = 100

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int m = 100 ;
        int n = 100 ;

        System.out.println( "m = " + m + " , n = " + n ); // m = 100 , n = 100
        System.out.println( ++m < 99 & ++n < 99 ); // 不短路
        System.out.println( "m = " + m + " , n = " + n );// m = 101 , n = 101

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int x = 100 ;
        int y = 100 ;

        System.out.println( "x = " + x + " , y = " + y ); // x = 100 , y = 100
        System.out.println( ++x < 99 && ++y < 99 ); // 短路
        System.out.println( "x = " + x + " , y = " + y ); // x = 101 , y = 100
    }

}
