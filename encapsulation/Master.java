
public class Master {

    private String name ;

    public void introduce() {
        System.out.println( "introduce : " + System.identityHashCode( this )  );
        System.out.println( "大家好，我是" + this.name );
    }

    public static void main(String[] args) {

        Master a = new Master();
        System.out.println( "main : " + System.identityHashCode( a ) );
        a.name = "钟南山" ;
        a.introduce(); // 此时在 introduce 方法内部的 this 就表示 a 对应的实例

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Master b = new Master();
        System.out.println( "main : " + System.identityHashCode( b ) );
        b.name = "钱三强" ;
        b.introduce(); // 此时在 introduce 方法内部的 this 就表示 b 对应的实例

    }

}
