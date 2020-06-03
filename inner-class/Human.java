package cn.edu.ecut;

public abstract class Human {
	
	public String name ;
	
	public Human() {
		super();
		System.out.println( "Human()" );
	}
	
	public Human( String name ) {
		super();
		this.name = name ;
		System.out.println( "Human( String )" );
	}
	
	public abstract void eat( String food );

}
