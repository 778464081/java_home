
    public class jiazi {
        public static void main( String[] args ) {
  
            char[] heavenlyStems = { '甲' , '乙' , '丙' , '丁' , '戊' , '己' , '庚' , '辛' , '壬' , '癸' };
            
            char[] earthlyBranches = { '子' , '丑' , '寅' , '卯' , '辰' , '巳' ,'午' , '未' , '申' , '酉' , '戌' , '亥' };
           int x;
           int y;
            for(int i=0;i<60;i++){
                x=i%10;
                y=i%12;
                System.out.print(heavenlyStems[x] + "" + earthlyBranches[y] + " ");
                if((i+1)%12==0 ){
                    System.out.println();
                }
            }
          }
    }