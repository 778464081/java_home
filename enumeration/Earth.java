package cn.edu.ecut.enums;

public enum Earth {
	EARTH ( "目前人类唯一的家园" ) ;
	
	private String description ;

	private Earth(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "名称 : " + super.toString() + " , 描述 : " + description ; 
	}
	
	
}
