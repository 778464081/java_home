
class Super {
    public static String getType() {
        return "Super";
    }
}

class Sub extends Super {
    // 对于 类方法 来说，一般不认为是 重写
    public static String getType() {
        return "Sub";
    }
}

public class StaticMethodTest {

    public static void main(String[] args) {

        String s = null;

        // 编译阶段就 确定 是 哪个类的 getType 方法
        s = Super.getType(); // 被 final 、static 、private 修饰的方法都属于 静态绑定
        System.out.println(s);

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 编译阶段就 确定 是 哪个类的 getType 方法
        s = Sub.getType();
        System.out.println(s); // Sub

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Super su = new Sub();
        // 编译阶段就 确定 getType() 方法是 Super 类中的方法
        s =  su.getType(); // 不推荐的使用方式
        System.out.println(s); // Super

        Sub sub = new Sub();
        // 编译阶段就 确定 getType() 方法是 Sub 类中的方法
        s =  sub.getType(); // 不推荐的使用方式
        System.out.println(s); // Sub

    }

}
