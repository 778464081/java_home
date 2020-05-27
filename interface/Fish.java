package cn.edu.ecut;

public class Fish extends Animal {

	@Override
	public void breathe() {
		System.out.println( "鱼类是用鳃呼吸的" );
	}

	@Override
	public void move() {
		System.out.println( "鱼在水中游动" );
	}
	
}
