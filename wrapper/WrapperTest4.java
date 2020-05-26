
/**
 * 1、基本数据类型的数值 被包装 到 一个相应的包装类类型的实例中
 *             Java 9 之前 可以使用 包装类的构造方法实现
 *             Java 9 开始 需要使用 valueOf 方法 【 public static  包装类类型  valueOf( 基本类型  value ) 】
 * 
 * 2、将 用字符串形式 表示的值解析为 基本类型的数值 后，
 *       再将 基本类型的数值 封装到一个相应的包装类类型的实例中
 *             public static Xxx valueOf( String s )
 *       注: Characher 类中没有 valueOf( String ) 方法
 * 
 * 3、将 字符串形式 表示的值解析为 基本类型的数值
 * 
 *      八种基本数据类型对应的包装类中，除了 Character 类之外，都有一个可以将字符串按照十进制解析其相应基本类型数值的方法
 *      
 *                  byte   Byte.parseByte( String s )
 *                short   Short.parseShort( String s )
 *                    int   Integer.parseInt( String s  )
 *                  long   Long.parseLong( String s )
 *                 float   Float.parseFloat( String s  )
 *              double   Double.parseDouble( String s )
 *            boolean   Boolean.parseBoolean( String s )
 * 
 *      对于整数类型来说，其相应的包装类中可以将 字符串形式 表示的值 按照 指定的 radix 解析为十进制整数
 *                 byte   Byte.parseByte( String s , int radix )
 *               short   Short.parseShort( String s , int radix )
 *                   int   Integer.parseInt( String s , int radix )
 *                 long   Long.parseLong( String s , int radix )
 * 
 * 4、通常在 Java 语言中使用的 radix 的范围是 [ 2 , 36 ]
 *         Character.MIN_RADIX 、Character.MAX_RADIX
 */
public class WrapperTest4 {

    public static void main( String[] args ) {

        final String x = "101";

        // Byte.parseByte( "10010" ) // NumberFormatException: Value out of range. Value:"10010" Radix:10
        byte b1 = Byte.parseByte( x ); // String ====>  byte
        System.out.println( b1 );
        byte b2 = Byte.parseByte( x , 2 ) ; // String ====> byte
        System.out.println( b2 );

        short s1 = Short.parseShort( x ); // String ====>  byte
        System.out.println( s1 );
        short s2 = Short.parseShort( x , 16 ) ; // String ====> byte
        System.out.println( s2 );

        int i1 = Integer.parseInt( x ); // String ====>  byte
        System.out.println( i1 );
        int i2 = Integer.parseInt( x , 20 ) ; // String ====> byte
        System.out.println( i2 );

        // 在 Long.parseLong( String ) 方法的参数中，是否可以使用 "100010L" 形式 ?
        long o1 = Long.parseLong( x ); // String ====>  byte
        System.out.println( o1 );
        long o2 = Long.parseLong( x , 36 ) ; // String ====> byte
        System.out.println( o2 );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        float f1 = Float.parseFloat( "3.14F" );
        System.out.println( f1 );

        float f2 = Float.parseFloat( "3.14" );
        System.out.println( f2 );

        double d1 = Double.parseDouble( "3.14D" );
        System.out.println( d1 );

        double d2 = Double.parseDouble( "3.14" );
        System.out.println( d2 );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        boolean z1 = Boolean.parseBoolean( "tRue" );
        System.out.println( z1 ); // true

        boolean z2 = Boolean.parseBoolean( " true " ); // 注意最后多个空格
        System.out.println( z2 ); // false

        boolean z3 = Boolean.parseBoolean( "" );
        System.out.println( z3 ); // false

        // System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
        // Character 类中没有 parseChar( String ) 方法
        // char ch = Character.parseChar( "A" ); // 错误: 找不到符号

    }

}