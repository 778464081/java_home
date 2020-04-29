
/*
 * 1、与 基本数据类型 对应的是 引用类型
 * 2、在基本数据类型的变量中存储的就是相应类型的数值
 * 3、在引用类型的变量中存储的是一个内存地址(通过这个地址可以找到真正的数据)
 */
public class Snake {

   public static void main( String[] args ) {

      int first = 100 ; // int 类型的变量 first 中直接存储了数值 100
      System.out.println( first );

      // 对于 main 方法的参数 args 来说就是一个 引用类型 的变量 (引用变量) 
      System.out.println( args ); // 所有引用变量中都存储了一个内存地址

      // 通过这个内存地址可以找到真正的数据所在的位置
      int n = args.length ; // 获取数组长度
      for( int i = 0 ; i < n ; i++ ) {
         System.out.println( args[ i ] ) ;
      }

   }

}

