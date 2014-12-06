package com.siirush.statement.builder.model;

import java.util.List;

public class Expression {
	private final Boolean required;
	private List<Component> components;
	
	public Expression(Boolean required) {
		this.required = required;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public Boolean getRequired() {
		return required;
	}
}
