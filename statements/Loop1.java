
/**
 *基本结构:
 *    for( A ; B ; C ) {    D    }
 * A 用来声明并初始化变量
 * B 是一个逻辑表达式，用于决定循环是否执行
 * C 通常被称作 迭代部分 或 递进部分，用于实现对控制循环的变量的增加或减少等操作
 * D 表示循环体中要执行的语句 ( 就是要完成什么任务 )
 * 
 * 执行顺序:
 *    A ->  B ->  D -> C 
 *    B -> D -> C 
 *    ..............
 *    B
 */
public class Loop1 {

    public static void main(String[] args) {
        
        for ( int i = 0; i < 10 ; i++ ) {
            System.out.println( i );
        }

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 在 for 语句中声明并初始化的变量只能在 for 语句块内部使用
        for ( int i = 0 , j = 10 ; i < 10 && j > 0 ; i++  , j-- ) {
            System.out.println( "i = " + i + " , j = " + j );
        }

    }

}
