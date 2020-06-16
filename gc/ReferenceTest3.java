package cn.edu.ecut;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ReferenceTest3 {

	public static void main(String[] args) {
		
		RuntimeHelper.gc();
		RuntimeHelper.showMemory();
		
		// 使用 强引用 关联一个 ArrayList 实例
		ArrayList<String> list = new ArrayList<>();
		
		// 创建一个 弱引用 ( Weak Reference ) ，它关联了 list 变量所引用的对象
		WeakReference< ArrayList<String> > weakRef = new WeakReference<>( list );
		
		list = null ; // 取消对新创建的 ArrayList 实例的强引用
		
		// 因为将 弱引用关联的对象直接赋值给了 list 变量，所以 list 变量是 ArrayList 实例的强引用
		list = weakRef.get(); // 通过 WeakReference 实例的 get 方法可以获取 弱引用 所关联的对象
		
		for( int i = 0 ; i < 59000 ; i++ ) {
			list.add( new String( i + "" ) );
		}
		
		RuntimeHelper.showMemory();
		
		list = null ; 
		
		RuntimeHelper.gc(); // 可以通过 增加 或 删除 这行代码来对比
		RuntimeHelper.showMemory();

	}

}
