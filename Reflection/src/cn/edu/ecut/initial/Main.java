package cn.edu.ecut.initial;

public class Main {

	public static void main(String[] args) {
		
		Sinaean s = null ; // 被动使用 Sinaean
		
		System.out.println( "- - - - - - - - - - - - - - -" );
		
		// 当子类被初始化时，首先初始化其父类
		s = new Sinaean(); // 主动使用 Sinaean
		System.out.println( System.identityHashCode( s ) );
		
		System.out.println( "- - - - - - - - - - - - - - -" );
		
		s = new Sinaean();
		System.out.println( System.identityHashCode( s ) );

	}

}
