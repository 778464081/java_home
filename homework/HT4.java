public class HT4 {
    public static void main(String[] args) {
        yibainei();
        System.out.println();
        yibaige();
    }

    static void yibainei(){
        System.out.println("一百以内的质数有：");
        for (int i = 2; i < 100; i++) {
            boolean zhishu = true;
            //每个数除以它之前的数，是否能整出
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    zhishu = false;
                    break;
                }
            }
            if (zhishu) {
                System.out.print(i + " " );
            }
        }
     }

    static void yibaige(){
        System.out.println("一百个质数有：");
        int count=0;
        for(int i=2;i<10000;i++){
            boolean zhishu = true;
            //每个数除以它之前的数，是否能整出
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    zhishu = false;
                    break;
                }
            }
            if (zhishu) {
                System.out.print(i + " " );
                count++;
            }
            if(count==100){
                break;
            }
        }
    }
}