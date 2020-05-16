
    public class jiazi {
    public static void main(String[] args) {
    int count=0;
    String arr[]={"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
    String arr1[]={"子","丑","寅","卯","辰来","巳","午","未","申源","酉","戌","亥"};
     for(int i=0;i<arr.length;i++){
             for(int j=0;j<arr1.length;j++){
              count++;
             if(count%10==0){
          System.out.println(arr[i]+arr1[j]);
    }
    else{
    System.out.print(arr[i]+arr1[j]+", ");
    }
    }
    }
    }
    }