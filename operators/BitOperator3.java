
/**
 * 位运算符 - 移位
 * 向右 或 向左移位时，移动的位数 如果是 负数、零、正数 ，分别什么含义?
 * 对于一个 int 类型的数值起来说，向左 或 向右 移动 33 位 其结果是什么? 为什么?
 * 【这个问题不做要求，仅当做扩展题目，有兴趣的同学可以研究】
 */
public class BitOperator3 {

    public static void main(String[] args) {
        
        final int x = 5 ; // 0b00000000_00000000_00000000_00000101
        System.out.println( x >> 0 ); // 5 why ?
        System.out.println( x >> -1 ); // 0  why ?
        System.out.println( x >> 36 ); // 0   why ?
        System.out.println( x >> -32 ); // 5  why ?

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        final int m = -5 ; // 0b1111_1111_1111_1111_1111_1111_1111_1011
        System.out.println( m >> 0 ); // -5 why ?
        System.out.println( m >> -1 ); // -1  why ?
        System.out.println( m >> 36 ); // -1    why ?
        System.out.println( m >> -32 ); // -5   why ?

    }

}
