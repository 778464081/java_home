
/**
 * 1、搞清楚 原码 、反码 、补码 【计算机组成原理】
 * 2、搞清楚 浮点数 的存储结构: float 和 double 都搞清楚【计算机组成原理】
 */
public class Panda {

    public static void main( String[] args ) {

        double first =1234567.89 ;
        System.out.println( first );

        int second = (int) first ;
        System.out.println( second );

        short third = (short) first ;
        System.out.println( third );

        /*
        // float first = Float.MAX_VALUE ;
        float first = 3.14F ;
        System.out.println( first );

        long second =  (long)first ;
        System.out.println( second );
        */
        
    }
}
