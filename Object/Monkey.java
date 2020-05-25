
/**
 * 编译，看错误提示
 */
public class Monkey {

    // 子类重写的父类方法是被 fianl 修饰符修饰的 ( 被覆盖的方法为 final )
    public final Class<?> getClass() { // 【编译错误】错误: Monkey中的getClass()无法覆盖Object中的getClass()
        return null ;
    }

}
