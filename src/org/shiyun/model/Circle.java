package org.shiyun.model;

public class Circle {
	
	private String name;

	public Circle() {
		super();
	}

	public Circle(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's setter called");
//		throw(new RuntimeException());	
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Circle's setter called");
		return name;
	}
}
