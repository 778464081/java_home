
/**
 * 【 将一个 十进制的正整数 转换成 二进制 形式 】
 *   除二取余，除尽为止，(余数)尾首相连
 * 
 * 【将一个 十进制的正整数 转换成 八进制 形式 】
 */
public class Loop4 {

    public static void main(String[] args) {

        String s = "" ;
        s = "abc" ;
        System.out.println( "s : " + s );
        s =  "123" + s ; // 注意 s = "123" + s ; 与 s = s + "123" ; 的区别
        System.out.println( "s : " + s );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int x = 25 ;
        String binary = "" ;
        final int p = x ;

        while( x != 0 ){
            int y = x % 2 ; // 整除二取余数
            binary = y + binary ; // 这里的 + 相当于 字符串连接符
            // System.out.println( binary ); // 通过输出语句验证每次循环产生内容
            // 对 x 变量的取值整除二取商，并将商赋值到 x 变量中
            x /= 2 ; // x = x / 2 ;
            // System.out.println( x ); // 通过输出可以查看 x 变量中取值的变化过程
        }

        // System.out.println( "x = " + x ); // 验证 x 已经变成 0 ( 就是口诀中的 除尽为止 )
        System.out.println( p + " 的二进制形式是: " + binary );

        // 如果期望 二进制 形式 是 32 位，可以考虑在 二进制字符串前面补充 字符 0 

    }

}
