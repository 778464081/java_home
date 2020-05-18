
/**
 * 1、一个带有 main 方法类是可以直接运行的，这种类被称作 启动类
 * 2、首次【主动使用】一个类时，将导致该类被初始化，类中的类变量也将初始化
 * 3、所谓【主动使用】一个类包括很多情况，比如这里直接运行一个启动类，或者创建一个类的对象
 * 4、当一个类被初始化后即可反复使用，不会再次执行初始化操作【除非该类被卸载后重新加载】
 * 5、static 代码块仅在首次主动使用一个类时才执行一次
 */
public class Sheep {

    public static String school ; // 类变量 ( static 表示属于类的、与类相关的 )

    // 在 static 修饰的代码块中可以完成对 类变量 的初始化
    static {
        System.out.println( "默认值: " + school ); // 因为在此之前从来没有为 school 主动赋值
        // Sheep.school = "大肥羊学校" ; // 首次为 school 主动赋值就是对该变量的初始化
        school = "大肥羊学校" ; // 同一个类中可以省略类名
        System.out.println( "初始值: " + school );
    }

    public static void main(String[] args) { // 一个带有 main 方法类是可以直接运行的，这种类被称作 启动类
        // main 方法中什么都不写
    }

}