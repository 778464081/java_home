import java.util.Scanner;

public class HT2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("请输入一个字符：");
        String tr1 =in.nextLine();
        char str=tr1.charAt(0);
        if(str>='a' && str<='z'){
            str-=32;
            System.out.println("你输入的是小写字母" + (char)(str+32) +"对应的大写字母为" + str);
        }else if(str>='A' && str<='Z'){
            System.out.println("你输入的是大写字母"+str);
        }else{
            System.out.println("你输入的不是英文字母");
        }in.close();
    }
        
}