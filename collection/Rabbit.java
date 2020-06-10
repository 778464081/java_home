package ecut.map;

import java.time.LocalDate;

public class Rabbit {

	private String name;
	private LocalDate birthdate;
	
	public Rabbit(String name, LocalDate birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
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
