package laptop;

public class DemoMain {
    public static void main(String[] args) {
        Laptop laptop =new Laptop();
        laptop.powerOn();
        USB usbMouse =new Mouse();      //多态写法
        laptop.useDevice(usbMouse);
        Keyboard keyboard =new Keyboard();
        //参数为USB类型 为什么可以传递Keyboard？
        // Keyboard < USB ; 自动类型转换； 类似 参数为double  可以将int传入进去
        laptop.useDevice(keyboard);

        laptop.powerOff();

    }

}
