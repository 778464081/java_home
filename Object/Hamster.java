
package object;
/**
 * 1、Object 类中定义了 toString() 方法用于获取对象的字符串表示形式
 * 2、Object 类中定义了 hashCode() 方法用于获取对象的 哈希码 ( 或称作 哈希值 / 哈希码值 )
 */
public class Hamster extends Object { // java.lang 包中的所有的类都可以不显式 import

    public static void main(String[] args) {
        
        Object o = new Object();
        System.out.println( o ); // 类型@哈希码

        String s = o.toString() ; // 获取 o 所引用的对象的字符串表示形式
        System.out.println( s ); // 类型@哈希码

        int hash = o.hashCode(); // 获取 哈希码 ( 以十进制形式返回 )
        System.out.println( "十进制形式: " + hash );
        System.out.println( "十六进制形式: " + Integer.toHexString( hash ) );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Hamster h = new Hamster();
        System.out.println( h );
        System.out.println( h.toString() );
        System.out.println( h.hashCode() );
        System.out.println( Integer.toHexString( h.hashCode() ) );

    }

}
