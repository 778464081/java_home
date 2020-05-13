import java.util.Scanner;

public class HT1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int f;
        int c;
        System.out.println("请输入华氏度：");
        f=in.nextInt();
        c=5*(f-32)/9;
        System.out.println(f + "华氏度换算成摄氏度为：" + c );
        in.close();
    }
}