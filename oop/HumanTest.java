
public class HumanTest {

    public static void main(String[] args) {

        Human h = new Human();
        h.name = "令狐冲" ;
        // h.married = true ; //【编译失败】错误: married 在 Human 中是 private 访问控制

        h.show();

    }

}