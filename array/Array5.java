
import java.util.Random;

/**
 * 1、能够区分 基本数据类型的变量 和 引用变量
 * 2、掌握冒泡排序
 */
public class Array5 {

    public static void main(String[] args) {
        
        // x 是基本数据类型 (原生类型)的变量
        int x = 100 ; // 基本数据类型的变量中可以直接存储数值本身
        System.out.println( x );

        // a 是一个引用类型的变量
        int[] a = { 2 , 4 , 6 , 8 , 10 } ;  // 引用类型的变量中存储的是地址
        System.out.println( a ); // 类型@哈希码
        // 对于引用类型变量来说，可以通过 identityHashCode 方法来获取变量中存储的地址
        System.out.println( System.identityHashCode( a ) );

        System.out.println( "= = = = = = = = = = = = = = = = = = = =" );

        // 数组下标的有效范围是 [ 0 , array.length - 1 ] ，如果超出这个范围就会抛出 ArrayIndexOutOfBoundsException
        // 对于 length 为 10 的数组来说，其下标取值范围是 [ 0 , 9 ] 
        int[] array = new int[ 10 ] ;

        Random rand = new Random();

        for( int i = 0 ; i < array.length ; i++ ) {
            array[ i ] = rand.nextInt( 100 ) ; // 随机产生 [ 0 , 100 ) 之间的整数并将该整数赋值给 array 数组中下标为 i 的变量
        }

        /* 在初始化数组之后遍历数组，将数组中每个元素逐个输出 */
        for( int i = 0 ; i < array.length ; i++ ){
            System.out.print( array[ i ] + "  " );
        }
        System.out.println();

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 冒泡排序 ( Bubble Sort )
        for( int r = 0 ; r < array.length ; r++ ){
            // 为什么 在 内层循环的 判断语句中 要有  array.length 减去 1 ，再减去 r
            for( int i = 0 ; i < array.length - 1 - r ; i++ ){
                if( array[ i ] > array[ i + 1 ] ) {
                    // 对于整数类型变量来说可以使用 按位异或 实现交换
                    array[ i ] ^= array[ i + 1 ] ;
                    array[ i + 1 ] ^= array[ i ] ;
                    array[ i ] ^= array[ i + 1 ] ;
                }
            }
        }


        /* 在对数组中的元素排序之后再次遍历数组，将数组中每个元素逐个输出 */
        for( int i = 0 ; i < array.length ; i++ ){
            System.out.print( array[ i ] + "  " );
        }
        System.out.println();

    }

}
