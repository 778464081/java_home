
public class Mars extends Planet { // 火星

    public Mars() {
        super( "火星" , 3397 ) ; // 调用父类有参数构造
    }

    public void info(){
        System.out.println( "我是" + this.name + " ， 我的半径是 " + this.radius + " 公里" );
    }

    public static void main(String[] args) {
        
        // 变量 p 的类型是 Planet ，因此 Planet 就是 p 的【编译时类型】
        Planet p = null ; // 声明一个 名称为 p 的 Planet 变量，并为其赋值 null

        p = new Planet();
        p.name = "水星" ;
        p.radius = 2440 ;
        p.show();
        
        p = new Mars();
        p.show();
        // p.info();

        // 变量 m 的类型是 Mars ，因此 Mars 就是 m 的 【编译时类型】
        Mars m = (Mars) p ;
        m.info();

    }

}