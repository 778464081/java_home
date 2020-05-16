public class Cylinder {
    public double radius;
    public double height;
    public double pi=3.14;
    public void squaring(){
        double s=2*pi*radius*radius+2*pi*radius*height;
        System.out.println("表面积为：" +s);
    }
    public void cube(){
        double v= pi * radius *radius *height;
        System.out.println("体积为：" + v);
    }
    public static void main(String[] args) {
       Cylinder c =new Cylinder();
       c.radius =20;
       c.height =20;
       c.squaring();
       c.cube(); 
    }
}