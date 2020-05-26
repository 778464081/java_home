
/**
 * 1、将 基本数据类型的数值 转换为 字符形式 表示
 * 2、这里仅测试 Integer 类中的 toString 方法，其它包装类中的方法请自行测试
 * 3、除了 Integer 类之外，其它包装类中是否有 toBinaryString 、toOctalString 、toHexString 等方法 ?
 */
public class WrapperTest5 {

    public static void main( String[] args ) {

        final int x = 9527 ;

        String s = x + "" ; // 【近"串"者"串"】
        System.out.println( s + " , " + s.getClass().getName() );

        String ss = Integer.toString( x ); // 返回 整数的 十进制 字符串 形式
        System.out.println( ss + " , " + ss.getClass().getName() );

        String binary = Integer.toString( x, 2 ) ; // 返回 整数的 二进制 字符串 形式
        System.out.println( binary + " , " + binary.getClass().getName() );

        String hex = Integer.toString( x, 16 ) ; // 返回 整数的 十六进制 字符串 形式
        System.out.println( hex + " , " + hex.getClass().getName() );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        String b = Integer.toBinaryString( x ); // 返回 整数的 二进制 字符串 形式
        System.out.println( b );

        String o = Integer.toOctalString( x ); // 返回 整数的 八进制 字符串 形式
        System.out.println( o );

        String h = Integer.toHexString( x ); // 返回 整数的 十六进制 字符串 形式
        System.out.println( h );

    }

}
