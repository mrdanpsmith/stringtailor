package com.siirush.statement.builder.model;

import java.util.List;

public class Statement {
	private final List<Expression> expressions;
	
	public Statement(List<Expression> expressions) {
		this.expressions = expressions;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}
}
