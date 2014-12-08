package com.siirush.stringtailor.model;


public class Var implements Evaluatable {
	private final String name;
	
	public Var(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String evaluate(Object value) {
		return value == null ? null : value.toString();
	}
}
