package cn.edu.ecut.enums;

/**
 * 因为在 Git 仓库中 已经存在名称为 Season.java 的文件，所以这里才将类名命名为 SeasonEnum 。
 * 将来定义枚举时，不要在 名称中 加 Enum 后缀 。
 */
public enum SeasonEnum {
	
	// 枚举中 第一个 分号 之前 用来列出枚举常量 ( 常量名称全部大写 )
	// 如果存在多个枚举常量，则 多个枚举常量之间使用 逗号隔开
	SPRING( "春暖花开" ) , SUMMER , AUTUMN , WINTER ;
	// SPRING 等同于 public static final SeasonEnum SPRING = new SeasonEnum();
	// SPRING( "春暖花开" ) 等同于 public static final SeasonEnum SPRING = new SeasonEnum( "春暖花开" );
	
	// 枚举 是一种特殊的类，因此 枚举 可以有自己的 成员变量 、构造方法、成员方法 等
	private String description ; // 实例变量 ( 成员变量 )
	
	// 枚举的构造方法都是私有的，即使不写 private 修饰符也是私有的
	SeasonEnum() {
		// 编译器会自动生成这里的 super( ... ) 代码
		System.out.println( "private SeasonEnum()" );
	}
	
	private SeasonEnum( String description ) {
		// 编译器会自动生成这里的 super( ... ) 代码
		this.description = description ;
		System.out.println( "private SeasonEnum( String )" );
	}
	
	// 成员方法
	public String getDescription() {
		return description ;
	}

}
