
/**
 * 1、所谓的自动装箱，实际上就是由编译器将 相应的代码替换为 Xxx.valueOf( xxx value )
 * 2、让一个 包装类类型的变量 与 基本类型的变量比较时，会发生自动拆箱
 * 3、Integer.valueOf( int ) 方法中会判断 参数对应的数字是否是 [ -128 , 127 ]  之间
 * 4、了解: 
 *       在 Ineger 类内部有一个 IntegerCache 内部类，
 *       在 IntegerCache 中有一个 cache 数组，其中默认缓存了 [ -128 , 127 ] 之间 的数字对应的 Integer 实例
 * 5、自行测试 其它的 包装类中的 缓存
 */
public class IntegerCacheTest {

    public static void main(String[] args) {
        
        int x = 100 ; // 基本类型
        Integer a = 100 ; // 引用类型 ( auto-boxing : Integer.valueOf( 100 ) )
        Integer b = 100 ; // 引用类型 ( auto-boxing : Integer.valueOf( 100 )  )
        // 但凡是使用 == 比较两个变量，一定是比较变量中存储的值
        System.out.println( a == b ); // true : 说明两者存储的地址是【相同】的
        System.out.println( "a : " + Integer.toHexString( System.identityHashCode( a ) ) );
        System.out.println( "b : " + Integer.toHexString( System.identityHashCode( b ) ) );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 自动拆箱 ( auto-unboxing ) : 手动拆箱后的代码是 a.intValue() == x 
        System.out.println( a == x ); // true : 说明包装类类型的实例中封装的数值 与 基本类型变量中存储的数值 是相等的

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // Object o = 100 ; // auto-boxing
        // System.out.println( o == x ); // 错误: 二元运算符 '==' 的操作数类型错误

        Integer u = 1000 ; // Integer.valueOf( 1000 ) 
        // Integer.valueOf( int ) 方法中会判断 参数对应的数字是否是 [ -128 , 127 ] 之间，
        // 如果是该范围内的数字就直接从 缓存数组中获取已经创建好的 Integer 实例 ，否则就创建新的 Integer 实例
        Integer w =  1000  ; // Integer.valueOf( 1000 ) 
        System.out.println( u == w ); // false : 说明两者存储的地址是【不相同】的
        System.out.println( "u : " + Integer.toHexString( System.identityHashCode( u ) ) );
        System.out.println( "w : " + Integer.toHexString( System.identityHashCode( w ) ) );
        System.out.println( u.equals( w ) ); // 比较两个 Integer 实例中封装的 数值 是否相等

    }

}
