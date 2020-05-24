package object;
public class Shape {

    protected double area ;  // 存储面积的实例变量

    private String type ; // 图形类型

    public Shape( String type ) {
        this.type = type ;
    }

    public void calculate() {
        System.out.println( "计算" + this.type + "的面积" );
    }

    public void show(){
        System.out.println( this.type + "的面积为" + this.area );
    }

}
