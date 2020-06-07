package cn.oracle;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListHelper {
	
	private static Field elementDataField ;
	
	static {
		try {
			elementDataField = ArrayList.class.getDeclaredField( "elementData" );
			elementDataField.setAccessible( true );
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void perspective( final ArrayList list ) {
		
		try {
			Object value = elementDataField.get( list ) ;
			int length = Array.getLength( value );
			System.out.println( "List容量: " + length );
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}
