package cn.edu.ecut;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class ReferenceTest2 {

	public static void main(String[] args) {
		
		RuntimeHelper.gc();
		RuntimeHelper.showMemory();
		
		// 使用 强引用 关联一个 ArrayList 实例
		ArrayList<String> list = new ArrayList<>();
		
		// 创建一个 软引用 ( Soft Reference ) ，它关联了 list 变量所引用的对象
		SoftReference< ArrayList<String> > softRef = new SoftReference<>( list );
		
		list = null ; // 取消对新创建的 ArrayList 实例的强引用
		
		// 因为将 软引用关联的对象直接赋值给了 list 变量，所以 list 变量是 ArrayList 实例的强引用
		list = softRef.get(); // 通过 SoftReference 实例的 get 方法可以获取 软引用 所关联的对象
		for( int i = 0 ; i < 59000 ; i++ ) {
			list.add( new String( i + "" ) );
		}
		
		list = null ; 
		
		RuntimeHelper.gc(); // 可以通过 增加 或 删除 这行代码来对比
		RuntimeHelper.showMemory();

	}

}
