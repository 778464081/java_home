
/**
 * JDK 1.5 老特性 : 可变长参数
 */
public class Bus {

    /**
     * 在 一个方法的参数列表中，以 ... 形式定义的参数就是可变长参数
     * 在一个方法的参数列表中至多出现一个 可变长参数，并且必须是形参列表中的最后一个
     */
    public void launch( String driver , String...passenger ){
        System.out.print( driver + "师傅为您服务" );

        // 调用 launch 方法时，如果可变长参数部分直接传入的就是 null ，则导致 passenger 变量就是 null
        if( passenger != null ) {
            // System.out.print( "【 length : " + passenger.length + " 】" );
            // 在 方法内部 ，可变长参数可以当做数组来使用
            if( passenger.length > 0 ) {
                System.out.print( " , 车上的乘客有: " );
                for ( int i = 0 ; i < passenger.length ; i++) {
                    System.out.print( passenger[ i ] + "   " );
                } 
            }
        }

        System.out.println();
    }

    public static void main( String[] args ) {

        Bus b = new Bus();

        String driver = "卡巴斯基" ;

        b.launch( driver ); // 注意第二个参数没有指定

        b.launch( driver , "孙悟空"  ); // 在 可变长参数 中传入了一个参数

        b.launch( driver , "孙悟空" , "牛魔王" , "奔波儿灞" ); // 在 可变长参数 中传入了三个参数

        b.launch( driver , null );

    }

}
