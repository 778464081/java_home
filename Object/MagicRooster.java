
import java.util.Objects ; // JDK 1.7 开始提供了 Objects 类

/**
 * 1、所谓的重写后的 equals 方法要与 hashCode 一致，实际上就是遵守 hashCode 常规协定 ( 在 Java API 中找常规协定 )
 * 2、简单来说，equals 方法中通过什么字段判断两个对象是否相等，则在 hashCode 中就应该使用什么样的字段来产生哈希码值
 * 3、当两个对象使用 equals 方法比较后返回 true 时，它们的 哈希码值 必须相同
 * 4、Objects.hash( Object... value ) 可以根据一组数据产生一个哈希码值
 */
public class MagicRooster {

    // 实例变量
    private String name ;
    private int age ;

    // 构造方法
    public MagicRooster( String name , int age ){
        super();
        this.name = name ;
        this.age = age ;
    }

    // 重写父类中的 equals 方法，并通过比较 name 和 age 变量来判断两个对象是否相等
    @Override
    public boolean equals ( Object x ) {

        if( x == null ) {
            return false ;
        }

        if( this == x ) { // 如果两个对象地址相同则返回 true
            return true ;
        }

        // 判断两个对象的类型是否相同
        if( this.getClass() != x.getClass() ) {
            // 如果两个对象的类型是相同的，则通过 各自的 getClass() 方法所返回的 类型 是同一个对象
            // 如果不相同，则一定不是同一个对象
            return false ;
        }

        MagicRooster another = (MagicRooster) x ;

        // return this.name.equals( another.name ) && this.age == another.age ;
        // 比较字符串是否相等要使用 equals 方法而不是使用 == 运算符
        return name.equals( another.name ) && age == another.age ;
    }

    @Override
    public int hashCode() {
        
        // 为了与 equals 保持一致，可以在 hashCode 方法中根据 equals 方法中所比较的字段来产生哈希码值
        return Objects.hash( name , age ); // 使用 java.util 包中的 Objects 类 的 hash 方法产生 哈希码值

        // int result = 1 ;
        // result = 31 * result + ( name == null ? 0 : name.hashCode() );
        // result = 31 * result + ( age == 0 ? 0 : age );
        // return result ;
    }

    public static void main(String[] args) {

        MagicRooster a = new MagicRooster( "昴日星官" , 12500 );
        MagicRooster b = new MagicRooster( "昴日星官" , 12500 );

        System.out.println( a == b ); // 比较 变量 a 和 变量 b 中存储的值 ( 两者存储的都是地址 )
        System.out.println( a.equals( b ) ); // 比较 变量 a 所引用的对象 和 变量 b 所引用的对象

        System.out.println( "~~~~~~~~~~~~~" );

        MagicRooster x = a ;
        System.out.println( a.equals( x ) ) ;

        System.out.println( "~~~~~~~~~~~~~" );

        System.out.println( a.hashCode() );
        System.out.println( b.hashCode() );
    
    }

}