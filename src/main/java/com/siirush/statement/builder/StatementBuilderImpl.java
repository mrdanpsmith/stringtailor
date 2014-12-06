package com.siirush.statement.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.siirush.statement.builder.model.Evaluatable;
import com.siirush.statement.builder.model.Expression;
import com.siirush.statement.builder.model.Statement;

public class StatementBuilderImpl implements StatementBuilder {
	private List<Expression> expressions = new ArrayList<Expression>();
	
	public StatementBuilder add(Evaluatable ... components) {
		Expression expression = new Expression(true);
		expression.setComponents(Arrays.asList(components));
		expressions.add(expression);
		return this;
	}

	public StatementBuilder optional(Evaluatable ... components) {
		Expression expression = new Expression(false);
		expression.setComponents(Arrays.asList(components));
		expressions.add(expression);
		return this;
	}

	public Statement done() {
		return new Statement(expressions);
	}
}
