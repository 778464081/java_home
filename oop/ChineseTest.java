
public class ChineseTest {


    public static void main(String[] args) {

        Chinese c = new Chinese();
        // c.name = "张翠山" ; // 【编译】错误: name 在 Sinaean 中是 private 访问控制
        c.setXingMing( "张翠山" );
        // c.age = 28 ;
        c.setNianLing( 28 );
        // c.gender = '男' ;
        c.setGender( '男' );
        // c.married = true ;
        c.setMarried( true );

        c.show();

        System.out.println( c.getXingMing() + " , " + c.getNianLing() + " , " + c.getMarried() );

    }


}
