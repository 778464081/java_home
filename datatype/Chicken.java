
/**
 * 1、表示数字的基本数据类型的【自动类型提升】
 * 2、按照能够表示的数字范围从小到大排列依次是 byte 、 short 、int 、long 、float 、double 
 * 3、将 数字范围较小的类型的变量的值 赋值给 数字范围较大的类型的变量 时，会发生【自动类型提升】
 */
public class Chicken {

    public static void main( String[] args ) {

        // 8bit      16bit        32bit        64bit       32bit            64bit
        // byte --> short -->    int    -->   long  --->  float    --->  double 

        // 声明一个 byte 类型的、名称为 first 的 变量并为其赋值
        byte first = 100 ; // 100 对应的二进制形式刚好是用 8 个二进制位所能表示的
        System.out.println( first );

        short second = first ; // 本来是 byte 类型的 first 变量中存储的数值 会提升为 short 类型
        System.out.println( second );

        // int third = second ; // 本来是 short 类型的 second 变量中存储的数值 会提升为 int 类型
        int third = first ; // 本来是 byte 类型的 first 变量中存储的数值 会提升为 int 类型
        System.out.println( third );

        long fourth = first ; // 本来是 byte 类型的 first 变量中存储的数值 会提升为 long 类型
        System.out.println( fourth );

        float fifth = first ; // 本来是 byte 类型的 first 变量中存储的数值 会提升为 float 类型
        System.out.println( fifth );

        double sixth = first ; // 本来是 byte 类型的 first 变量中存储的数值 会提升为 double 类型
        System.out.println( sixth );

    }

}
