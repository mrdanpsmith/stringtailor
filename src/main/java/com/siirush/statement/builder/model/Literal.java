package com.siirush.statement.builder.model;



public class Literal implements Evaluatable {
	private final String text;
	
	public Literal(String text) {
		this.text = text;
	}

	public String getName() {
		return null;
	}

	public String evaluate(Object value) {
		return text;
	}
}
