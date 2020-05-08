
/**
 * 在 switch 关键字之后的 ( ) 中可以使用那些类型:
 * 1、JDK 1.5 之前只能使用 与 int 兼容的类型，比如 int 、char 、short 、byte 
 * 2、从 JDK 1.5 开始允许在 switch 语句中使用 枚举类型 ( enum ) 【 以后讲 enum 】
 * 3、从 JDK 1.7 开始允许在 switch 语句中使用 String 类型
 */
import java.util.Random ;

public class Statement2 {

    public static void main(String[] args) {

        Random rand = new Random() ;

        int month = rand.nextInt( 12 ) ; // 随机产生一个 [ 0 , 12 ) 之间的整数
        month += 1 ; // month = month + 1 ; // 在中国，月份是从 1 开始的
        System.out.println( "month : " + month ); // [ 1 , 12 ]

        /*
        if( month == 2  ) {
            System.out.println( "平年28天、闰年29天" ) ;
        } else if ( month == 4 || month == 6 || month == 9 || month == 11 ){
            System.out.println( "30天" ) ;
        } else if ( month == 1 || month == 3 || month == 5 || month == 7  || month == 8 || month == 10 || month == 12 ){
            System.out.println( "30天" ) ;
        } else {
            System.out.println( "31天" ) ;
        }
        */

        char m = (char) month ;
        switch (  m ) { // switch 语句块开始
                case 2:
                    System.out.println( "平年28天、闰年29天" ) ;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println( "30天" ) ;
                    break; // bread 会跳出当前的 switch 语句块
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println( "31天" ) ;
                    break; // bread 会跳出当前的 switch 语句块
                default:
                    System.out.println( "无效的月份" ) ;
                    break;
        } // switch 语句块结束

        // 月份：1 、2、3、4、5、6、7、8、9、10、11、12
        // 星期: 一、二、三、四、五、六、日



    }

}
