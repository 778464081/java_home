
/**
 * 1、了解: 属性 ( property ) 和 字段 ( field ) 不是一个概念 
 * 2、可以通过非私有的方法来访问私有化的字段
 */
public class Chinese {

    private String name ; // name 字段本质上是个变量，用于存储数据
    private int age ;
    private char gender ;
    private boolean married ;

    // 提供用来访问数据的方法 ( 就是读写字段中所持有数据的方法 )
    public String getXingMing(){ // 获取数据的方法 使用 getXxx 命名
        return name ; // 用来获取某个字段取值的方法直接返回相应的字段
    }

    public void setXingMing( String xm ){ // 为字段赋值的方法使用 setXxx 形式命名
        name = xm ;
    }

    //【以下注释混个眼熟，不必深入】
    // getNianLing() ==== 去掉 get 和 参数部分 ====>  NianLing ------首字母变小写、其它字母不变-----> nianLing 
    // 我们将最后得到的 nianLing 称作 属性 ，英文中称作 property ，这与 字段 是不同的
    public int getNianLing(){
        return age ;
    }

    public void setNianLing( int nl ){
        if( nl >= 0 ) {
            age = nl ;
        } else {
            System.out.println( "年龄设置错误" );
        }
    }

    public char getGender(){
        return gender ;
    }

    public void setGender( char gender ){ // 参数名称是 gender ，与本类中的 gender 字段同名
        // 在 Java 语言中 this 可以理解为 汉语中的 "我" ，它表示当前对象本身
        this.gender = gender ; // 为了区分两个不同的 gender 变量，在 gender 字段之前使用了 this 关键字
    }

    public boolean getMarried(){
        return married ;
    }

    public void setMarried( boolean married ){ // 参数名称是 married ，与本类中的 married 字段同名
        this.married = married ; // 为了区分两个不同的 married 变量，在 married 字段之前使用了 this 关键字
    }

    public void show(){
        System.out.println( "我叫" + name + " , 今年" + age + "岁，目前" +  ( married ? "已婚" : "未婚" )  );
    }

}
