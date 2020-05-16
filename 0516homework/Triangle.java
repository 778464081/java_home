public class Triangle {
   public  double firstEdge;
   public  double secondEdge;
   public  double thirdEdge;
   public void squaring(){
    if((firstEdge+secondEdge)>thirdEdge && (firstEdge+thirdEdge)>secondEdge && (secondEdge+thirdEdge)>firstEdge){
    double p;
    p=(firstEdge+secondEdge+thirdEdge)/2;
    double s;
    s=Math.sqrt(p*(p-firstEdge)*(p-secondEdge)*(p-thirdEdge));
    System.out.println("三角形面积为:" + s);
    }else{
        System.out.println("你输入的不是三角形");
    }
 }
   public static void main(String[] args) {
       Triangle t=new Triangle();
       t.firstEdge=30;
       t.secondEdge=40;
       t.thirdEdge=50;
       t.squaring();
   }
}