
/**
 * 1、JDK 1.5 老特性 自动拆箱 ( auto-unboxing )
 *      所谓自动拆箱，就是将 包装类类型的实例中所封装的 基本类型的值 取出来，仍然以基本类型数值的方式来运算
 * 2、当将一个包装类类型的引用变量的值 "赋值" 给一个基本数据类型的变量时，会发生 自动拆箱
 * 3、用一个包装类类型的引用变量 参与 运算时，会发生自动拆箱
 */
public class AutoUnboxingTest {

    public static void main(String[] args) {

        Integer x = Integer.valueOf( 9527 ); 

        // 当将一个包装类类型的引用变量的值 "赋值" 给一个基本数据类型的变量时，会发生 自动拆箱 ( auto-boxing )
        int i = x ; // auto-unboxing 
        System.out.println( i );

        int n = x.intValue() ; // JDK 1.5 之前需要 手动拆箱
        System.out.println( n );

        Long ox = Long.valueOf( 10000L );
        long o = ox ; // 这里对应的 手动拆箱 代码是 ox.longValue()
        System.out.println( o );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Double d = Double.valueOf( 3.14 );
        // 使用 包装类 类型的引用变量 参与数学运算时，会首先自动拆箱，然后再运算
        double u = d + 1 ; // auto-unboxing
        System.out.println( u );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Integer y = Integer.valueOf( 999 ); 
        System.out.println( "y : " + y );
        System.out.println( Integer.toHexString( System.identityHashCode( y ) ) );
        y++ ; // 1、auto-unboxing ( 999 )     2、++ ( 999 --> 1000 )     3、auto-boxing ( 1000 )
        System.out.println( "y : " + y );
        System.out.println( Integer.toHexString( System.identityHashCode( y ) ) );

    }

}
