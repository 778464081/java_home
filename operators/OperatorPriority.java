
/**
 * 1、对于运算符优先级来说，我们建议大致掌握几个大的分类的优先级，比如先乘除后加减
 * 
 * 2、但是不建议在运算符优先级这里花费太多时间，不划算。
 * 
 * 3、【当无法准确确定运算符优先级时，可以使用 ( ) 提升某个表达式的优先级】
 * 
 */
public class OperatorPriority {

    public static void main(String[] args) {
        
        int a = 5 - 2 * 3 ;
        System.out.println( a );

        int b = 5 >> 1 * 2 ;
        System.out.println( b );

        int c = ( 5 >> 1 ) * 2 ; // 当无法准确确定运算符优先级时，可以使用 ( ) 提升某个表达式的优先级
        System.out.println( c );

        int d = 100 ;
        System.out.println( d++ + ++d + d-- + --d + --d+ ++d + d++ - --d - d-- ); // 无聊

    }

}
