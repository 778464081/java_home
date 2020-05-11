
/**
 * 1、当一个类中没有显式书写任何构造方法时，编译器会为当前类添加一个默认的构造方法
 *      默认的构造方法是 公开的 ( 被 public 修饰的 ) 、无参的 ( 没有任何参数 )
 * 
 * 2、使用 new 关键字创建类的对象时，需要在 new 关键字之后 调用类的构造方法
 * 
 * 3、类是抽象的，对象(实例)是具体的
 */
public class Panda {

    // field
    public String name ;
    public int age ;
    public double weight ;
    public double height ;

    // constructor 
    // 当没有显式指定任何一个构造方法时，编译器会为当前类添加一个默认的构造方法
    // 默认的构造方法是 public 修饰的、与类名同名、没有任何参数 (所有构造方法都是没有返回类型的)
    public Panda(){
        System.out.println( "Panda构造方法执行" );
    }

    // method 
    public void show(){
        System.out.println( "俺是" + name + " , 今年 " + age + "岁了，目前身高 " + height + "cm ，体重 " + weight + "kg." );
    }

    public static void main(String[] args) {

        // 1、new 负责在 堆内存 中开辟空间 ( 空间大小根据 Panda 类来确定 )
        // 2、为 Panda 类中定义的 field 赋予默认值 ( 基本数据类型统统是 零，引用类型统统是 null )
        // 3、执行构造方法 ( 通常是在构造方法中完成对 field 的初始化 )
        // 4、将 new Panda() 在 堆内存 中 创建好的 Panda 对象 ( 实例 ) 的地址赋值给 p 变量
        Panda p = new Panda(); // new 关键字必须结合类的构造方法才能创建类的对象
        System.out.println( p ); // 类型@哈希码

        // [谁] 调用 [谁] 的 [啥方法  [干了啥]  [返回了啥]
        p.show(); // 【 main 调用 p 的 show 方法 输出了 p 的各个 field 的值 但没有返回数据 】

        p.name = "团团" ;
        p.age = 10 ;
        p.height = 98.5 ; // cm
        p.weight = 42.3 ; // kg

        p.show();

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Panda a = new Panda();
        a.name = "圆圆" ;
        a.age = 9 ;
        a.height = 90.0 ; // cm
        a.weight = 38.5 ; // kg
        a.show();
        
    }
    
}
