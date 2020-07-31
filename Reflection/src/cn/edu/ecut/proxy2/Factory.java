package cn.edu.ecut.proxy2;

public class Factory implements Mi {

	@Override
	public String produce() {
		String p = "小米10Pro" ;
		System.out.println( "Factory#produce()" );
		return p ;
	}

}
