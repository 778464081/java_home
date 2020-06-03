package cn.edu.ecut;

public class CellPhone {
	
	public String brand = "一加" ;
	
	public class Screen {
		
		String brand = "京东方" ;
		
		public void show() {
			// 在 实例内部类 中 使用 this 可以引用 该类的当前实例
			System.out.println( this.brand );
			// 通过 "外部类类名.this.字段名" 来引用外部类的实例变量
			System.out.println( CellPhone.this.brand );
		}
		
		public CellPhone getOuter() {
			// 在 实例内部类 中 可以使用 "外部类类名.this" 来引用 外部类的 当前实例
			return CellPhone.this ;
		}
		
	} // end : Screen

}
