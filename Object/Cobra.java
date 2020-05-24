package object;
/**
 * 1、【凡是使用 == 比较两个变量，一定是比较两个变量中存储的值】
 *      基本类型的变量中存储的是数值本身，引用类型的变量中存储的是地址
 *      所有，就又有了:
 *      == 运算符对于基本类型的变量来说比较值，对于引用类型的变量来说比较地址
 * 2、使用 == 运算符比较两个变量时，需要注意 == 两侧类型必须相匹配
 */
public class Cobra {

    private String name ;
    private int age ; // 以 年 为单位 , 存储整数
    private int length ; // 以 厘米 为单位，存储整数
    private int weight ; // 以 克 为单位，存储整数

    public Cobra( String name , int age , int length , int weight ) {
        this.name = name ;
        this.age = age ;
        this.length = length ;
        this.weight = weight ;
    } 

    @Override
    public String toString(){
        return "name : " +
                this.name + " , age : " + this.age + " , length :" +
                " " + this.length + " , weight : " + this.weight ;
    }

    public static void main(String[] args) {

        int x = 100 ;
        int y = 100 ;
        System.out.println( x == y ); // true : 比较两个变量中存储的值

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Cobra a = new Cobra( "老大" , 10 , 125 , 2500 );
        System.out.println( a ); // a == null ? "null" : a.toString()
        System.out.println( System.identityHashCode( a ) ) ; // 要重视 System.identityHashCode 方法

        Cobra b = new Cobra( "老大" , 10 , 125 , 2500 );
        System.out.println( b ); // b == null ? "null" : b.toString()
        System.out.println( System.identityHashCode( b ) ) ;

        System.out.println( a == b );  // false : 比较两个变量中存储的值

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // System.out.println( x == b ); //【编译失败】错误: 二元运算符 '==' 的操作数类型错误

        Object o = new Object();
        System.out.println( o == b ); // false : 引用类型的变量之间可以使用 == 进行比较

        int[] array1 = { 1 , 3 , 5 };
        // System.out.println( b == array1 );  //【编译失败】
        System.out.println( o == array1 ); // false : 因为 数组 也继承了 Object 类并实现了其中的所有方法
        int[][] array2 = new int[ 5 ] [ 5 ] ;
        // System.out.println( array1 == array2 ); //【编译失败】
        System.out.println( o == array2 ); // false : 因为 数组 也继承了 Object 类并实现了其中的所有方法

    }

}
