
/**
 * 1、抽象类 与 具体类 的区别是【抽象类不可以被实例化，而 具体类 可以被实例化】
 * 2、抽象类中不一定要有抽象方法，为了让某个类不能被实例化也可以将该类设计为 抽象类
 */
public abstract class Human extends Object { // 抽象类 可以继承 具体类 ( 非抽象类 )

    protected String name ;

    static {
        System.out.println( "Human : 类初始化块" );
    }

    {
        System.out.println( "Human : 实例初始化块" );
    }

    public Human(){
        super();
        System.out.println( "Human()" );
    }

    public Human( String name ){
        super();
        this.name = name ;
        System.out.println( "Human(String)" );
    }

    public void show() {
        System.out.println( this.name );
    }

    public static void main(String[] args) {
        // Human h = new Human(); //【错误】Human是抽象的; 无法实例化
    }

}