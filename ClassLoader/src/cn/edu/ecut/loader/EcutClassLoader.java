package cn.edu.ecut.loader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EcutClassLoader extends ClassLoader {
	
	private String path ;
	
	public EcutClassLoader( String path ) {
		this.path = path ;
	}

	@Override
	protected Class<?> findClass( final String name ) 
			throws ClassNotFoundException {
		System.out.println( "被加载的类是: " + name );
		
		String filename = name.replace( "." , "/" ) + ".class" ;
		System.out.println( "文件名称: " + filename  );
		
		filename = path + "/" + filename ;
		System.out.println( "文件路径: " + filename  );
		
		try {
			FileInputStream in = new FileInputStream( filename );
			final byte[] bytes = in.readAllBytes();
			in.close();
			// 使用父类提供的 defineClass 定义一个 Class 对象
			Class<?> c = this.defineClass( name , bytes , 0 , bytes.length );
			return c ;
		} catch (FileNotFoundException e) {
			throw new ClassNotFoundException( "不是我跟你吹，这个类真的不存在" );
		} catch (IOException e) {
			throw new RuntimeException( "读取字节码时发生错误" ); 
		}
	}

}
