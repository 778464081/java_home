
public class Rabbit {

   public static void main( String[] args ) {
      // args 是一个 String 类型的数组 ( String[] 表示 String 数组 )
      System.out.println( "参数个数:" );
      System.out.println( args.length ); // 使用 length 来获取数组长度

      for( int i = 0 ; i < args.length ; i++ ) {
         System.out.println( args[ i ] ); // 与 C / C++ 相同，通过 数组名称 和 下标 来获取元素
      }
   }

}

