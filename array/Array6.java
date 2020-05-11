
/**
 * 1、数组就是用来容纳一组相同类型的变量的
 * 2、数组内部容纳的变量是基本数据类型还是引用类型，取决于实际需要
 * 3、如果某个数组内部容纳的变量又是数组类型，则这个数组是个多维数组
 */
public class Array6 {

    public static void main(String[] args) {

        char[] first = { '青' , '海' , '长' , '云' , '暗' , '雪' , '山' } ;
        System.out.println( first ); // 不是输出 "类型@哈希码" 形式 而是将 char 数组中的所有字符直接输出
        System.out.println( System.identityHashCode( first ) );

        char[] second = { '孤' , '城' , '遥' , '望' , '玉' , '门' , '关' };
        System.out.println( second ); 
        System.out.println( System.identityHashCode( second ) );

        char[] third = { '黄' , '沙' , '百' , '战' , '穿' , '金' , '甲' } ;
        System.out.println( third ); 
        System.out.println( System.identityHashCode( third ) );

        char[] fourth = { '不' , '破' , '楼' , '兰' , '终' , '不' , '还' } ;
        System.out.println( fourth ); 
        System.out.println( System.identityHashCode( fourth ) );

        // 数组常量 { first , second , third , fourth } 是由 四个 地址 组成的数组
        // 变量 x 所对应的数组是一个存放 数组 的 数组
        char[][] x = { first , second , third , fourth } ;

        /*
        char[][] x =  {
                                { '青' , '海' , '长' , '云' , '暗' , '雪' , '山' } ,
                                { '孤' , '城' , '遥' , '望' , '玉' , '门' , '关' } ,
                                { '黄' , '沙' , '百' , '战' , '穿' , '金' , '甲' } ,
                                { '不' , '破' , '楼' , '兰' , '终' , '不' , '还' }
                            };
        */

        // 遍历二维数组
        for( int i = 0 ; i < x.length ; i++ ) {
            // 取 x 对应的数组中的元素
            char[] e = x[ i ];
            // 处理获取到的元素(是个数组)
            for( int j = 0 ; j < e.length ; j++ ) {
                char ch = e[ j ] ;
                System.out.print( ch + "\t" );
            }
            System.out.println();
        }

        /*
        // 遍历二维数组
        for( int i = 0 ; i < x.length ; i++ ) {
            // 处理获取到的元素(是个数组)
            for( int j = 0 ; j < x[ i ].length ; j++ ) {
                char ch = x[ i ][ j ] ;
                System.out.print( ch + "\t" );
            }
            System.out.println();
        }
        */

    }

}
