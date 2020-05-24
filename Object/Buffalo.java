package object;
/**
 * 1、在 Java 语言中，一切都可以当做对象来对待，比如:
 *      一个类可以当做一对象来对待
 *      一个类的实例可以当做对象来对待
 * 
 * 2、在 Java 中使用 java.lang.Class 类来表示【类类型的对象】
 *       就是将 类 当做对象来对待，每个类都对应一个 对象
 *       比如 Object 类 对应的 对象 就可以使用一个 Class 实例 来表示
 * 
 *         类(Class)
 *            鼠类  :  舒克 、贝塔 、杰瑞
 *            牛类  :  牛魔王 、青牛怪(兕大王)
 *            虎类  :  虎先锋 、虎妞
 */
public class Buffalo { // 如果某个类没有显式指定父类，则其直接父类默认都是 Object 类

    public static void main(String[] args) {

        Object o = new Object();
        System.out.println( o ); // o.toString()
        System.out.println( o.toString() );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 获取 某个引用变量 所引用的 对象 的 类型 对应的 对象 【将类当做对象，获取某个实例对应的类的对象】
        Class c = o.getClass();
        System.out.println( c ); // c.toString()
        System.out.println( c.toString() );

        System.out.println( "= = = = = = = = = = = = = = = = = = = = =" );

        int[][] array = { { 1 , 3  } , { 5 ,7  } , { 9 } };
        System.out.println( array ); // array.toString()
        System.out.println( Integer.toHexString( array.hashCode() ) );

        Class x = array.getClass();
        System.out.println( x ); // x.toString()

        System.out.println( "= = = = = = = = = = = = = = = = = = = = =" );

        Buffalo b = new Buffalo();
        System.out.println( b ); // b.toString()
        System.out.println( Integer.toHexString( b.hashCode() ) );
        Class y = b.getClass() ;
        System.out.println( y ); // y.toString()

    }

}
