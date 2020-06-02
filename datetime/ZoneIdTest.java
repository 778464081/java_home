package cn.edu.ecut;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Set;

/**
 * 1、了解 java.time.ZoneId 表示 时区
 * 2、ZoneId.systemDefault() 获取当前操作系统使用的时区
 * 3、ZoneId.getAvailableZoneIds() 获得当前JVM所支持的所有的 时区编号
 * 4、ZoneId.of( String zoneId ) 根据 指定的 时区编号 获得相应的 ZoneId实例
 * 5、对于 LocalDate 来说，时区不同，所表示的 日期也可能不同
 */
public class ZoneIdTest {

	public static void main(String[] args) {
		
		// 使用 ZoneId 类中的 systemDefault 方法获取当前操作系统使用的时区
		ZoneId zid = ZoneId.systemDefault() ;
		System.out.println( zid ); // 可以在 操作系统中 修改时区进行测试
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		// 根据指定的 时区编号( zoneId ) 来获取 相应的 ZoneId实例
		ZoneId zone = ZoneId.of( "US/Alaska" );
		System.out.println( zone );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		LocalDate date = LocalDate.now( zone );
		System.out.println( date );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		date = LocalDate.now();
		System.out.println( date );
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		Locale defaultLocale = Locale.getDefault();
		
		// 获得当前JVM所支持的所有 时区编号( zoneId )
		Set<String>  set = ZoneId.getAvailableZoneIds();		
		Object[] array = set.toArray(); // 将 Set 集合转换为 数组
		for( int i = 0 , n = array.length ; i < n ; i ++ ) {
			String id = (String)array[ i ] ;
			ZoneId zoneId = ZoneId.of( id );
			System.out.println( id + " : " + zoneId.getDisplayName( TextStyle.FULL , defaultLocale ) );
		}

	}

}
