
public class Elephant {

    public void increment( int x ) {
        System.out.println( "【 increment 】x = " + x );
        x++ ;
        System.out.println( "【 increment 】x = " + x );
    }

    public static void main(String[] args) { 
        
        int x = 100 ;

        Elephant e = new Elephant();

        System.out.println( "【 main 】x = " + x ); // 100

        // 调用任意的一个方法，都会导致产生于该方法本次执行对应的 栈桢
        e.increment( x ); // main 调用 e 的 increment 方法

        System.out.println( "【 main 】x = " + x ); // 100
        
    }

}
