
public class Human {

    // 被 public 修饰的 字段 或 方法 可以在 任意位置 使用
    public String name ; // 实例变量
    // 被 private 修饰的 字段 或 方法 只能在本类中使用
    private boolean married ; // 实例变量

    public void show(){
        System.out.println( "我是 " + name + " ，目前 " + ( married ? "已婚" : "未婚" ) );
    }

    public static void main(String[] args) {

        Human h = new Human();
        h.name = "令狐冲" ;
        h.married = false ;

        h.show();

    }

}
