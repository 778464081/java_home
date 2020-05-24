package object;
/**
 * 1、重写了从 Object 继承的、可见的 toString 方法 ( 同名、同参、同返回 )
 * 2、重写一个方法时，为了 "告知" 编译器能够提示相应的错误，可以在 方法上标注 @Override
 * 3、java.lang.Override 是一个注解 ( annotation )
 */
public class Loong {

    private String name ;
    private int age ;

    public Loong( String name , int age ) {
        this.name = name ;
        this.age = age ;
    }

    @Override
    public String toString(){
        // System.out.println( this.name + " , " + this.age );
        String x = this.name + " , " + this.age ;
        return x ;
    }

    public static void main(String[] args) {
        Loong o = null ;
        System.out.println( o ); // o == null ? "null" : o.toString()
        // System.out.println( o.toString() ) ; // java.lang.NullPointerException

        o = new Loong( "敖丙" , 1500 );
        System.out.println( o ); // o == null ? "null" : o.toString()
        System.out.println( o.toString() ) ; // o.toString()
    }

}