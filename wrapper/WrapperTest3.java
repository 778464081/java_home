
/**
 * 除了 Character 外，八种基本类型对应的包装类都有一个将字符串解析并封装成该类对象的 valueOf 方法
 *          public static Xxx valueOf( String  value )
 */
public class WrapperTest3 {

    public static void main(String[] args) {

        // valueOf 接受一个与之对应的基本数据类型的数值做参数，返回一个当前类型的对象
        Byte b = Byte.valueOf( "100" );  
        System.out.println( b + " , " + b.getClass().getName() );

        Short s = Short.valueOf( "1000" ); 
        System.out.println( s + " , " + s.getClass().getName() );

        Integer i = Integer.valueOf( "9527" ); 
        System.out.println( i + " , " + i.getClass().getName() );

        Long o = Long.valueOf( "123456789" ); 
        System.out.println( o + " , " + o.getClass().getName() );

        Float f = Float.valueOf( "123.456789F" );
        System.out.println( f + " , " + f.getClass().getName() );
        
        Double d = Double.valueOf( "3.14" );
        System.out.println( d + " , " + d.getClass().getName() ); 

        Boolean z = Boolean.valueOf( "true" );
        System.out.println( z + " , " + z.getClass().getName() ); 

        // Character c = Character.valueOf( "汉" ); // Character 没有定义 valueOf( String ) 方法
        
    }

}