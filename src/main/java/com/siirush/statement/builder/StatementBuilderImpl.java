package com.siirush.statement.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.siirush.statement.builder.model.Component;
import com.siirush.statement.builder.model.Expression;
import com.siirush.statement.builder.model.Statement;

public class StatementBuilderImpl implements StatementBuilder {
	private List<Expression> expressions = new ArrayList<Expression>();
	
	public StatementBuilder add(Component ... components) {
		Expression expression = new Expression(true);
		expression.setComponents(Arrays.asList(components));
		expressions.add(expression);
		return this;
	}

	public StatementBuilder optional(Component ... components) {
		Expression expression = new Expression(false);
		expression.setComponents(Arrays.asList(components));
		expressions.add(expression);
		return this;
	}

	public Statement build() {
		return new Statement(expressions);
	}
}
