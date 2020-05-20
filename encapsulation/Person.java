package cn.edu.ecut ; // 一个源文件中至多出现一个 package 语句

// 一个源代码文件中至多出现一个 public 修饰的 class 
// 如果源代码文件存在 public 修饰的 class 则该文件名称必须与 public 修饰的 class 名称相同
public class Person { 

    public void eat( String foodName ) {
        System.out.println( "人可以吃" + foodName );
    }

}

// 没有 public 修饰的 class 只能在本包内部使用
class Human {

    public void sleep() {
        System.out.println( "人可以睡觉" );
    }
    
}
