package cn.edu.ecut.enums;

public class SeasonEnumTest {

	public static void main(String[] args) {
		
		SeasonEnum s = SeasonEnum.SPRING ;
		System.out.println( "toString : " + s.toString() );
		System.out.println( "name : " + s.name() );
		System.out.println( "ordinal : " + s.ordinal() );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// SeasonEnum e = new SeasonEnum(); // Cannot instantiate the type SeasonEnum
		
		
		// 调用 SeasonEnum 的 类方法 values 获取 其中所有的 枚举常量
		SeasonEnum[] array = SeasonEnum.values();
		
		for( int i = 0 , n = array.length ; i < n ; i++ ) {
			System.out.println( array[ i ] ); // toString()
		}
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Class<?> c = SeasonEnum.class ;
		System.out.println( c.getSuperclass() ); // java.lang.Enum

	}

}
