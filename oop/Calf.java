
/**
 * 对于实例变量来说，赋值表达式 比 实例代码块 先执行，实例代码块 比 构造方法 先执行
 */
public class Calf {

    // 可以通过 赋值表达式 为 实例变量直接赋值
    public String name = "圣婴岱王" ; // 实例变量 ( 没有 static 修饰的 、属于 实例的 )

    { // 实例代码块 ( 用来完成对 实例变量的初始化 )
        System.out.println( "代码块: " + name );
    }

    // 构造方法 : 与类名同名 、没有返回类型
    public Calf(){
        System.out.println( "构造方法: " + name );
    }

    public static void main(String[] args) {

        Calf b = new Calf();
        System.out.println( b ); // 类型@哈希码

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Calf u = new Calf();
        System.out.println( u ); // 类型@哈希码

    }

}
