package com.siirush.statement.builder.model;

public class Identifier implements Evaluatable {
	private final String name;
	
	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String evaluate(StatementContext context) {
		return context.getValue(name);
	}
}
