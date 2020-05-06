
/**
 * 赋值运算符 ( = ) 的运算规则是 从右到左
 */
public class Assign {

    public static void main(String[] args) {
        
        int x ; // 声明一个名称为 x 的变量
        
        x = 0b0111_1000 ;// 以 二进制 形式书写直接量
        System.out.println( x );

        x = 077 ; // 以 八进制 形式书写直接量
        System.out.println( x );

        x = 100 ; // 将 100 赋值给 x 变量
        System.out.println( x );

        x = 0xFF ; // 以 十六进制 形式书写直接量
        System.out.println( x );

    }

}
