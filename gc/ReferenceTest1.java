package cn.edu.ecut;

import java.util.ArrayList;
import java.util.List;

public class ReferenceTest1 {

	public static void main(String[] args) {
		
		RuntimeHelper.gc();
		RuntimeHelper.showMemory();
		
		String s = new String( "hello" );
		List<String> list = new ArrayList<>();
		list.add( s );
		
		String[] array = new String[ 10 ];
		array[ 0 ] = s ;
		
		RuntimeHelper.gc();
		RuntimeHelper.showMemory();
		
		// 去除强引用
		s = null;
		list = null ;
		array[ 0 ] = null ;
		array = null ;
		
		RuntimeHelper.gc();
		RuntimeHelper.showMemory();

	}

}
