
public class Arab {

    public void sort( int[] array ) {
        for (int i = 0 ; i < array.length - 1 ; i++) {
            for (int j = 0; j < array.length - 1 - i ; j++) {
                if( array[ j ] > array[ j + 1 ] ) {
                    array[ j ] ^= array[ j + 1 ] ;
                    array[ j + 1 ] ^= array[ j ] ;
                    array[ j ] ^= array[ j + 1 ] ;
                }
            }
        }
    }

    public void traversal( int[] array ) {
        for (int i = 0; i < array.length; i++) {
            System.out.print( array[ i ] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Arab a = new Arab();

        // 静态初始化 : 声明数组时使用 数组常量 直接对 数组进行初始化
        int[] array = { 2 , 1 , 4 , 7 , 8 , 0 , 3, 5 , 6 , 9 } ;
        System.out.println( array ); // 类型@哈希码
        System.out.println( System.identityHashCode( array ) ) ;

        // 排序之前遍历数组
        a.traversal( array ); // 参数传递

        // 对数组排序
        a.sort( array ); // 参数传递

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 排序之后遍历数组
        a.traversal( array ); // 参数传递

    }

}
