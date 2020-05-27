package org.malajava;

public class HuaWei implements USB {

	@Override
	public void charge() {
		System.out.println( "HuaWei : charge" );
	}

	@Override
	public void transmission() {
		System.out.println( "HuaWei : transmission" );
	}

}
