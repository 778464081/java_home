public class ArrayHelper{
    public static boolean equal(int[] first,int[] second){
        int[] fir=first;
        int[] sec=second;
        if(fir.length==sec.length){
            for(int i=0;i<fir.length;i++){
                if(fir[i]!=sec[i]){
                   return false;
                }

            }   
            return true; 
        }
        return false;

    }
    public static void main(String[] args) {
        int[] x={1,2,3,4};
        int[] y={1,2,3,4};
        System.out.println(  ArrayHelper.equal(x,y));
      
    }
}