package object;
/**
 * 1、任意一个类型都可以通过 .class 来获取该类型对应的 Class 实例
 * 2、基本数据类型 和 数组 都可以 通过 .class 来获取其相应的 Class 实例 【啰嗦一句】
 * 3、所有的引用类型也都可以 通过 .class 来获取其相应的 Class 实例【啰嗦二句】
 * 4、全限定名称
 *      对于 基本数据类型 来说就是 类型名称，
 *      对于 数组类型 来说，都是 [  和 相应类型的字母组成
 *      对于 类 和 接口 来说 就是 包名.类名 或 包名.接口名 【不针对内部类和内部接口】
 */
public class Smilodon { 

    public static void main(String[] args) {
        
        Class ic = int.class ;
        // 由 java.lang.Class 类定义的 getName() 方法 可以获得相应类型的全限定名称
        System.out.println( ic.getName() ); 

        Class oc = Object.class ;
        System.out.println( oc.getName() ); 

        Class iac1 = byte[].class ;
        System.out.println( iac1.getName() ); 

        Class iac2 = boolean[][].class ;
        System.out.println( iac2.getName() ); 

        Class cc = Smilodon.class ;
        System.out.println( cc.getName() ); 

        Class interClass = java.util.List.class ; // List 还没讲到
        System.out.println( interClass.getName() ); 


    }

}
