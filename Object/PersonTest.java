
// 被 final 修饰符修饰的类是最终的类，它们没有子类
final class Person {
    // 通常，将不是为了继承而设计的类定义为 最终类 ( final 修饰的类 )
    // 如果某个类不期望有子类可以为该类增加 final 修饰符 ，比如 java.lang.String 就是这种类
}

// 编译错误 : 错误: 无法从最终Person进行继承
class Sinaean extends Person { //【编译是要出错的】
}

public class PersonTest {

    public static void main(String[] args) {
    
    }

}
