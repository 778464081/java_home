
/**
 * 逻辑运算符
 * 1、逻辑与 &&
 * 2、逻辑或 ||
 * 3、逻辑非 !
 */
public class Logic1 {

    public static void main(String[] args) {
        
        boolean first = true ;
        boolean second = false ;
        boolean third = true ;
        boolean fourth = false ;

        System.out.println( first || second ) ; // 两个值中只要有一个为 true 结果就为 true
        System.out.println( first || third ) ; 
        System.out.println( second || fourth ) ; 

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        System.out.println( first && second ) ; 
        System.out.println( first && third ) ; // 两个值中都为 true 时结果才是 true
        System.out.println( second && fourth ) ; 

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
        System.out.println( !first ) ; 
        System.out.println( !second ) ; 

    }

}
