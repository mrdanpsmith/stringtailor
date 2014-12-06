package com.siirush.statement.builder.model;

import java.util.Map;

public class Literal implements Component {
	private final String text;
	
	public Literal(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public String evaluate(Map<String, String> context) {
		if (text == null) {
			return "";
		}
		return text;
	}
}
