package org.malajava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacketTest2 {

	public static void main(String[] args) {
		
		Packet<String> p = new Packet<>();
		
		p.add( "韩信" );
		p.add( "晁错" );
		p.add( "窦婴" );
		
		System.out.println( p );
		
		Object[] objects = p.toArray();
		System.out.println( Arrays.toString( objects )  );
		
		final String[] array = { } ; // 声明一个 String 类型的数组，并使用 数组常量 将其初始化
		System.out.println( array.length );
		System.out.println( Arrays.toString( array )  );
		
		String[] names = p.toArray( array );
		System.out.println( "names : " + Arrays.toString( names )  );
		System.out.println( "array : " + Arrays.toString( array )  );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		List<String> list = new ArrayList<>( List.of( "李广" , "李敢" , "李凌" ) );
		
		Object[] os = list.toArray();
		System.out.println( Arrays.toString( os )  );
		
		String[] sa = list.toArray( array );
		System.out.println( Arrays.toString( sa )  );

	}

}
