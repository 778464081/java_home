
/**
 * 1、boolean 类型的数值占 1 Bit (二进制位) 【这是规范要求的】
 * 2、Java 中的 变量必须 在 初始化 之后才能使用
 * 3、Java 中没有 零表示假、非零即真 这一说
 * 4、char 类型的数值 占 16 Bit (二进制位)
 * 5、char 类型的取值 可以使用 '' 引起来的 字符、Unicode 编码、转义字符，也可以是 符合 char 数据范围的 正整数
 * 6、char 类型的取值范围是 \u0000 ~ \uFFFF 之间 ( 对应的正整数范围是 0x0000 ~ 0xffff )，其中 \u0000 表示一个空白字符
 */
public class Monkey {

    public static void main( String[] args ) {

        // 在 Java 语言中 boolean 类型的数值 占 1 Bit (二进制位) 【这是规范要求的，但是JVM可能会有自己的实现】
        boolean exists ; // 仅声明一个 boolean 类型的变量，但没有为它赋值

        // 与 C / C++ 语言不同，Java 中的 变量必须 在 赋值之后才能使用 ( 首次为某个变量赋值被称作 初始化 )
        // System.out.println( exists ); // 【编译失败】错误: 可能尚未初始化变量exists
        
        exists = true ; // 为 已经声明过的 exists 变量赋值
        System.out.println( exists );

        exists = false ; // 为 已经声明过的 exists 变量赋值
        System.out.println( exists );

        // exists = 0 ; // 【编译失败】: 不兼容的类型: int无法转换为boolean ( Java 中没有 零表示假、非零即真 这一说)

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        char ch1 = 'a' ;
        System.out.println( ch1 ); // a

        char ch2 = 97 ;
        System.out.println( ch2 ); // ?

        char ch3 = '\u8fa3' ;
        System.out.println( ch3 ); // 辣

        char ch4 = '\n' ; // 转义字符
        System.out.println( ch4 ); 

        System.out.println( "end" );

        // 在 Java 语言中 char 类型的数值 占 16 Bit (二进制位)
        char ch5 = '\u0000' ;  // \u0000 ~ \uFFFF
        System.out.println( ch5 ); // \u0000 表示一个空白字符，这个空白字符不是 空格 也不是 Tab 键产生的空白

        ch5 = '\uFFFF';
        System.out.println( ch5 ); 

    }

}
