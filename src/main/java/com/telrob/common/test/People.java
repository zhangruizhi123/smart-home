package com.telrob.common.test;

public class People {
	private static String name;

	public People(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		People.name = name;
	}
}
