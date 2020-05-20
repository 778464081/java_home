package cn.ecut.day0520.demo01;

/** 子类继承父类后，也许可以访问 父类中的 类变量 或 类方法，但是不能说子类继承了父类的 类变量 或 类方法 */
class Animal {
    // 被 static 修饰的 字段 或 方法 是属于当前类的 ( 如果子类能继承不就矛盾了吗 )
    public static String type ;
    public String name ;

    static {
        System.out.println( "Animal Initialization" );
        type = "动物" ;
    }
}

class Monkey extends Animal {
    static {
        System.out.println( "Monkey Initialization" );
    }

}

public class AnimalTest {

    public static void main(String[] args) {

        System.out.println( Monkey.type ); // 仅仅完成了对 Animal 的初始化，并没有初始化 Monkey

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Monkey m = new Monkey(); // 创建 Monkey 类的对象时导致 Monkey 被初始化
        m.name = "孙悟空" ;
        System.out.println( m.name ) ;

    }

}