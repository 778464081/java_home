package cn.edu.ecut;

public class Store {

	public void print( Printable p , String content ) {
		p.print(content); // 这里调用的是 Printable 实例的 print 方法
	}
	
	public String copy( Printable p , String content ) {
		return p.copy(content) ; // 这里调用的是 Printable 实例的 copy 方法
	}
	
}
