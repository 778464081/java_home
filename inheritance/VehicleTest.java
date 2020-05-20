package cn.ecut.day0520.demo01;

class Vehicle {

    private String frame ; // 架子
    private String wheel ; // 轮子

    public String getFrame(){
        return frame ; // 等同于 return this.frame ;
    }

    public void setFrame( String frame ){
        this.frame = frame ;
    }

    public String getWheel(){
        return wheel ; // 等同于 return this.wheel ;
    }

    public void setWhell( String wheel ){
        this.wheel = wheel ;
    }

}

/** 子类可以继承父类中的一切实例成员，但能不能访问要看修饰符 */
class Bicycle extends Vehicle {
    // 当 创建 子类类型 的对象时，也会为 父类中声明的 实例字段 开辟空间 并赋予默认值
}

/** 子类可以在继承父类原有实例成员的基础上，对父类进行扩展 */
class Car extends Vehicle {
    public String locator ; // 定位器，比如 使用 北斗定位 、使用 GPS 定位
    public String sofa ;

    public void info() {
        System.out.println( this.getFrame() + " , " + this.getWheel() + " , " + this.locator + " , " + this.sofa );
        // System.out.println( this.frame + " , " + this.wheel + " , " + this.locator + " , " + this.sofa );
    }
}

// 在 Java 语言中，一个类只能直接继承一个父类 ( 在 extends 之后指定多个父类的做法是错误的 )
// class X extends Bicycle , Car { }

public class VehicleTest {

    public static void main(String[] args) {

        Bicycle b = new Bicycle();
        b.setFrame( "钢铁" );
        System.out.println( b.getFrame() );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Car c = new Car(); // frame / wheel / locator / sofa
        c.setFrame( "钛合金" );
        c.setWhell( "四个轮子" );

        c.locator = "北斗定位系统" ;
        c.sofa = "坐上去贼爽的沙发座位" ;

        c.info();

    }

}