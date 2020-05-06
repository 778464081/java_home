
/**
 * 关系运算符 ( 比较运算符 ) : == 、!= 、> 、< 、>= 、<=
 */
public class Relation {

    public static void main(String[] args) {
        
        double x = 3.14 ;
        int y = 100 ;
        double z = 3.14 ;

        System.out.println( x == y ); // false
        System.out.println( x == z ); // true

        System.out.println( "~ ~ ~ ~ ~ ~" );

        System.out.println( x != y ); // true
        System.out.println( x != z ); // false

        System.out.println( "~ ~ ~ ~ ~ ~" );

        System.out.println( x < y ); // true
        System.out.println( x > z ); // false

        System.out.println( "~ ~ ~ ~ ~ ~" );

        System.out.println( x <= y ); // true
        System.out.println( x >= z ); // true

        System.out.println( "~ ~ ~ ~ ~ ~" );

        System.out.println( 3.14 == 3.14F ); // false 【为什么？】

    }

}
