
/**
 * 三目运算符 ( 也叫 三元运算符 或 条件运算符 ) 
 * 
 *      expression  ? first : second 
 * 
 *      如果 expression 返回结果为 true 则取 first 
 *      如果 expression 返回结果为 false 则取 second
 * 
 * 双目运算符:
 *      a + b 、a - b 、......
 * 
 * 单目运算符:
 *       ~a 、-5 、+5  
 * 
 */

import java.util.Random;

public class Condition {

    public static void main(String[] args) {

        // 创建一个 Random 类的实例并将该实例的内存地址赋值给 rand 变量
        Random rand = new Random(); // 这个先用起来，暂不详细研究

        // 通过 Random 类中定义的实例方法 nextBoolean 来产生伪随机数
        boolean x = rand.nextBoolean() ; // 每次调用 nextBoolean 都会产生一个随机数
        System.out.println( x );
        System.out.println( x ? "真的" : "假的" ) ;

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        byte a = 100 ;
        short b = 200 ;
        // variable = expression  ? first : second ;
        // 如果期望通过一个变量接受三目运算符产生的结果，则这个变量 variable 的类型 必须跟 first 和 second 两个值的类型兼容
        short c = a < b ? a : b ;
        System.out.println( c );

    }

}
