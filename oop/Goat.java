
public class Goat {

    // 在声明 类变量时，直接使用 赋值表达式 可以为 类变量指定 初始值 ( initial value )
    public static String school = "大肥羊学校" ; // 类变量 ( static 表示属于类的、与类相关的 )

    static {
        // System.out.println( Goat.school ) ; // 在 static 代码块中输出已经初始化的 school 变量的值
        System.out.println( school ) ; // 同一个类中可以省略类名
    }

    public static void main(String[] args) { // 一个带有 main 方法类是可以直接运行的，这种类被称作 启动类
        // main 方法中什么都不写
    }

}