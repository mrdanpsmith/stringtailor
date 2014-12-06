package com.siirush.statement.builder.model;

import java.util.Map;

public class Identifier implements Component {
	private final String name;
	
	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String evaluate(Map<String, String> context) {
		return context.get(name);
	}
}
