package object;
/**
 * 即使某个类重写了 hashCode 方法，仍然可以通过 identityHashCode 方法来获取原本由  Object 提供的 hashCode 所返回的 哈希码值
 */
public class Sheep {

    private int age ;
    private int weight ; // kg

    public Sheep( int age , int weight ) {
        this.age = age ;
        this.weight = weight ;
    } 

    @Override
    public int hashCode(){
        System.out.println( super.hashCode() );
        // 暂时不考虑实现细节一律返回 零
        return 0 ;
    }

    public static void main(String[] args) {
        
        Sheep s = new Sheep( 5 , 30 );
        System.out.println( s.hashCode() );
        // 即使某个类重写了 hashCode 方法，仍然可以通过 identityHashCode 方法来获取原本由  Object 提供的 hashCode 所返回的 哈希码值
        System.out.println( System.identityHashCode( s ) );

        Sheep h = new Sheep( 6 , 35 );
        System.out.println( h.hashCode() );
        System.out.println( System.identityHashCode( h ) );

        System.out.println( s == h );

    }

}
