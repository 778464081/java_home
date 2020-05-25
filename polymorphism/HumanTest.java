/**
 * 1、体验运行时多态: 
 *      在运行期间，引用变量 引用了 (指向了) 哪一个子类类型的实例，将来调用方法时就调用哪个实例的方法
 * 
 * 2、编译时类型决定了可以通过 引用变量 来访问哪些字段、调用哪些方法，
 *      因为子类重写了父类中的方法，因此父类类型的引用变量可以调用的方法在子类实例中是存在的
 * 
 * 3、了解 动态绑定
 */
public class HumanTest {

    public static void main(String[] args) {
        
        Human h = null ; // 声明一个 Human 类型的引用变量 h 并为其赋值为 null
        System.out.println( "h=> " + h );

        h = new Human(); // Human 类型的引用变量 引用了 (指向了) 一个 Human 实例
        System.out.println( "h=> " + h );
        h.eat( "鸡腿" );

        // 父类类型的引用变量 引用了 (指向了)  子类类型的对象
        h = new Sinaean(); // Human 类型的引用变量 引用了 (指向了) 一个 Sinaean 实例
        System.out.println( "h=> " + h );
        h.eat( "米饭" );

        // 父类类型的引用变量 引用了 (指向了)  子类类型的对象
        h = new British(); // Human 类型的引用变量 引用了 (指向了) 一个 British 实例
        System.out.println( "h=> " + h );
        h.eat( "包子" );

        // 父类类型的引用变量 引用了 (指向了)  子类类型的对象
        h = new India(); // Human 类型的引用变量 引用了 (指向了) 一个 India 实例
        System.out.println( "h=> " + h );
        h.eat( "火锅" );

    }

}