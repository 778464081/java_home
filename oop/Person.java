
/**
 * 1、在 Java 语言中 ，【 对象 ( object ) 】 与 【 实例 ( instance ) 】都是指通过 "new 构造()" 方式创建出来的 对象。
 *        [类] 是 某一种事物的抽象，比如 人 、动物 、西瓜 、候
 *        [对象] 是 某种事物的一个具体的 [个体]，比如 一个名字叫做张三丰的人 、你女朋友给你买的西瓜 、一个敢于大闹天宫的猴子
 * 
 * 2、字段( field )本质上就是一个 [变量] ，是属于类中的一个成员( member )，因此也称作 【成员变量】
 *        某一种事物的每个个体都具有的特征可以使用类中的 字段 来表示，比如 人 的 姓名、年龄、性别 等
 *       
 * 3、属于 [个体] 的字段被称作 【实例变量】 ( 也可以称作 实例字段 )
 *         在一个类中可以声明属于其实例的字段，比如: 在 Person 类中声明的 name 变量
 *         实例变量 是没有 static 修饰符修饰的字段，它们是伴随实例存在的
 *         当一个对象被实例化后，实例变量就已经存在，直到该对象被回收  ( 可能听不懂，先混个眼熟 )
 * 
 *         实例变量 通过 "对象名.字段名称" 来访问 ，比如:  first.name  、second.name 
 * 
 * 4、属于 [类] 的字段被称作 【类变量】( 也称作 类字段 或者 静态变量 )
 *         在一个类中可以声明属于该类的字段，比如: 在 Person 类中声明的 home 变量
 *         类变量是被 static 修饰符修饰的字段，它们是伴随类存在的
 *         当一个类被加载成功后，类变量就已经存在，直到该类被卸载时 ( 可能听不懂，先混个眼熟 )
 * 
 *         类变量 可以通过 "类名.字段名称" 来访问，比如 Person.home   【推荐使用】
 *         类变量 也可以通过 "对象名.字段名称" 来访问，比如 first.home 、second.home  【不建议使用】
 */
public class Person {

    // field
    public String name ;
    public int age ;
    public char gender ;
    public boolean married ;

    public static String home = "地球" ; // 被 static 修饰的字段是属于类的，被称作 类变量

    // method 
    public void introduce(){
        System.out.println( "大家好，我叫 " + name + "，今年 " + age + " 岁，目前" + ( married ? "已婚" : "未婚" ) );
    }

    public static void main( String[] args ) {

        // 类型   变量名  =  new 类名() ;
        Person first = new Person(); // 使用 new Person() 在堆内存中创建对象的过程被称作实例化
        first.name = "杨过" ;
        first.age = 18 ;
        first.gender = '男' ;
        first.married = false ;

        first.introduce();
        System.out.println( first.home );
        System.out.println( Person.home );

        Person second = new Person();
        second.name = "欧阳锋" ;
        second.age = 50 ;
        second.gender = '男' ;
        second.married = true ;

        second.introduce();
        System.out.println( second.home );
        System.out.println( Person.home );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Person.home = "Earth" ;
        System.out.println( first.home );
        System.out.println( second.home );
        System.out.println( Person.home );
        
    }

}
