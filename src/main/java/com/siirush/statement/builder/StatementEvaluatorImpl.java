package com.siirush.statement.builder;

import com.siirush.statement.builder.exception.MissingValueException;
import com.siirush.statement.builder.model.Evaluatable;
import com.siirush.statement.builder.model.Expression;
import com.siirush.statement.builder.model.Statement;
import com.siirush.statement.builder.model.StatementContext;

public class StatementEvaluatorImpl implements StatementEvaluator {
	public String buildStatement(Statement statement, StatementContext context) {
		StringBuilder sb = new StringBuilder();
		for (Expression expression: statement.getExpressions()) {
			for (Evaluatable component: expression.getComponents()) {
				String evaluated = component.evaluate(context);
				if (evaluated == null && expression.getRequired()) {
					throw new MissingValueException(String.format("Missing value found evaluating a required expression."));
				}
				sb.append(evaluated);
			}
		}
		return sb.toString();
	}
}
