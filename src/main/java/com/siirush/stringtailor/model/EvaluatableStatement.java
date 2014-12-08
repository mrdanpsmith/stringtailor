package com.siirush.stringtailor.model;

import java.util.List;

public class EvaluatableStatement {
	private final List<Expression> expressions;
	
	public EvaluatableStatement(List<Expression> expressions) {
		this.expressions = expressions;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}
}
