import java.util.Random;

public class HT6 {
    public static void main(String[] args) {
        int[] arr =new int[7];
        Random rand = new Random();
        arr[0]=rand.nextInt(33)+1;
        for(int i=1;i<7;i++){  
            arr[i]=rand.nextInt(33)+1;
            for(int j=0;j<i;j++)
            if(arr[j]==arr[i]){
                arr[i]=rand.nextInt(33)+1;
                continue;
            }
        }

        for(int i=0;i<7;i++){
            System.out.print(arr[i] + " ");
        }  

    }
}