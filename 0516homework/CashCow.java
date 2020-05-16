public class CashCow {
    private int height;
    private int goldPrice;
    private boolean wormy;
    private int pesticide;
    public void grow(){
        height+=2;
        goldPrice+=10;
    }
    public void buy(){
        if(goldPrice>0){
            goldPrice--;
            pesticide+=100;
        }
    }
    public void kill(){
        if(wormy){
            wormy=false;
            pesticide-=50;
            goldPrice+=5;
        }
    }
    public void watering(){
        goldPrice+=5;
        height+=1;
        wormy=true;
    }
    public void show(){
        System.out.println("摇钱树高度为：" +height);
        System.out.println("金币数量为：" + goldPrice);
        System.out.println("杀虫剂数量为：" + pesticide);
        if(wormy){
            System.out.println("树上有虫子！");
        }else if(wormy =false){
            System.out.println("无虫！健康！");
        }
    }
    public static void main(String[] args) {
        
    }
}