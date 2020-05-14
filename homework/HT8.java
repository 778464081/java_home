import java.util.Scanner;
public class HT8 {
    public static void main(String[] args) {
      String e= new String();
      Scanner in =new Scanner(System.in);
      System.out.println("输入一个二进制数：");
      e=in.next();
      int x=0;
      for(int i=0;i<e.length();i++){
          if(e.charAt(i)=='0'){
            x=x+(int)Math.pow(2, e.length()-i-1)*0;
          }else if(e.charAt(i)=='1'){
            x=x+(int)Math.pow(2, e.length()-i-1)*1;
          }else{
              System.out.println("你输入的不是二进制数！");
              break;
          }
      }
      System.out.println("其二进制为："+x);
      in.close();
    }
}