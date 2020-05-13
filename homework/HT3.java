import java.util.Scanner;

//Integer.toBinaryString(-11) 将-11转换成二进制

public class HT3 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("输入一个整数：");
        int w = in.nextInt();
        if(w>0){
            System.out.println("你输入的整数为正整数！");
            int sum;
            String c ="";
            while(w!=0){
                sum = w%2;
                c =sum + c;
                w=w/2;
            }
            int f =32-c.length();
            for(int i=0;i<f;i++){
                c=0 +c;
            }
            System.out.println("其二进制为：" +c);
        }else if(w==0){
            System.out.println("你输入的数为0");
        }else{
            w=-w;
            int sum;
            String c ="";
            while(w!=0){
                sum = w%2;
                c =sum + c;
                w=w/2;
            }
            int f =32-c.length();
            for(int i=0;i<f;i++){
                c=0 +c;
            } 
             String x ="";
           for(int i=0;i<c.length();i++){
             
               if(c.charAt(i)=='1'){
                   x=x+0;
               }else if(c.charAt(i)=='0'){
                   x=x+1;
               }
           }    
       
           System.out.println("其二进制为：" + );
        }
    }
}