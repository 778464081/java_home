
/**
 * 重载的好处是，用起来爽
 */
public class Dog { 


    public int add( int a , int b) {
        System.out.println( "int add( int , int )" );
        return a + b ;
    }

    public int add( int a , int b , int c ) {
        System.out.println( "int add( int , int , int)" );
        return a + b + c ;
    }

    public long add( long a , long b ) {
        System.out.println( "long add( long , long )" );
        return a + b ;
    }

    public static void main(String[] args) {
        
        Dog d = new Dog();

        d.add( 100 , 200 );

        d.add( 100L , 200 );

    }

}
