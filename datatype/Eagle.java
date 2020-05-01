
/**
 * 1、自动类型提升必须满足的条件: 
 *          两种类型兼容
 *          目标类型大于源类型
 * 2、【 近"大"者"大" 】
 *        当 数字范围较小的类型的变量的值 与 数字范围较大的类型的变量值 混合运算时，
 *        较小范围类型的值 会首先提升为 较大范围类型 然后再参与运算
 */
public class Eagle {

    public static void main( String[] args ) {

        byte first = 100 ;
        short second = 2000 ;
        int third = 30000 ;
        long fourth = 400000L ; // long 类型的数值之后加上 L 或 l (要养成习惯)

        // first 变量的值 和 second 变量的值 在加法运算之前都自动提升为 int
        int result1 = first + second ; // 自动类型提升: 两种类型兼容、目标类型大于源类型
        System.out.println( result1 );

        // second 变量的值 自动提升为 int 后再执行加法操作
        int result2 = second + third ; // 自动类型提升
        System.out.println( result2 );

        // third 变量的值 首先自动提升为 long 类型后再与 fourth 的指执行加法运算
        long result3 = third + fourth ; // 自动类型提升
        System.out.println( result3 );

        // 一个 float 类型的值 和 一个 double 类型的值 混合运算的结果是 double

    }

}
