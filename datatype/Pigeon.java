
/**
 * 1、两个 char 类型的取值 是可以相加的，加完之后是个 正整数
 * 2、byte 、short 、char 如果混合运算则会首先提升为 int  
 * 3、boolean 类型取值 不会自动类型提升，也不参与类型转换
 */
public class Pigeon {

    public static void main(String[] args) {

        char first = 'A' ; // 65
        char second = 'B' ; // 66

        // char result = first + second ; // 错误: 不兼容的类型: 从int转换到char可能会有损失
        int result1 = first + second ; // 自动类型提升
        System.out.println( result1 );

        short third = 97 ;
        int result2 = first + third ; // 自动类型提升
        System.out.println( result2 );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        boolean b = true ;
        boolean c = false ;
        // int d = b + c ; // 错误: 二元运算符 '+' 的操作数类型错误
        // byte x = b ; // 错误: 不兼容的类型: boolean无法转换为byte
        
    }

}
