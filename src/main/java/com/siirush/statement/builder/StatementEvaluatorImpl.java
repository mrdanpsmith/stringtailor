package com.siirush.statement.builder;

import java.util.Map;

import com.siirush.statement.builder.exception.MissingValueException;
import com.siirush.statement.builder.model.Evaluatable;
import com.siirush.statement.builder.model.Expression;
import com.siirush.statement.builder.model.Statement;

public class StatementEvaluatorImpl implements StatementEvaluator {
	public String buildStatement(Statement statement, Map<String,Object> context) {
		StringBuilder sb = new StringBuilder();
		for (Expression expression: statement.getExpressions()) {
			sb.append(evaluateExpression(expression,context));
		}
		return sb.toString();
	}

	private StringBuilder evaluateExpression(Expression expression, Map<String, Object> context) {
		StringBuilder sb = new StringBuilder();
		for (Evaluatable component: expression.getComponents()) {
			Object componentValue = context.get(component.getName());
			String evaluated = component.evaluate(componentValue);
			if (evaluated == null && expression.getRequired()) {
				throw new MissingValueException(String.format("Missing value found evaluating a required expression."));
			}
			if (evaluated == null) {
				return new StringBuilder();
			}
			sb.append(evaluated);
		}
		return sb;
	}
}
