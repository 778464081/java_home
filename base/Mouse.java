
// 类名可以以 $ 或 _ 或 英文字符 为前缀，其后可以跟 $ 、_ 、英文字符 、数字 等
// 类名中每个单词首字母一律大写，比如 Mouse 
public class Mouse {

   // 修饰符 可以理解成 汉语 中的形容词，比如 一个 温柔的、漂亮的 小女孩
   // 这里的 static 和 public 谁在前谁在后，跟 温柔的、漂亮的 谁在前在后没什么区别
   // void main( String[] ) 表示一个方法的 返回类型、方法名称、参数类型，必须按照顺序书写
   // main 之后的 ( ) 内部 String[] 表示参数类型，canShu 是参数名称 ( 名称可以是任意的符合命名规则的名称 )
   static public void main( String[] canShu ) {

      // 在 void main () 之后的  { } 内部所书写的就是这个方法的方法体(也就是这个方法所要完成的操作)
      System.out.println( "我是一只孤独饥饿的小老鼠" );

   }
}

