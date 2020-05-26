
/**
 * 获得 某种 基本数据类型 数值 对应的 包装类类型的实例
 * 在 Java 9 之前使用 包装类的 构造方法创建实例
 * 从 Java 9 开始使用 valueOf 等方法来获取 实例
 */
public class WrapperTest1 {

    public static void main(String[] args) {
        
        // Java 9 之前使用 构造方法创建 相应的实例
        byte b = 100 ;
        Byte first = new Byte( b); // 但是从 Java 9 开始 包装类的 构造方法均已废弃
        System.out.println( first ); // first.toString()

        short s = 9527 ;
        Short second = new Short( s ); // 但是从 Java 9 开始 包装类的 构造方法均已废弃
        System.out.println( second ); // second.toString()

        // 从 Java 9 开始 建议使用 工厂方法来创建 包装类的实例
        Integer third = Integer.valueOf( 999 ) ; // 将 int 类型的数值 封装到一个 Integer 实例中
        System.out.println( third ); // third.toString()

        Long fourth = Long.valueOf( 999L ) ; // 将 long 类型的数值 封装到一个 Long 实例中
        System.out.println( fourth ); // fourth.toString()

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        System.out.println( fourth.getClass() ); // 获得运行时类型
        System.out.println( fourth.hashCode() ); // 获得哈希码值
        System.out.println( fourth.toString() ); // 获取字符串表示形式

        // 即使变量 fourth 指向的 对象对应的类 重写 hashCode 方法，
        // 我们仍然可以通过 identityHashCode 来获取 由 Object 提供的 hashCode 方法所返回的值
        System.out.println( System.identityHashCode( fourth ) );
    }

}