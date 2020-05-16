
/**
 * 1、不论是 类变量 还是 实例变量，JVM 都会为它们赋予相应的默认值
 *      基本数据类型都是零: 
 *          byte : 0 、short : 0 、int : 0 、long : 0 、float : 0.0f 、double : 0.0 、char : \u0000 、boolean : false
 *      引用类型都是 null
 * 2、被 static 修饰的方法是 类方法，没有 static 修饰的方法是 实例方法
 *      【有没有static修饰符修饰方法决定了方法是不是类方法，与其它修饰符无关】
 * 3、类方法 既可以通过 类名 来调用，也可以通过 对象名 来调用；
 * 4、实例方法 只能通过 实例 来调用，不能通过 类名 来调用
 */
public class Student {

    public static String school ; // 类变量 ( 有 static 修饰的 )

    public String name ; // 实例变量 ( 没有 static 修饰的 )

    public static void showSchool(){ // 类方法 ( 有 static 修饰的 )
        System.out.println( school ) ;
    }

    public void showName(){  // 实例方法 ( 没有 static 修饰的 )
        System.out.println( name ) ;
    }

    public static void main(String[] args) {

        System.out.println( Student.school ) ; // null
        // System.out.println( Student.name ) ; //【编译失败】错误: 无法从静态上下文中引用非静态 变量 name
        Student.school = "大肥羊学校" ;
        System.out.println( Student.school ) ;

        Student s = new Student();
        s.name = "懒羊羊" ;
        System.out.println( s.name ) ; // null
        System.out.println( s.school ) ; // null

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 通过 "类名.方法名" 来调用【类方法】
        Student.showSchool();
        // 通过 "对象名.方法名" 来调用【类方法】 ( 但是不赞成使用这种方式 )
        s.showSchool(); // The static method showSchool() from the type Student should be accessed in a static way

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // Student.showName(); // showName 方法 是 实例方法，不能通过 类名 来访问
        s.showName(); // 通过 "对象名.方法名" 来调用【实例方法】 

    }

}