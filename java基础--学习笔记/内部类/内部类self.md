#  内部类

## 成员内部类

**实例内部类**

```java
public class a{
	class b{}
}
```

**静态内部类**

```java
public class a{
	static class b{}
}
```

成员内部类是最普通的内部类，它的定义为位于另一个类的内部

**形如下面的形式：**

```java
class` Circle {
  double` radius = 0;
  
  public Circle(double radius) {
 	this.radius = radius;
  }
  
  class Draw {   //内部类
    public void drawSahpe() {
      System.out.println("drawshape");
    }
  }
}
```

![](C:\Users\ASUS.DESKTOP-9718HKU\Desktop\java基础--学习笔记\内部类\成员内部类定义形式.jpg)



**body类中的成员内部类class文件形式：**

![](C:\Users\ASUS.DESKTOP-9718HKU\Desktop\java基础--学习笔记\内部类\成员内部类class形式.jpg)

**成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。**不过要注意的是，当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问：

**内部类访问外部类成员：**

```java
外部类.this.成员变量
外部类.this.成员方法
```

**外部类使用内部类：**

![](C:\Users\ASUS.DESKTOP-9718HKU\Desktop\java学习笔记\内部类\成员内部类使用方法.jpg)

内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。如果成员内部类用private修饰，则只能在外部类的内部访问，如果用public修饰，则任何地方都能访问；如果用protected修饰，则只能在同一个包下或者继承外部类的情况下访问；如果是默认访问权限，则只能在同一个包下访问。这一点和外部类有一点不一样，外部类只能被public和包访问两种权限修饰。我个人是这么理解的，由于成员内部类看起来像是外部类的一个成员，所以可以像类的成员一样拥有多种权限修饰。

## 局部内部类

局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。

**定义**

![](C:\Users\ASUS.DESKTOP-9718HKU\Desktop\java基础--学习笔记\内部类\局部内部类.jpg)

**注意，局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。**

###  匿名内部类

**匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。匿名内部类在编译的时候由系统自动起名为Outter$1.class。一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。**

**定义：**

![](C:\Users\ASUS.DESKTOP-9718HKU\Desktop\java基础--学习笔记\内部类\匿名内部类定义形式.jpg)

![](C:\Users\ASUS.DESKTOP-9718HKU\Desktop\java基础--学习笔记\内部类\Snipaste_2020-05-25_23-23-49.jpg)

**匿名内部类注意事项**：

![](C:\Users\ASUS.DESKTOP-9718HKU\Desktop\java基础--学习笔记\内部类\匿名内部类注意事项.jpg)

##  内部类的使用场景与好处

为什么在Java中需要内部类？总结一下主要有以下四点：

　　1.每个内部类都能独立的继承一个接口的实现，所以无论外部类是否已经继承了某个(接口的)实现，对于内部类都没有影响。内部类使得多继承的解决方案变得完整，

　　2.方便将存在一定逻辑关系的类组织在一起，又可以对外界隐藏。

　　3.方便编写事件驱动程序

　　4.方便编写线程代码

###  补充

关于成员内部类的继承问题。一般来说，内部类是很少用来作为继承用的。但是当用来继承的话，要注意两点：

　　1）成员内部类的引用方式必须为 Outter.Inner.

　　2）构造器中必须有指向外部类对象的引用，并通过这个引用调用super()。

```java
class WithInner {
   class Inner{
    }
}
class` `InheritInner ``extends` `WithInner.Inner {
   
  	// InheritInner() 是不能通过编译的，一定要加上形参
  	InheritInner(WithInner wi) {
    wi.super(); //必须有这句调用
  }
 
    public static void main(String[] args) {
    WithInner wi = ``new` `WithInner();
    InheritInner obj = ``new` `InheritInner(wi);
  }
}
```