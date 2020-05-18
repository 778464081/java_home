
/**
 * 1、类体括号中 可以出现 字段、构造、方法、代码块，但不能直接出现 语句
 * 2、实例的初始化过程: 
 *             通过 new 关键字创建对象时，
 *             首先为实例变量分配空间并为实例变量赋予默认值，
 *             然后执行 实例代码块 ，
 *             最后执行 构造方法中的代码
 */
public class Bull {

    public String name ; // 实例变量 ( 没有 static 修饰的 、属于 实例的 )

    { // 实例代码块 ( 用来完成对 实例变量的初始化 )
        System.out.println( "代码块" );
        System.out.println( "默认值: " + name );
    }

    // System.out.println( "" ); // 类体括号中不能出现语句

    // 构造方法 : 与类名同名 、没有返回类型
    public Bull(){
        System.out.println( "构造方法" );
        name = "牛魔王" ;
        System.out.println( "初始值: " + name );
    }

    public static void main(String[] args) {
        Bull b = new Bull();
        System.out.println( b ); // 类型@哈希码

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Bull u = new Bull();
        System.out.println( u ); // 类型@哈希码
    }

}
