
/**
 * 注意，
 * 这个类没有重写 hashCode 和 equals 方法，
 * 因此仍然是在使用 Object 类中的  hashCode 和 equals 方法
 */
public class Rooster {

    private String name ;
    private int age ;

    public Rooster( String name , int age ){
        super();
        this.name = name ;
        this.age = age ;
    }

    public static void main(String[] args) {

        Rooster r = null ; // 声明一个 Rooster 类型的变量并将其赋值为 null

        r = new Rooster( "昴日星官" , 12500 );

        System.out.println( r.hashCode() ); // 第 1 次

        r.name = "昴日星官他哥" ;
        System.out.println( r.hashCode() ); // 第 2 次

        r.age = 13500 ;
        System.out.println( r.hashCode() ); // 第 3 次

        r.name = "昴日星官他弟" ;
        r.age = 12000 ;
        System.out.println( r.hashCode() ); // 第 4 次
    
    }

}