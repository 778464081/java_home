
/**
 * 1、抽象类 可以继承 抽象类 、具体类(非抽象类) 可以继承抽象类、抽象类可以继承 具体类
 * 2、抽象方法是 由 abstract 修饰的、没有方法体 的方法
 * 3、有抽象方法的类必须是抽象类
 */
public abstract class Sinaean extends Human {

    public Sinaean(){
        super(); // 调用父类构造 ( 不管父类是 抽象类 还是 具体类 )
        System.out.println( "Sinaean()" );
    }

    // 声明一个抽象方法
    public abstract void eat( String foodName ) ; // 没有方法体、由 abstract 修饰符修饰

}