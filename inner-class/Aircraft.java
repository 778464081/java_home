package cn.edu.ecut;

public class Aircraft {
	
	public String type ;
	
	public Aircraft(){
		super();
	}
	
	public Aircraft( String type ){
		super();
		this.type = type ;
	}
	
	public void fly() {
		System.out.println( "飞行中..." );
	}
	
	public void travel() {
		System.out.println( "行驶中..." );
	}

}
