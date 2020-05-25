/**
 * 1、编译时类型【 设计时类型 ，是设计类时为变量指定的类型 】
 * 2、运行时类型 可以通过 对象的 getClass() 方法来获取
 */
public class HumanTest2 {

    public static void main(String[] args) {
        
        // 变量 h 是存放在 main 方法的栈桢中的，其类型是 Human 类型
        Human h = new Sinaean();
        // Human h = new British();
        h.eat( "火锅" );

        // 变量 h 所指向的对象在堆内存中，该对象的类型可以通过 getClass() 来获取
        Class<?> c = h.getClass();
        System.out.println( c.getName() );

    }

}