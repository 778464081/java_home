package ecut ;

//【编译失败】错误: Human 在 cn.edu.ecut 中不是公共的; 无法从外部程序包中对其进行访问
import cn.edu.ecut.Human ; // 对于 非同包 中的 非 public 修饰的类，即使 import 了也仍然不可用

public class HumanTest2 { 

    public static void main(String[] args) {
        Human h = new Human();
        h.sleep();
    }

}