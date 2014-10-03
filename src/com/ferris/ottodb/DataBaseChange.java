package com.ferris.ottodb;

public class DataBaseChange {
	private String name="";
	private String age="";
	
	public DataBaseChange(String name,String age){
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DataBaseChange [name=" + name + ", age=" + age + "]";
	}

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
