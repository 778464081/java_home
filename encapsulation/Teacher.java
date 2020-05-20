// 一个类中至多出现一个 package 语句
package cn.edu.ecut ; // package 语句必须出现在一个类的首行 ( 除了注释和空白之外 )

// 包名称 全部小写 ，比如 ecut ( 本质上对应的是 ecut 目录 )
// 多个层次之间使用 圆点 隔开，比如 cn.edu.ecut ( 本质上对应的是 cn/edu/ecut 目录 )
// 包名不可以以 数字 为开头，比如 0520 、ecut.0520 就是错误的包名

public class Teacher {

    // 在命令行编译 带有 package 声明的 源代码 时，需要使用
    // javac -d 目标目录 源文件
    // 其中  -d 用于指定编译后的 字节码的存放位置 ，确切地说是在哪个目录中创建编译后的字节码对应的包
    // 比如将 源文件编译后的包结构创建到当前目录可以使用 : javac -d . Teacher.java 

    public static void main(String[] args) {
        System.out.println( "hello , teacher ." );
    }

    // 在命令行执行编译后的字节码，可以使用
    // java 包名.类名
    // 比如 java cn.edu.ecut.Teacher
    // 必须是在 最顶层包 所在的 目录时，才可以通过 "java 包名.类名" 的形式来执行相应的字节码

}
