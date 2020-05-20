package ecut ;

// 引用 非同包 的 public 修饰的 class 时，可以使用 import 语句实现
import cn.edu.ecut.Person ; // import 语句在一个类中可以出现N次 ( N >= 0 )

public class PersonTest2 { 

    public static void main(String[] args) {
        Person p = new Person();
        p.eat( "藜蒿炒腊肉" );
    }

}