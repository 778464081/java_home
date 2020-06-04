package cn.edu.ecut.enums;

public enum GenderEnum {
	
	FEMALE( "靓妹" ) , MALE( "靓仔" );
	
	private String description ;

	private GenderEnum(String description) {
		this.description = description;
	}

	@Override
	public String toString() { 
		// 枚举可以重写从 java.lang.Enum 类中继承的 toString()
		// java.lang.Enum 类重写了从 java.lang.Object 继承的 toString 方法
		return super.toString() + " : " + description ;
	}
	
}
