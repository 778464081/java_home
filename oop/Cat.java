
/**
 * 1、使用 class 关键字可以声明一个类 ，比如 public class Cat 
 * 2、一个类可以表示一类事物，在类中可以定义该类事物或其个体所具有的特征、行为
 * 3、字段(field) 表示该类事物或其个体特征的变量
 * 4、方法(method) 表示该类事物或其个体可以完成动作、行为
 * 5、构造方法( constructor ) 是类中与类名同名但没有返回类型的方法
 */
public class Cat {

    //【 字段 ( Field ) 】用于反应某一类事物或该类事物的个体具有什么特征
    // 修饰符  类型  名称;
    public String name ; // 任意的一个字段本质上都是一个变量
    public int age ; 

    // 【构造方法】与类名同名但没有返回类型
    // 修饰符 类名() { }
    public Cat(){
        System.out.println( "Cat构造方法执行" );
    }

    //【 方法( Method ) 】反应某一类事物或该类事物的个体可以干什么
    // 修饰符 返回类型 方法名称(参数类型 参数名称) {  }
    public void eat( String foodName ) {
        System.out.println( "猫可以吃" + foodName );
    }

    public static void main(String[] args) { // 一个特殊的方法

        // 声明一个 Cat 类型的变量 c 
        Cat c ; 

        // 1、new 负责在 堆内存中 开辟空间 ( Cat 类型决定了所开辟空间的大小 )
        // 2、执行 构造方法
        // 3、将 在堆内存中 创建好的 Cat 对象 ( 也叫 Cat 实例 ) 的地址 赋值给 c 变量
        c = new Cat(); // 【创建 Cat 类的对象(实例)】
        System.out.println( c ); // 类型@哈希码
        System.out.println( System.identityHashCode( c ) );

        // 通过 c 变量存储的地址找到 堆内存中的 Cat 对象后，为该对象的 name 字段赋值
        c.name = "汤姆" ; // 圆点运算符 可以理解为汉语中的 "的" ，比如 c.name 可以读作 c 的 name
        c.age = 5 ;

        System.out.println( c.name + " , " + c.age );

        // 通过 c 变量存储的地址找到 堆内存中的 Cat 对象后，执行该对象的 eat 方法
        c.eat( "小黄鱼" ); // 【 main 调用 c 的 eat 方法 】【绝对不能说成是c调用eat方法】

    }

}
