
import java.util.Scanner;

/**
 * 1、基本结构
 *        do { } while () ;
 *        注意最后的分号
 * 2、while 循环 和 do...while 循环都可以在不明确循环次数的前提下完成循环操作
 * 3、while 循环会先执行 判断 ( 因为 while 关键字之后就是 逻辑判断表达式 )
 * 4、do...while 循环会首先执行 do 和 while 之间的代码，再执行之后才进行判断
 */

public class Loop3 {

    public static void main(String[] args) {

        // 创建一个用于读取用户输入数据的扫描器
        Scanner s = new Scanner( System.in );

        int x = -1 ; // 初始化
        do {
            System.out.println( "请输入 0 到 100 之间的数字:" );
            x = s.nextInt(); // 读取用户在控制台中输入的整数
            System.out.println( "您输入的是 " + x );
         } while ( x < 0 || x > 100 ) ;

        System.out.println( "输入正确" );

         s.close();

    }

}
