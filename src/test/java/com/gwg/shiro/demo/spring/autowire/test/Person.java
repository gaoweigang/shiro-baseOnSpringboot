package com.gwg.shiro.demo.spring.autowire.test;

public class Person {
	
	private String name;
	
	private int age;

	private String father;
	
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
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

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}
}
