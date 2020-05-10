
/**
 * 1、数组、数组元素
 *      【数组】( array ) 是具有确定顺序的若干个相同类型的变量的集合。
 *      数组中的每个变量被称作数组【元素】( element )
 * 
 * 2、数组变量 、数组类型
 * 
 *          类型  变量名称 ;
 *          类型  变量名称 =  数组常量  ;
 * 
 * 3、数组长度
 * 
 *           通过 【数组变量名称.length】 可以获取数组长度
 * 
 * 4、下标(索引)
 * 
 *            因为数组中依次序存放了若干变量，因此可以通过顺序关系来访问其中的变量
 *            用来访问数组中指定位置(次序)的数字就是所谓的 下标 ，也称作 索引
 * 
 * 5、数组常量
 * 
 * 6、数组变量 不是 基本数据类型的变量，
 *      数组变量中存储的不是数值本身而是一个地址，
 *      通过这个地址可以找到真正的存放数据的内存区域
 * 
 */
public class Array2 {

    public static void main(String[] args) {
        
        // first 是变量名称，int 是变量的类型
        int first = 100 ; // 基本数据类型的变量中直接存储相应的取值
        System.out.println( first ); 

        // second 是变量名称，也就是 数组变量名称 ，简称 数组名称
        // int[] 是 second 变量的类型，int[] 既确定了 second 变量的类型，也确定了 second 所对应数组中各个元素的类型
        int[] second = { 10 , 20 , 30 }; // 数组常量 { 10 , 20 , 30 } 确定了 second 对应的数组中每个变量的值 和 second 数组的长度
        System.out.println( second ); 

        // 对于非基本数据类型的变量来说，可以通过 System.identityHashCode( reference ) 方法来获取该变量中所存储的 "地址"
        int address = System.identityHashCode( second ); // 这个方法 死记硬背 也要背下来，将来可以帮很多忙
        System.out.println( address );

        // 通过 for 循环 遍历数组
        for ( int i = 0; i < second.length; i++ ) {
            int element = second[ i ] ; // 通过 数组变量名称[ 下标 ] 来获取相应的元素
            System.out.print( element + "\t");
        }
        System.out.println();

        System.out.println(  "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 对比 C/C++
        // int third[ 5 ] ; // 与 C 语言不同，Java 中不支持这种写法
        int[] third = new int[ 5 ]; // Java 语言中创建数组的方法
        System.out.println( third.length ); 
        for ( int i = 0; i < third.length; i++ ) {
            int element = third[ i ] ;
            System.out.print( element + "\t");
        }
        System.out.println();

        System.out.println( System.identityHashCode( third ) );

    }

}
