import java.util.Random;

/**
 * 1、if ( condition ) { ... }
 * 2、if ( condition ) { ... } else { .... }
 * 3、if ( condition1 )...else if ( condition2 ) ... else 
 */
public class Statement1 {

    public static void main(String[] args) {
        
        // 在 Java 语言中凡是使用 "" 引起来的内容 都是 字符串 ( 对应 String 类型 )
        String name = "张三丰" ; 
        int age = 22 ;
        char gender = '男' ;

        if( age >= 22 && gender == '男' ) {
            System.out.println( name + " , 你可以结婚了" ); // 注意，这里的 + 是字符串连接符，不是算术运算符
        } else {
            System.out.println( name + " , 你还未到结婚年龄" );
        }

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        Random rand = new Random() ; // 创建一个用于产生随机数的对象

        int score = rand.nextInt( 100 ) ; // 随机产生一个 [ 0 , 100 ) 之间的整数

        System.out.println( "score : " + score );

        if( score >= 90 ) {
            System.out.println( "优秀" );
        } else if( score >= 80 ){ // 为嘛不写 score >= 80 && score < 90 呢? 
            System.out.println( "优良" );
        } else if( score >= 70 ){
            System.out.println( "良好" );
        } else if( score >= 60 ){
            System.out.println( "及格" );
        } else if( score >= 0 ){
            System.out.println( "进步空间巨大" );
        } else {
            System.out.println( "不是有效的成绩" );
        }

    }

}
