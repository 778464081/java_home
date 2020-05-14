public class HT7 {
    public static void main(String[] args) {
        char[][]  chunxiao = {  
            { '春' , '眠' , '不' , '觉' , '晓' }  , 
            { '处' , '处' , '蚊' , '子' , '咬' } , 
            { '打' , '上' , '敌' , '敌' , '畏' } , 
            { '不' , '知' , '死' , '了' , '谁' } 
          };
      for(int i=0;i<4;i++){
          for(int j=0;j<5;j++){
              System.out.print(chunxiao[i][j] + " ");
          }
          System.out.println();
      }


      for(int i=0;i<5;i++){
        for(int j=3;j>=0;j--){
            System.out.print(chunxiao[j][i] + " ");
        }
        System.out.println();
      }


    }
}