package ecut.map;

import java.time.LocalDate;

public class Monkey implements Comparable<Monkey>{

	private String name;
	private LocalDate birthdate;
	
	public Monkey(String name, LocalDate birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
	}
	
	@Override
	public int compareTo( Monkey o ) {
		if( o != null ) {
			// 借助于 LocalDate 类的 compareTo 方法实现比较
			return birthdate.compareTo( o.birthdate) ;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "( name='" + name + "' , birthdate='" + birthdate + "' )";
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

}
