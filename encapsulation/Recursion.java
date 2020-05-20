
public class Recursion {

    // 使用递归方式求 N 的阶乘
    public long factorial( long n ) {

        if( n < 0 ) {
            // 创建一个异常对象 ( RuntimeException 是一个异常类 )
            RuntimeException ex = new RuntimeException( "你丫数学是跟谁学的?负整数还有阶乘?" ); 
            throw ex ; // 使用 throw 抛出 异常对象
        }

        if( n == 0 || n == 1 ) {
            return 1L ; // 数学中规定 0！ 和 1！都是 1
        } else {
            // 一个方法内部调用了它自己
            return n * factorial( n - 1 ) ; // 整数 n  乘以 n - 1 的阶乘 就是 n 的阶乘
        }

    }

    public static void main(String[] args) {
        
        Recursion x = new Recursion();

        int n = 20 ;

        // main 调用 x 的 factorial 方法 求 n 的阶乘 并返回 n 的阶乘
        long f = x.factorial( n ); 
        // factorial( 6 ) -> 6 * factorial( 5 ) -> 5 * factorial( 4 ) -> 4 * factorial( 3 ) -> 3 * factorial( 2 ) -> 2 * factorial(1)
        //                          6 * 120               <= 5 * 24                 <= 4 * 6                  <= 3 * 2                   <= 2 * 1

        System.out.println( n + " 的阶乘等于 " + f );

    }

}
