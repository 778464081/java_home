
import java.util.Scanner ;

public class Statement3 {

    public static void main(String[] args) {

        // 创建一个可以读取用户在控制台中输入内容的扫描器
        Scanner sc = new Scanner( System.in ); // 暂时只使用不详细研究

        System.out.println( "请输入一个月份名称，比如 一月、二月、正月、腊月" );
        String month = sc.nextLine(); // 读取用户在控制台中输入的内容(读取到换行符为止)

        switch( month ) {
            default :
                System.out.println( "这个月份我判断不了" ); 
                break ;
            case "一月" :
            case "正月" :
            case "十二月" :
            case "腊月" :
                System.out.println( "三十一天" );  // 注意: 这里不考虑农历
                break ;
            case "二月" :
                System.out.println( "平年二十八天、闰年二十九天" ); // 注意: 这里不考虑农历
                break ;
        }


         // 关闭扫描器
        sc.close();
    }

}
