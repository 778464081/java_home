package cn.edu.ecut;

public class Tiger extends Animal {

	@Override
	public void breathe() {
		System.out.println( "虎类是用肺呼吸的" );
	}

	@Override
	public void move() {
		System.out.println( "虎类可以在陆地上奔跑" );
	}
	
	/*
	@Override
	public void welcome() { // 实现类可以重写 由接口提供的 default 方法
		System.out.println( "Tiger#welcome()" );
	}
	*/

}
