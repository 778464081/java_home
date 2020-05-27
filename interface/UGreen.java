package org.malajava;

public class UGreen implements USB {

	@Override
	public void charge() {
		System.out.println( "UGreen : charge" );
	}

	@Override
	public void transmission() {
		System.out.println( "UGreen : transmission" );
	}

}
