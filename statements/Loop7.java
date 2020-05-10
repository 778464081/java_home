
/**
 * 1、使用 标签(label) 标识循环语句块
 * 2、在 continue 语句 和 break 语句中可以使用 标签( label ) 来指定针对那层循环
 */
public class Loop7 {

    public static void main(String[] args) {

        outer:for( int i = 1 ; i <= 5 ; i++ ){
            System.out.print( i + ": " );
            inner:for( int j = 1 ; j <= 5 ; j++ ) {
                if( i == 3 && j == 3 ) {
                    continue inner ; // 在 continue 语句中可以使用 标签
                }
                System.out.print( j + " " );
            }
            System.out.println();
        }

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        outer:for( int i = 1 ; i <= 5 ; i++ ){
            System.out.print( i + ": " );
            inner:for( int j = 1 ; j <= 5 ; j++ ) {
                if( i == 3 && j == 3 ) {
                    continue outer ; // 在 continue 语句中可以使用 标签
                }
                System.out.print( j + " " );
            }
            System.out.println();
        }

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        outer:for( int i = 1 ; i <= 5 ; i++ ){
            System.out.print( i + ": " );
            inner:for( int j = 1 ; j <= 5 ; j++ ) {
                if( i == 3 && j == 3 ) {
                    break inner ; // 在 break 语句中可以使用 标签
                }
                System.out.print( j + " " );
            }
            System.out.println();
        }

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        outer:for( int i = 1 ; i <= 5 ; i++ ){
            System.out.print( i + ": " );
            inner:for( int j = 1 ; j <= 5 ; j++ ) {
                if( i == 3 && j == 3 ) {
                    break outer ; // 在 break 语句中可以使用 标签
                }
                System.out.print( j + " " );
            }
            System.out.println();
        }

    }

}
