
/**
 * 逻辑运算符
 * 4、逻辑与 &
 * 5、逻辑或 |
 * 6、逻辑异或 ^
 */
public class Logic2 {

    public static void main(String[] args) {
        
        boolean first = true ;
        boolean second = false ;
        boolean third = true ;
        boolean fourth = false ;

        System.out.println( first | second ) ; // true 两个值中只要有一个为 true 结果就为 true
        System.out.println( first | third ) ; // true
        System.out.println( second | fourth ) ; // false

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        System.out.println( first & second ) ; // false 
        System.out.println( first & third ) ; // true 两个值中都为 true 时结果才是 true
        System.out.println( second & fourth ) ; // false

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
        System.out.println( first ^ second ) ; // true 两个逻辑值不相同时结果为 true
        System.out.println( first ^ third ) ; // false
        System.out.println( second ^ fourth ) ; // false

    }

}
