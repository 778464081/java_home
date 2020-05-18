
 public class Undergraduate {

    public String name ;
    public char gender ;

    // 判断 自己 ( 我 ) 和 对方 ( partner ) 是否可以结婚
    // 判断 当前对象 ( this ) 和 参数传入的对象 ( partner ) 是否可以结婚
    public boolean marry( Undergraduate partner ) {
        // 暂时只考虑 性别，异性可以结婚
        if( ( this.gender == '男' && partner.gender == '女' ) || ( this.gender == '女' && partner.gender == '男' ) ) {
            return true ;
        } 
        return false ;
    }

    public static void main(String[] args) {

        Undergraduate first = new Undergraduate();
        first.name = "杨过" ;
        first.gender = '男' ;

        Undergraduate second = new Undergraduate();
        second.name = "郭芙" ;
        second.gender = '女' ;

        boolean x = second.marry( first ); // 此时，在 marry 内部，this 就表示 second 对应的对象，partner 就表示 first 对应的对象
        System.out.println( x );

        Undergraduate third = new Undergraduate();
        third.name = "小武" ;
        third.gender = '男' ;

        x = third.marry( first );
        System.out.println( x );
        
    }

}