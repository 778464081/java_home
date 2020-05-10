
/**
 * 1、continue 语句用于实现 略过 循环语句中 本轮操作的后续语句，直接进入下一轮操作
 * 2、continue 默认针对它所在的循环有效 ( 就是 离 continue 语句最近的循环 )
 * 3、break 语句用于跳出循环语句块 ( 整个循环会结束 )
 * 4、break 默认针对它所在的循环有效 ( 就是 离 break 语句最近的循环 )
 */
public class Loop6 {

    public static void main(String[] args) {

        for( int i = 1 ; i < 10 ; i++ ) {
            if( i == 2 ) {
                // 略过本次循环后续语句直接进入下次
                continue ; // 整个循环并没结束，而是略过本轮中后续操作直接进入下一轮操作
            }
            System.out.print( i + " " ); // 循环当中输出的内容不换行
        }
        System.out.println(); // 等到循环执行结束后再输出换行符

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        for( int i = 1 ; i < 10 ; i++ ) {
            if( i == 2 ) {
                break ; // 跳出循环语句块，整个循环结束
            }
            System.out.print( i + " " ); // 循环当中输出的内容不换行
        }
        System.out.println(); // 等到循环执行结束后再输出换行符

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        for( int i = 1 ; i < 10 ; i++ ){
            System.out.print( i + ": " );
            for( int j = 1 ; j < 10 ; j++ ) {
                if( i == 5 && j == 5 ) {
                    continue ;
                }
                System.out.print( j + " " );
            }
            System.out.println();
        }

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        for( int i = 1 ; i < 10 ; i++ ){
            System.out.print( i + ": " );
            for( int j = 1 ; j < 10 ; j++ ) {
                if( i == 5 && j == 5 ) {
                    break ;
                }
                System.out.print( j + " " );
            }
            System.out.println();
        }

    }

}
