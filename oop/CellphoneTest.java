
class Cellphone {
    public String brand ;
    public int memory ;
}

class Factory {
    public Cellphone produce(){
        Cellphone c = null ; // 声明一个 Cellphone 类型的变量并为其赋值
        c = new Cellphone(); // 创建 Cellphone 对象并将其在堆内存中的地址赋值给引用变量 c
        c.brand = "小米手机" ; // 通过引用变量 c 找到堆内存中的 Cellphone 对象 并为其 实例变量 brand 赋值
        c.memory = 1 << 30 ;
        System.out.println( "produce : " + System.identityHashCode( c ) ) ;  
        return c ; // 返回引用变量 c 中的 值 ( 实际上是个地址 )
    }
}

// 同一个 源文件中 可以存在多个 class ，但至多有一个 public 修饰的 class
// 如果存在 public 修饰的 class  ，则源文件的名称 必须与 public 修饰的 class 的名称相同
 public class CellphoneTest {
    public static void main(String[] args) {
        Factory f = new Factory();
        Cellphone c = f.produce();
        System.out.println( "main : " + System.identityHashCode( c ) ) ;  
    }
}
