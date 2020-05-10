
public class Loop2 {

    public static void main(String[] args) {

        
        // while ( 判断 ) {
        //      循环语句
        //      迭代
        // }

        int i = 10 ; // 声明变量并初始化
        while ( i > 0 ) { // 在 while 语句中之后的 ( ) 内执行判断
            System.out.println( "i = " + i ); // 这个输出语句相当于循环要完成的操作
            i-- ; // 迭代部分 ( 实现变量的变化，比如 变量增长 或 减少 )
        }

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int j = 0 ; // 初始化
        while( j++ < 10 ){ // 迭代 和 判断
            System.out.println( "j = " + j );  // 循环要完成的操作
        }

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int a = 100 ;
        int b = 200 ;
        System.out.println( "a = " + a + " , b = " + b );
        while( a++ < b-- ); // 没有循环体
        System.out.println( "a = " + a + " , b = " + b );
        
    }

}
