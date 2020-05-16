
public class Sinaean {

    private String name ;
    private int age ;
    private char gender ;
    private boolean married ;

    public void show(){
        System.out.println( "我叫" + name + " , 今年" + age + "岁，目前" +  ( married ? "已婚" : "未婚" )  );
    }

    public static void main(String[] args) {

        Sinaean s = new Sinaean();
        s.name = "毛雨欣" ; // 本类中访问 本类实例 的 私有字段
        s.age = 18 ;
        s.gender = '男' ;
        s.married = false ;

        s.show();

    }

}
