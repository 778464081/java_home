
/**
 * 1、方法的 返回类型 必须跟方法所返回的 值的类型 相匹配
 * 2、使用 return 语句可以导致一个正在执行的方法立即结束
 * 3、使用 return 语句可以将 一个方法的栈桢 中的数据 带出到 方法的调用者
 */
public class Dog {

    // 修饰符  返回类型  方法名称 ( 参数列表 )
    public char upper( char x ){
        char ch = x ;
        if( x >= 'a' && x <= 'z' ) {
            int y = x ^ 32 ; // int y = x - 32 ;
            ch = (char) y ;
        }
        return ch ;
    }

    // 判断一个整数是否是质数
    public boolean isPrime( int n ) {
        if( n <= 1 ){
            System.out.println( "你的数学是体育老师的媳妇的表妹教的?" );
            return false ; // 直接使用 return 语句返回 false 导致方法立即结束
        }

        boolean result = true ; // 假设参数 n 是个质数

        for (int i = 2 ; i < n ; i++ ) {
            if( n % i == 0 ) { // 尝试推翻假设
                result = false ; // 推翻假设
                break ; // 跳出整个循环
            }
        }
        // return 可以导致一个正在执行的方法立即结束 ( 该方法的 栈桢 从 栈 中弹出 )
        // 使用 return 语句 可以将 数据 ( 可能是变量的值 或 直接量 ) 从 当前方法的 栈桢 中 带出给 方法的调用者
        return result ; // 返回判断结果
    }

    public static void main(String[] args) {

        Dog d = new Dog();

        char x = 'a' ;
        System.out.println( "x : " + x );

        char y = d.upper( x );
        System.out.println( "y : " + y );

        boolean z = d.isPrime( 12 ); // 【 main 方法】 调用 【 d 】 的 【 isPrime方法 】 【判断 12 是否是个质数】 【返回判断结果】
        System.out.println( "z : " + z );

    }

}
