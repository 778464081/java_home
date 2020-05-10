
import java.util.Random ;

/**
 * 1、array = new int[ 5 ] ; 到底完成了哪些操作
 * 2、通过 array 获取数组长度、访问数组元素都要首先通过 array 变量中存储的"地址"找到真正的数组
 * 3、通过 new 关键字 在 堆内存 中 创建的数组 ，就是一个特殊的 Java 对象，很多时候将其称作 数组对象  或 数组实例
 */

public class Array4 {

    public static void main(String[] args) {

        int[] array ; // 声明一个数组变量
        // System.out.println( array ); //【编译失败】错误: 可能尚未初始化 变量 array

        // 只有在声明数组时才可以将 数组常量 赋值给 数组变量
        // array = { 100 , 200 , 300 }; //【编译失败】错误: 非法的表达式开始

        // 1、new 负责在 堆内存 中开辟空间
        // 2、类型 ( int ) 和 数组长度 ( 5 ) 确定 new 所开辟的内存大小 ( 一个 int 变量占 4 字节，5 个就是 20 字节 ) 
        // 3、为已经创建好的 5 个 int 变量赋予默认值 ( int 类型默认值都是 0 )
        // 4、最后将 堆内存中 数组的首地址 赋值给 数组变量 ( array )
        array = new int[ 5 ];
        System.out.println( "数组变量 array 中存储的 '地址' 是: " + System.identityHashCode( array ) );

        // 通过 数组变量 array 中存储的地址找到 堆内存 中的 数组 后，再获取数组长度并输出
        System.out.println( "数组长度: " + array.length ); // 输出 array 数组 的 长度

        for (int i = 0; i < array.length; i++) {
            System.out.print( array[ i ] + "\t" ); // 通过 array 变量所存储的地址找到 堆内存中的数组后再根据 索引 访问相应位置的变量
        }
        System.out.println();

        Random rand = new Random();
        // 通过循环完成对数组的初始化
        for (int i = 0; i < array.length; i++) {
            // 通过 array 变量所存储的地址找到 堆内存中的数组后再根据 索引 为相应位置的变量赋值
            array[ i ] = rand.nextInt( 100 );
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print( array[ i ] + "\t" ); 
        }
        System.out.println();

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int[] another = array ;
        System.out.println( "数组变量 another 中存储的 '地址' 是: " + System.identityHashCode( another ) );

        System.out.println( another == array ); // 比较两个数组变量中存储的值是否相等 ( 数组变量中存储的是地址 )

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int[] first = { 10 , 20 , 30 }; // int[] first = new int[] { 10 , 20 , 30 };
        int[] second = { 10 , 20 , 30 }; // int[] second = new int[] { 10 , 20 , 30 };

        System.out.println( first == second );
        System.out.println( "数组变量 first 中存储的 '地址' 是: " + System.identityHashCode( first ) );
        System.out.println( "数组变量 second 中存储的 '地址' 是: " + System.identityHashCode( second ) );

    }

}
