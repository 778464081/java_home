import java.util.Random;

/**
 * 1、静态初始化
 *       声明数组时直接完成对数组的初始化操作就是静态初始化
 *       int[] first = { 10 , 20 , 30 };
 * 
 *       静态初始化时可以使用 数组常量 ( 只有在 声明数组 时才可以使用 )
 * 
 * 2、动态初始化
 *       声明数组时为数组中各个变量开辟内存空间并赋予【默认值】
 * 
 *          int[] array = new int[ 5 ] ;
 * 
 *          用来存放 原生类型数据 的数组中各个变量的默认值都是 零 :
 *               byte : 0 
 *               short : 0 
 *               int : 0
 *               long : 0
 *               float : 0.0f 
 *               double : 0.0 
 *               char : \u0000
 *               boolean : false
 * 
 *         用来存放 引用类型数据 的数组中各个变量的默认值都是 null 。
 * 
 *       如果期望将一组数据放入到数组中，需要在声明数组之后显式为各个变量赋值，第一次显式为数组中各个变量赋的值就是【初始值】
 * 
 */
public class Array3 {

    public static void main(String[] args) {

        // 数组常量 只有在 声明数组 时才可以使用
        int[] first = { 10 , 20 , 30 }; //【静态初始化】
        for (int i = 0; i < first.length; i++) {
            System.out.print( first[ i ] + "\t" );
        }
        System.out.println();

        // 对于已经声明过的 数组变量 不可以再使用 数组常量 为其赋值
        // first = { 100 , 200 , 300 }; // 错误: 非法的表达式开始

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int[] second = new int[] { 1 , 3 , 5 , 7 , 9 } ; //【静态初始化】
        for (int i = 0; i < second.length; i++) {
            System.out.print( second[ i ] + "\t" );
        }
        System.out.println();

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 声明数组
        int[] third = new int[ 5 ];  // 开辟内存空间并赋予默认值
        for (int i = 0; i < third.length; i++) {
            System.out.print( third[ i ] + "\t" );
        }
        System.out.println();

        Random rand = new Random();
        // 通过循环完成对数组的初始化
        for (int i = 0; i < third.length; i++) {
            third[ i ] = rand.nextInt( 100 );
        }
        
        for (int i = 0; i < third.length; i++) {
            System.out.print( third[ i ] + "\t" );
        }
        System.out.println();

    }

}
