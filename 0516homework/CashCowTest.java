import java.util.Random;

public class CashCowTest {
    public static void main(String[] args) {
        Random random =new Random();
        CashCow cc = new CashCow();
        for(int i=0;i<10;i++){
            int x=random.nextInt(4);
            switch(x){
                case 0:cc.grow();
                case 1:cc.buy();
                case 2:cc.kill();
                case 3:cc.watering();
                break;
            }
        }
        cc.show();
    }
}