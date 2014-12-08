package com.siirush.stringtailor.model;

import java.util.List;

public class Expression {
	private final Boolean required;
	private List<Evaluatable> components;
	
	public Expression(Boolean required) {
		this.required = required;
	}

	public List<Evaluatable> getComponents() {
		return components;
	}

	public void setComponents(List<Evaluatable> components) {
		this.components = components;
	}

	public Boolean getRequired() {
		return required;
	}
}
