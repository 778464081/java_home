package cn.oracle;

public class StringTest3 {
	
	public static void main(String[] args) {
		
		String s = "abc123" ;
		s.hashCode() ; // 首次调用 hashCode 方法会将 相应 字符串 的 哈希码值 缓存在 实例变量 hash 中
		StringHelper.perspective( s ); // 透视某个字符串实例
		
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		
		String t = new String( "abc123" );
		StringHelper.perspective( t );
		
		System.out.println( "= = = = = = = = = = = = = = = = = =" );
		
		StringHelper.perspective( s ); 
		System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );
		StringHelper.perspective( t );
		
	}

}
