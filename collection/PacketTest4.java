package org.malajava;

public class PacketTest4 {

	public static void main(String[] args) {
		
		Packet<String> p = new Packet<>();
		
		p.add( "韩信" );
		p.add( "晁错" );
		p.add( "窦婴" );
		p.add( "李广" );
		p.add( "李敢" );
		p.add( "李凌" );
		p.add( null );
		
		Packet<String> a = new Packet<>();
		
		a.add( "李广" );
		a.add( "李敢" );
		a.add( "李凌" );
		a.add( null );
		
		System.out.println( p.containsAll( a )  );
		
		// System.out.println( p.removeAll( a ) );
		System.out.println( p.retainAll( a ) );
		
		System.out.println( p );
	
	}

}
