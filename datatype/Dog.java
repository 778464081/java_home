
/**
 * 1、short 和 char 之间不能实现【自动类型转换】
 * 2、short 和 char 都可以【自动类型提升】为 数字范围较大 的类型 ( int 、long 、float 、double )
 */
public class Dog {

    public static void main( String[] args ) {

        // short : 16bit 
        short first = 97 ;
        System.out.println( first );
        // char second = first ; // 【编译失败】错误: 不兼容的类型: 从short转换到char可能会有损失
        int second = first ; // 本来是 short 类型的 first 变量中存储的数值会自动提升为 int 类型后再赋值给 second 变量
        System.out.println( second );

        // char : 16bit
        char third = 'a' ;
        System.out.println( third );
        // short fourth = third ; // 【编译失败】错误: 不兼容的类型: 从short转换到char可能会有损失
        int fourth = third ; // 本来是 char 类型的 third 变量中存储的数值会自动提升为 int 类型后再赋值给 fourth 变量
        System.out.println( fourth );

    }

}
