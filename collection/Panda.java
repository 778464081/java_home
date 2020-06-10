package ecut.map;

import java.time.LocalDate;
import java.util.Objects;

public class Panda {
	
	private String name ;
	private LocalDate birthdate ;
	private int weight ; // 体重 ( 以克为单位 , 1斤 = 500克 )
	
	public Panda(String name, LocalDate birthdate, int weight) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		/*
		final int prime = 31; // 为什么是 31 ?
		int result = 1;
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
		*/
		return Objects.hash( birthdate , name , weight );
	}

	@Override
	public boolean equals(Object o ) {
		if( this == o ) {
			return true ;
		}
		
		// null instanceof 任意类型 都返回 false
		if( o instanceof Panda ) { // 参数传入的 o 可能是 Panda 的子类类型的实例
			// 判断两者是否是同一个类的实例
			if( this.getClass() == o.getClass() ) {
				Panda p = ( Panda ) o ;
				return name.equals( p.name ) && birthdate.equals( p.birthdate ) && weight == p.weight ;
			}
		}
		
		return false ;
	}

	@Override
	public String toString() {
		return "( name=" + name + ", birthdate=" + birthdate + ", weight=" + weight + " )";
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public int getWeight() {
		return weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
