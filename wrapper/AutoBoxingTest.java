

/**
 * 1、JDK 1.5 老特性 自动装箱 ( auto-boxing )
 *      所谓自动装箱，就是将 基本类型 的数值 "自动包装" 到一个 包装类类型的实例中
 * 2、将 基本类型的值 赋值给 包装类类型的 引用变量 时，就会发生 自动装箱 ( auto-boxing )
 */
public class AutoBoxingTest {

    public static void main(String[] args) {
        
        int x = 100 ; // 基本类型 的变量中直接存储数值本身
        System.out.println( "x : " + x );

        // 将 基本类型的值 赋值给 包装类类型的 引用变量 时，就会发生 自动装箱 ( auto-boxing )
        Integer o = x ; // 引用类型 的变量中存储的是 堆内存 中某个对象的 地址
        System.out.println( "o : " + o );
        System.out.println( System.identityHashCode( o ) );
        System.out.println( Integer.toHexString( System.identityHashCode( o ) ) );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Integer n = Integer.valueOf( x ); // 手动装箱
        System.out.println( "n : " + n );

        System.out.println( "= = = = = = = = = = = = = = =" );

        Object object = 100L ; // auto-boxing
        System.out.println( "object : " + object );
        System.out.println( "运行时类型 : " + object.getClass().getName() );

        System.out.println( "= = = = = = = = = = = = = = =" );

        // JVM 会为引用类型的数组的每个元素赋予的默认值都是 null
        Object[] array = new Object[ 5 ] ;
        for (int i = 0; i < array.length; i++) {
            System.out.print( array[ i ]  );
            System.out.print( i < array.length - 1 ? " , " : "\n" );
        }

        array[ 0 ] = 100 ; // auto-boxing
        array[ 1 ] = 200D ; // auto-boxing
        array[ 2 ] = 300F ; // auto-boxing
        array[ 3 ] = 400L ; // auto-boxing
        array[ 4 ] = 500 ; // auto-boxing

        for (int i = 0; i < array.length; i++) {
            Object t = array[ i ] ;
            System.out.println( t + " , " + t.getClass().getName() );
        }

    }

}
