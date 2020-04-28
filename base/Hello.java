
// public 是修饰符，可以修饰 类(class) 、方法( method ) 、字段( field )
// class 是用来声明 类 的关键字,在 class 之后紧跟的 Hello 就是类的名称
// 被 public 修饰的 class 的名称 必须与相应的 .java 文件名称保持一致
public class Hello {

   // public 是个修饰符，被 public 修饰的方法表示方法是公开的
   // static 是个修饰符，被 static 修饰的方法是属于类的
   // void 是 方法的返回类型，表示方法不需要返回任何数据
   // main 是方法名称，在 JVM 运行一个类中的代码时，这个 main 方法就是一个入口
   // main 之后的 ( ) 内部是参数列表，其中的 args 是参数名称，String[] 是参数的类型
   // String 是 java.lang 包中的一个非常常用的类(笔试、面试也经常遇到)
   public static void main( String[] args ) {

     // System 也是 java.lang 包中的一个常用类
     // out 是 System 类中的一个属于类的变量(称作类变量)
     // println 是 out 对应的类中的一个方法，用于输出数据并换行
     System.out.println( "Hello" );

   }
}

