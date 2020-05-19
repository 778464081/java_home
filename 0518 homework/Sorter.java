public class Sorter {
    public void traversal( int[] array ){
        if( array != null && array.length > 0 ) {
            for( int i = 0 ; i < array.length ; i++ ){
                System.out.print( array[ i ] );
                System.out.print( ( i < array.length - 1 ) ? " , " : "" );
            }
            System.out.println();
        }
    }

    public int[] sort( int[] arr ) {
        // 实现排序并返回一个新数组j 
        int[] array =new int[arr.length];
         for(int i=0;i<arr.length;i++){
            array[i]=arr[i];
        }
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int x;
                    x=array[j];
                    array[j]=array[j+1];
                    array[j+1]=x;
                }
            }
        }
       
        return array;
    }

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        int[] a = { 1 , 100 , -20 , 99 , 1000 , 0 , 30 };
        System.out.print( "原数组: " );
        sorter.traversal( a ); // 原数组: 1 , 100 , -20 , 99 , 1000 , 0 , 30
        int[] x = sorter.sort( a ) ;
        System.out.print( "新数组: " );
        sorter.traversal( x ); // 新数组: -20 , 0 , 1 , 30 , 99 , 100 , 1000
        System.out.print( "原数组: " );
        sorter.traversal( a ); // 原数组: 1 , 100 , -20 , 99 , 1000 , 0 , 30
    }
}