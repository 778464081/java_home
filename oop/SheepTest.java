
public class SheepTest {

    public static void main(String[] args) {

        // null 是所有的引用类型的变量都可以使用的取值
        Sheep s = null ; // 声明一个 Sheep 类型的引用变量 s 并为其赋值
        System.out.println( s );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        s = new Sheep(); // 创建 Sheep 类的对象就是主动使用 Sheep 类
        System.out.println( s ); // 类型@哈希码
        System.out.println( System.identityHashCode( s ) );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Sheep h = new Sheep();
        System.out.println( h ); // 类型@哈希码
        System.out.println( System.identityHashCode( h ) );
        
    }

}
