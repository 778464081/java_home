package object;
/**
 * 1、如果一个类中存在多个相互重载的构造方法，则通过 this( [ 实参列表 ] ) 可以调用其它构造方法
 * 2、如果父类中存在多个相互重载的构造方法，则通过 super( [ 实参列表 ] ) 可以调用父类中指定的构造方法
 */
public class MashiMaro extends Object { // 兔 : 流氓兔

    private String name ;
    private int age ;

    public MashiMaro(){
        super(); // 通过参数确定调用的是父类中的无参数构造
        System.out.println( "MashiMaro()" );
    }

    public MashiMaro( String name ) {
        // super(); // 通过参数确定调用的是父类中的无参数构造
        this(); // 通过参数确定调用本类构造中的无参数构造
        this.name = name ;
        System.out.println( "MashiMaro( String )" );
    }

    public MashiMaro( String name , int age ) {
        this( name ); // 通过参数确定调用本类构造中的有参数构造( MashiMaro(String) )
        this.age = age ;
        System.out.println( "MashiMaro( String , int )" );
    }

    public void show(){
        // System.out.println( super ); //【编译失败】super 不能单独使用
        System.out.println( this ); // this 关键字可以单独使用，表示当前对象本身
    }

    public static void main(String[] args) {
        
        MashiMaro m = new MashiMaro( "流氓" , 4 );
        System.out.println( m ); // m.toString()

    }


}