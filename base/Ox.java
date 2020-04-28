
// 文件 Ox.java 是程序员编写的【源代码】
// 编译: javac Ox.java
// 源代码经过 javac 命令编译后产生的 Ox.class 文件被称作【字节码】
// 运行: java Ox
// 通过 java 命令可以启动一个 JVM ，在 JVM 中运行的是 字节码
// 另外在 Java 11 中支持采用 java Ox.java 的形式完成 编译、运行 (但不会产生字节码文件) 
public class Ox {

   public static void main( String[] args ) {

      System.out.println( "当前时间是:" );
      // 在控制台中输出当前时间
      // ( 是一个数字，这个数字表示从 历元( Epoch ) 到 当前时刻 所经历的毫秒数 )
      System.out.println( System.currentTimeMillis() );

   }

}

