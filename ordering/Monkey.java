package cn.edu.ecut;

public class Monkey implements Comparable<Monkey>{

	private String name;
	private int age;
	private double weight;
	
	public Monkey() {
		super();
	}

	public Monkey(String name, int age, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Monkey o) {
		// 比较 当前对象(this) 与 参数所指定对象 ( o ) 的顺序:
		// 如果 当前对象 小于 、等于 或 大于 指定对象，则分别返回 负整数 、零 或 正整数。
		// 至于通过 哪些字段 来比较两个对象的"大小"，可以根据具体业务来确定 ( 但要跟 equals 保持一致)
		if( this.age < o.age ) {
			return -1 ;
		} else if( this.age == o.age ) {
			return 0 ;
		} else {
			return 1 ;
		}
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
