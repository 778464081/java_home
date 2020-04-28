
/*
 * 1、如何定义变量、如何确定变量类型
 * 2、变量的命名规则: 可以以 $ 或 _ 或 英文字符 为前缀，其后可以跟 $ 、_ 、英文字符 、阿拉伯数字
 *    如果变量名称中只有一个单词，则该单词所有字母全部小写
 *    如果变量名称中包含多个单词，则第一个单词全部小写，从第二个单词开始每个单词首字母大写
 * 3、int 、long 、double 是不同的数据类型，它们所表示的数据范围是不同的
 * 4、等号 ( = ) 表示赋值运算符，运算规则是 从右向左，表示将 等号右边的结果 赋值 给 等号左边的变量
 */
public class Tiger {

   public static void main( String[] args ) {

      // 获取当前时间(从历元开始至现在所经历的毫秒值)
      var millis = System.currentTimeMillis(); // 尽管支持 var 但不建议使用 
      System.out.println( millis );

      // int time = System.currentTimeMillis(); // 不兼容的类型: 从long转换到int可能会有损失
      long time = System.currentTimeMillis();
      System.out.println( time );

      double ms = System.currentTimeMillis();
      System.out.println( ms );
     
   }

}

