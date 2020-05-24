package object;
/**
 *1、理解什么是【 重写(override) / 覆盖(override) 】
 * 当子类中声明了与从父类中继承的(可见的)方法 同名、同参、同返回 的方法时，
 * 就说 子类中的 同名方法 重写了 ( 覆盖了 ) 父类中的同名方法，
 * 当通过子类类型的对象 调用 该名称的方法时，会执行子类中声明的方法
 * 
 * 2、不要制造新名词，可以使用 重写 或 覆盖 都对应鬼子那边的 override
 * 
 * 3、同名、同参、同返回
 *      同名: 子类中重新声明的方法的名称与从父类中继承的、可见的方法名称完全相同
 *      同参: 子类中重新声明的方法的名称与从父类中继承的、可见的同名方法参数相同
 *      同返回: 
 *             父类方法如果返回 基本类型 或 void ，则子类中重写后的方法返回类型必须与父类方法的返回类型相同
 *             如雷方法中如果返回引用类型，则子类重写后的方法返回类型需要与父类方法的返回类型 "同源" ( 相兼容 )
 */
public class Trapezoid extends Shape {

    private double top;
    private double bottom;
    private double height;

    public Trapezoid(double top, double bottom, double height) {
        super("梯形"); // 通过 super 调用父类带参数构造
        this.top = top;
        this.bottom = bottom;
        this.height = height;
    }

    public void calculate() {
        System.out.println( "计算梯形面积" );
    }

    public void show() {
        System.out.println( "输出梯形信息和梯形面积" );
    }

}
