
/**
 * 1、如果 具体类 继承了 抽象类，则必须实现抽象类中的所有抽象方法
 * 2、当子类继承了 抽象类后，如果仍然不能确定抽象方法的实现过程，可以将子类继续定义为 抽象类
 */
public class Han extends Sinaean {

    public Han(){
        super(); // 调用父类构造 ( 不管父类是 抽象类 还是 具体类 )
        System.out.println( "Han()" );
    }

    @Override
    public void eat( String foodName ) { // 如果有方法体就一定不能有 abstract 修饰符
        System.out.println( "在中国汉族人基本都使用筷子吃" + foodName + "，比如我" + this.name + "就是这样的");
    }

    public static void main(String[] args) {

        Han h = new Han();
        h.name = "罗文康" ;
        h.eat( "火锅" );

    }

}
