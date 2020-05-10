
/**
 * 【 将一个 十进制的正整数 转换成 八进制 形式 】
 *    除八取余，除尽为止，(余数)尾首相连
 */
public class Loop5 {

    public static void main(String[] args) {

       final int x = 100 ; // 需要转换的十进制正整数
       final int b = 8 ; // 基数

       String target = "" ; // 初始化

       /*
       int y = x ;  // 初始化
       while( y != 0 ) { // 判断
            int z = y % b ; // 循环需要完成的操作
            s = z + s ;  // 循环需要完成的操作
            y /= b ; // 迭代 ( 让控制循环的变量变起来 )
       }
       */

      for ( int y = x ; y != 0 ; y = y / b ) {
        target = ( y % b ) + target ; 
      }

      System.out.println( x + " 的 " + b + " 进制形式是 " + target );

    }

}
