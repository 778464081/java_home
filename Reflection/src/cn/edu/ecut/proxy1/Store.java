package cn.edu.ecut.proxy1;

public class Store implements HuaWei {
	
	private HuaWei hw ;
	
	public Store(HuaWei hw) {
		super();
		this.hw = hw;
	}

	@Override
	public String produce() {
		System.out.println( "降低成本，控制进货价格" );
		String p = hw.produce() ;
		System.out.println( "提高售价，提升利润空间" );
		return p;
	}

}
