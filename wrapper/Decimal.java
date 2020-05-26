
/**
 * 1、被 final 修饰的类就是所谓的 【最终类】 ( 或者称作 不可变类 / 不变类 )
 * 2、被 final 修饰的类是没有子类的
 * 3、被 final 修饰的变量被称作 【最终变量】 ( 可以是 类变量、实例变量 、局部变量 、参数 )
 */
public final class Decimal {

    // 被 final 修饰的 类变量 被称作【常量】
    public final static long MAX_VALUE = 0x7fffffffffffffffL ; 
    // 常量名称中所有单词一律大写，多个单词之间使用 下划线 隔开
    public final static long MIN_VALUE = 0x8000000000000000L ; 

    // 被 final 修饰的 实例变量 在初始化之后不能再次赋值
    private final long value ;

    {
        // System.out.println( "this.value : " + this.value ); // 错误: 可能尚未初始化变量value
    }

    public Decimal ( long value ) {
        // System.out.println( "this.value : " + this.value ); // 错误: 可能尚未初始化变量value
        this.value = value ;
        System.out.println( "this.value : " + this.value );
    }

    public long getValue(){
        return this.value ;
    }

    public void setValue( long value ) {
        // this.value = value ; // 错误: 无法为最终变量value分配值
    }

    public static Decimal valueOf( long value ) {
        return new Decimal( value );
    }

    public static void main(String[] args) {
        // 在 堆内存中所创建的 Decimal 对象是不可变的 ( 因为其内部 实例变量的 值不可更改 ) 【不可变对象】
        Decimal d = new Decimal( 100L );
        System.out.println( d.getValue() );
        System.out.println( System.identityHashCode( d ) );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 但是 Decimal 类型的变量 d 的值 是可以改变的，也就是 d 可以引用不同的 Decimal 实例
        d = new Decimal( 200L );
        System.out.println( d.getValue() );
        System.out.println( System.identityHashCode( d ) );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        d = Decimal.valueOf( 300L );
        System.out.println( d.getValue() );
        System.out.println( System.identityHashCode( d ) );

    }

}
