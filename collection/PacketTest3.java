package org.malajava;

public class PacketTest3 {

	public static void main(String[] args) {
		
		Packet<String> p = new Packet<>();
		
		p.add( "韩信" );
		p.add( "晁错" );
		p.add( "窦婴" );
		
		System.out.println( p );
		
		Packet<String> a = new Packet<>();
		
		a.add( "李广" );
		a.add( "李敢" );
		a.add( "李凌" );
		
		System.out.println( a );
		
		System.out.println( p.addAll( a ) );
		
		System.out.println( p );

	}

}
