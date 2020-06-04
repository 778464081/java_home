package cn.edu.ecut.enums;

import java.util.Arrays;

public class GenderEnumTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		System.out.println( GenderEnum.FEMALE );
		System.out.println( GenderEnum.MALE );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 编译器 为 每一个 枚举类增加了一个 valueOf( String ) 方法，用于根据 枚举常量名称 获取 枚举常量
		GenderEnum g = GenderEnum.valueOf( "FEMALE" ); // 参数是 枚举常量名称 ( 英文字母严格区分大小写 )
		System.out.println( g );
		System.out.println( g == GenderEnum.FEMALE );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		GenderEnum[] array = GenderEnum.values();
		System.out.println( Arrays.toString( array ) );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// java.lang.Enum 类中的 类方法 valueOf 可以通过 Enum 类来调用
		GenderEnum x = Enum.valueOf( GenderEnum.class ,  "MALE" );
		System.out.println( x );
		
		// java.lang.Enum 类中的 类方法 valueOf 可以通过其 子类 来调用
		GenderEnum y = GenderEnum.valueOf( GenderEnum.class ,  "MALE" );
		System.out.println( y );
	}

}
