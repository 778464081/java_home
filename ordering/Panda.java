package cn.edu.ecut;

public class Panda {

	private String name;
	private int age;
	private double weight;
	
	public Panda() {
		super();
	}

	public Panda(String name, int age, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "{ name : " + name + ", age : " + age + ", weight : " + weight + " }";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
