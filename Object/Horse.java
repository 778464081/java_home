package object;
/**
 * 1、在 Object 类中 equals 方法的实现过程如下:
 * 
 *       public  boolean  equals ( Object o ) {
 *            return this == o ; // 本质上仍然是在比较地址
 *       }    
 * 
 * 2、我们需要重写从 Object 类继承的 equals 方法才能实现按要求来比较两个对象是否 "相等"
 *       比如，我们期望比较 两匹马 的 名字、年龄、身高、体重
 * 
 * 3、声明变量时所使用的类型决定了通过该变量可以访问那些 成员变量 和 成员方法
 * 
 * 4、使用 instanceof 关键字可以判断 某个对象 是否是 某种类型
 * 
 *             引用变量  instanceof  类型
 *             another   instanceof  Horse
 * 
 *       当 引用变量 所指向的 对象 是 指定类型 时，instanceof 表达式返回 true ，否则返回 false 。
 * 
 *       要注意区分 引用变量  和 引用变量 所指向(或者叫所引用的) 对象 。
 * 
 * 5、引用类型的强制类型转换  
 *             目标类型  变量名称 = ( 目标类型 ) 引用变量 ;
 *              Horse           h      =    ( Horse )  another ;
 * 
 * 6、比较两个基本类型的值是否相等可以使用 == 运算符；比较两个对象是否相等要使用 equals 方法
 * 
 * 7、如果要比较两个 字符串 是否相等 ，应该使用 由 String 类重写的 equals 方法来实现 
 */
public class Horse extends Object {

    private String name ;
    private int age ; // 以 年 为单位 , 存储整数
    private int height ; // 以 厘米 为单位，存储整数
    private int weight ; // 以 克 为单位，存储整数
    public Horse( String name , int age , int height , int weight ) {
        this.name = name ;
        this.age = age ;
        this.height = height ;
        this.weight = weight ;
    } 

    @Override
    public String toString(){
        return "name : " + this.name + " , age : "
                + this.age + " , height : " + this.height + " " +
                ", weight : " + this.weight ;
    }

    @Override
    public boolean equals( Object another  ) {
        // 声明一个变量时所使用的类型，决定了通过该变量可以访问那些 成员变量 和 成员方法
        // 声明变量时所使用的类型中有那些 成员变量 和 成员方法 则通过该类型的引用变量就可以访问那些 成员变量 和 成员方法
        // if( this.height == another.height ) //【编译失败】错误: 找不到符号 ( 因为在 another 对应的类型 Object 中并没有声明 height 变量 ) 
        if( another instanceof Horse ) { // 判断 another 变量所引用的 对象 是否是 Horse 类型
            Horse h = (Horse) another ; // 引用类型的强制类型转换
            // 比较基本类型的值是否相等可以使用 == 运算符，但比较 两个对象是否相等需要借助于 equals 方法( String 也不例外 )
            if( this.name.equals( h.name ) && this.age == h.age && this.height == h.height && this.weight == h.weight ) {
                return true ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {

        Horse a =  new Horse( "的卢" , 20 , 198 ,  289000 );        
        Horse b =  new Horse( "的卢" , 20 , 198 ,  289000 );

        System.out.println( a == b ); // false : 因为两个变量中存储的值是不同的

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // public boolean  equals( Object another ) : Indicates whether some other object is "equal to" this one.
        // a ==> this one , b ===>  some other object
        System.out.println( a.equals( b ) ) ; // 借助于从 Object 类继承的、可见的 equals 方法来实现比较两个对象是否 "相等"

        System.out.println( "= = = = = = = = = = = = = = = =" );

        Object o = new Object();
        System.out.println( a.equals( o ) ) ;


    }

}
