package daily;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
       String y =String.valueOf(x);
        byte[] ys = y.getBytes();
        boolean z =true;
        int n=0;
        int m=ys.length-1;
        while(n<m){
            if (ys[n]==ys[m]){
                n++;
                m--;
            }else {
              z=false;
               break;
            }
        }
      return   z;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(1551));
    }
}
