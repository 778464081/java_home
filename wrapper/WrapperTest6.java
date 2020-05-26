
/**
 * 1、Byte 、Short 、Integer 、Long 、Float 、Double 都继承了 Number 类
 * 2、将 基本数据类型的数值 封装到 其相应包装类类型的实例中后，可以将这个数值当做一个对象来对待
 */
public class WrapperTest6 {

    public static void main(String[] args) {

        Double d = null ;

        d = Double.valueOf( 9527.1415926 );
        
        System.out.println( d ); // d == null ? "null" : d.toString()

        byte b = d.byteValue();
        System.out.println( b );

        int i = d.intValue();
        System.out.println( i );

        float f = d.floatValue() ;
        System.out.println( f );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~" );

        boolean x = d.isNaN(); // isNaN : is Not a Number
        System.out.println( x );

        boolean y = d.isInfinite();
        System.out.println( y );

        System.out.println( "= = = = = = = = =" );

        Character ch = Character.valueOf( 'A' );
        char c = ch.charValue();
        System.out.println( c );
        
    }

}
