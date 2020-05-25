/**
 * 引用类型的强制类型转换
 */
public class HumanTest3 {

    public static void main(String[] args) {

        // 父类类型的引用变量 指向 子类类型的对象
        Object o = new Sinaean();
        // o.eat( "藜蒿炒腊肉" ); //【错误】变量 o 的编译时类型是 Object ，其中并没有声明 eat 方法

        if( o instanceof Human ) {
            Human h = (Human) o ;
            h.eat( "藜蒿炒腊肉" ); // 变量 h 的编译时类型是 Human ，其中是包含被调用的 eat 方法
            System.out.println( o == h ); // true
        }

        if( o instanceof Sinaean ) {
            Sinaean s = (Sinaean) o ;
            s.eat( "宫爆鸡丁" );
            s.taiChi(); // 变量 s 的编译时类型是 Sinaean ，其中是包含被调用的 taiChi 方法
            System.out.println( o == s ); // true
        }

    }

}