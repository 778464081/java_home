package ecut.map;

import java.util.Arrays;
/**
 * 如果某个数组中的所有元素 都可以 根据同一个的规则计算出其索引，
 * 也就是，
 * 向数组中添加新元素时，可以根据 元素 计算出 该元素 应该放在数组中哪个位置，
 * 则这种数组就是所谓的 "哈希表"
 */
public class HashTest1 {

	public static void main(String[] args) {
		
		int[] array = new int[ 10 ];
		
		System.out.println( Arrays.toString( array ) );
		
		int value = 7 ;
		
		int index = value % array.length ; // 通过某种规则可以计算出 某个值 应该存放在数组的哪个位置
		
		array[ index ] = value ;
		
		System.out.println( Arrays.toString( array ) );

	}

}
