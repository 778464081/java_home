package cn.edu.ecut;

public class StoreTest {

	public static void main(String[] args) {
		
		Store s = new Store();
		
		Printable p = new Printable() {
			String name = "HP打印机" ; // 匿名类的实例变量
			@Override
			public void print(String content) {
				System.out.println( this.name + " 正在打印 " + content );
			}
			
			@Override
			public String copy(String content) {
				System.out.println( this.name + " 正在复印 " + content );
				String s = new String( content );
				return s ;
			}
		};
		
		s.print( p , "犯我中华者虽远必诛" );
		
		s.print( new Printable() {
			String name = "爱普生打印机" ; // 匿名类的实例变量
			@Override
			public void print(String content) {
				System.out.println( this.name + " 正在打印 " + content );
			}
			
			@Override
			public String copy(String content) {
				System.out.println( this.name + " 正在复印 " + content );
				String s = new String( content );
				return s ;
			}
		} ,  "犯我中华者虽远必诛" );

	}

}
