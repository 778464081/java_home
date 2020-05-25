
public class Planet { // 行星

    protected String name ; // 名称
    protected double radius ; // 半径

    public Planet(){
        super();
    }

    public Planet( String name , double radius ) {
        this.name = name ;
        this.radius = radius ;
    }

    public void show(){
        System.out.println( name + " , 半径: " + radius + "km" );
    }

}