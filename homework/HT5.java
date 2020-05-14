import java.util.Random;
import java.util.Scanner;

public class HT5 {
    public static void main(String[] args) {
    int n=10; 
    Random rand =new Random();
    int r =rand.nextInt(1000);   
    Scanner in =new Scanner(System.in);
    while(n!=0){
         System.out.println(r);
     
        System.out.println("请输入一个数（1~~1000）");
        int x;
        x=in.nextInt();
        if(x>r){
            System.out.println("太大了，再小点");
            n--;
        }
        if(x<r){
            System.out.println("太小了，再大点");
            n--;
        }
        if(x==r){
            System.out.println("恭喜你猜对了！");
            break;
        }
        if(n==0){
            System.out.println("你太笨了吧,下次再来吧！");
            break;
        }
    }
    in.close();
  }
}
