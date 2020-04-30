
/**
 * 1、在 Java 语言中，如果遇到 范围比 int 小的类型发生运算时，首先需要提升为 int 类型后再运算
 * 2、在 Java 语言中，两个 float 类型的变量相加后仍然是 float 类型 ( Java 8  和 Java 11 测试通过 )
 * 3、在 Java 语言中，一个 float 类型的数值 与 一个 double 类型的数值 发生运算时，float 数值首先提升为 double 类型后再运算
 */
public class Pig {

    public static void main( String[] args ) {

        byte first = 100 ;
        byte second = 50 ;

        // byte third = first + second ; // 【编译失败】错误: 不兼容的类型: 从int转换到byte可能会有损失
        // 两个 byte 类型的 变量 相加时，会首先自动类型提升为 int 类型，再运算
        int third = first + second ; 
        System.out.println( third );

        short fourth = 100 ;
        short fifth = 200 ;

        // short sixth = fourth + fifth ; // 【编译失败】错误: 不兼容的类型: 从int转换到short可能会有损失
        // 两个 short 类型的 变量 相加时，会首先自动类型提升为 int 类型，再运算
        int sixth = fourth + fifth ; 
        System.out.println( sixth );

        // byte result = first + fourth ; // ???
        // short result = first + fourth ; // ???
        // int result = first + fourth ; // ???
        // long result = first + fourth ; // ???

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        float one = 3.14F ;
        float two = 3.14F ;

        float three = one + two ; // 注意: 这里至少在 Java 8 中测试是通过的
        System.out.println( three );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        double four = 3.1415926 ;

        // float five = one + four ; // 【编译失败】错误: 不兼容的类型: 从double转换到float可能会有损失
        double five = one + four ; 
        System.out.println( five );

    }

}
