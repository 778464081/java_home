
/**
 * 1、数组: 用于批量声明同种类型的多个变量
 * 2、数组变量 、数组类型 、数组元素、数组长度 、下标(索引) 、数组常量
 * 3、通过 数组变量名称[ 下标 ] 可以对 数组中指定位置的元素进行 取值 或 赋值操作
 * 4、遍历数组
 */
public class Array1 {

    public static void main(String[] args) {
        
        // first 是一个数组类型的变量，即【数组变量】
        // int[] 是 first 变量的类型，即【数组类型】
        // 数组中所存放的每个数值，比如 10 , 20 , 30 , 40 , 50 等 都是数组中的【元素】
        int[] first = { 10 , 20 , 30 , 40 , 50 }; // Java 建议采用的风格
        // Java 语言中 原点运算符 可以理解为 汉语 中的 "的" ，比如 first.length 可以读成 first 的 length
        System.out.println( first.length ); // 通过 length 属性可以获取 【数组长度】 ( 数组中可以容纳的最大元素个数 )
        System.out.println( first[ 0 ] ); // 数组【下标(索引)】从零开始 
        System.out.println( first[ 1 ] );  // 可以通过【 数组变量名称[ 下标 ] 】来获取指定位置的元素
        System.out.println( first[ 2 ] );
        System.out.println( first[ 3 ] );
        System.out.println( first[ 4 ] );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        first[ 3 ] = 100 ; // 可以通过【 数组变量名称[ 下标 ] 】来为指定位置的元素赋值
        first[ 2 ] = 200 ;

        // 【遍历数组】: 将数组中的每个元素按照一定顺序依次访问一遍
        for (int i = 0 ; i < first.length; i++) {
            System.out.print( first[ i ] + "\t" ); // 可以通过【 数组变量名称[ 下标 ] 】来获取指定位置的元素
        }
        System.out.println();

        // 在 声明数组后，可以通过 { } 形式直接为 数组变量 赋值，这里以 { } 形式书写的内容就是【数组常量】
        // { 10 , 20 , 30 , 40 , 50 , 60 } 就是所谓的数组常量
        int second[] = { 10 , 20 , 30 , 40 , 50 , 60 }; // C/C++ 惯用的风格
        System.out.println( second.length );

        for (int i = 0 ; i < second.length; i++) {
            System.out.print( second[ i ] + "\t" );
        }
        System.out.println();

    }

}
