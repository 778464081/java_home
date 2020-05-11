
/**
 * 1、为了分类而分类: 将二维数组分为 规则二维数组 和 不规则二维数组
 *      如果某个数组内部的 所有数组长度都相同，则这个二维数组就是规则二维数组，否则就是 不规则二维数组
 * 2、使用 两重 for 循环 遍历二维数组
 */
public class Array7 {

    public static void main(String[] args) {

        // 不规则二维数组
        char[][] first = { 
                                    { '狼' , '烟' , '起' } , 
                                    { '江' , '山' , '北' , '望' } ,
                                    { '龙' , '起' , '卷' , '马' , '长' , '嘶' , '剑' , '气' , '如' , '霜' } , 
                                    { '心' , '似' , '黄' , '河' , '水' , '茫' , '茫' } 
                                } ;

        for( int i = 0 ; i < first.length ; i++ ) {
            for( int j = 0 ; j < first[ i ] .length  ;j++ ) {
                // i 表示外部数组中下标是 i 的元素(是个数组)， j 表示 内部数组中下标是 j 的元素(是个字符)
                char ch = first[ i ] [ j ] ; 
                System.out.print( ch + " " );
            }
            System.out.println();
        }

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        // 规则二维数组
         char[][] second =  {
                                        { '青' , '海' , '长' , '云' , '暗' , '雪' , '山' } ,
                                        { '孤' , '城' , '遥' , '望' , '玉' , '门' , '关' } ,
                                        { '黄' , '沙' , '百' , '战' , '穿' , '金' , '甲' } ,
                                        { '不' , '破' , '楼' , '兰' , '终' , '不' , '还' }
                                    };     
                                    
        for( int i = 0 ; i < second.length ; i++ ) {
            // for( int j = 0 ; j < second[ i ] .length  ;j++ ) {
            for( int j = 0 ; j < second[ 0 ] .length  ;j++ ) {
                char ch = second[ i ] [ j ] ;
                System.out.print( ch + " " );
            }
            System.out.println();
        }                          

    }

}
