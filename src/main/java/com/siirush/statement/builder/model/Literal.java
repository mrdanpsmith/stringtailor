package com.siirush.statement.builder.model;


public class Literal implements Evaluatable {
	private final String text;
	
	public Literal(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public String evaluate(StatementContext context) {
		if (text == null) {
			return "";
		}
		return text;
	}
}
