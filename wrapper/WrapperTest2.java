
/**
 * 1、八种基本数据类型对应的包装类类型
 *          byte -----> Byte
 *          short ----> Short
 *          int  ------> Integer
 *          long -----> Long
 *          float ----> Float
 *          double --> Double
 *          boolean --> Boolean
 *          char -----> Character
 * 2、八种基本类型对应的包装类都有一个将相应的基本类型数据封装成该类对象的 valueOf 方法
 *          public static Xxx valueOf( xxx  value )
 */
public class WrapperTest2 {

    public static void main(String[] args) {

        // valueOf 接受一个与之对应的基本数据类型的数值做参数，返回一个当前类型的对象
        Byte b = Byte.valueOf( (byte) 100 );  // byte --->  Byte
        System.out.println( b + " , " + b.getClass().getName() );

        Short s = Short.valueOf( (short)1000 );  // short ---> Short
        System.out.println( s + " , " + s.getClass().getName() );

        Integer i = Integer.valueOf( 9527 ); // int ---> Integer
        System.out.println( i + " , " + i.getClass().getName() );

        Long o = Long.valueOf( 123456789L ); // long ---> Long
        System.out.println( o + " , " + o.getClass().getName() );

        Float f = Float.valueOf( 123.456789F ); // float --> Float
        System.out.println( f + " , " + f.getClass().getName() );
        
        Double d = Double.valueOf( 3.14 ); // double ---> Double
        System.out.println( d + " , " + d.getClass().getName() ); 

        Boolean z = Boolean.valueOf( true ); // boolean ---> Boolean
        System.out.println( z + " , " + z.getClass().getName() ); 

        Character c = Character.valueOf( '汉' ); // char ----> Character
        System.out.println( c + " , " + c.getClass().getName() ); 
        
    }

}