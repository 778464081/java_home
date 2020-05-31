package cn.oracle;

public final class CharacterStrings extends Object implements CharSequence {
	
	private final  char[] value ;
	private final int size ;
	
	public CharacterStrings( String s ) {
		if( s == null ) {
			this.value = null ;
			this.size = -1 ;
		} else {
			this.size = s.length() ;
			this.value = new char[ this.size ];
			s.getChars( 0 ,  size , value , 0 );
		}
	}

	@Override
	public int length() {
		return size ;
	}

	@Override
	public char charAt(int index) {
		if( index >= 0 && index <= size ) {
			return value[ index ] ;
		}
		return 0 ;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		if( start >= 0 && end <= size && start < end ) {
			String s = new String( value , start , end );
			CharacterStrings cs = new CharacterStrings( s );
			return cs ;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return new String( this.value );
	}
	
	public static void main(String[] args) {
		
		CharacterStrings s = new CharacterStrings( "hello,world" );
		System.out.println( s.length() );
		System.out.println( s );
		
		CharSequence c = s.subSequence( 0 ,  6 );
		System.out.println( c.length() );
		System.out.println( c );
		
	}
	
}
