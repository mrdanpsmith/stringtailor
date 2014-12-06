package com.siirush.statement.builder;

import java.util.Map;

import com.siirush.statement.builder.exception.MissingValueException;
import com.siirush.statement.builder.model.Component;
import com.siirush.statement.builder.model.Expression;
import com.siirush.statement.builder.model.Statement;

public class StatementEvaluatorImpl implements StatementEvaluator {
	public String buildStatement(Statement statement, Map<String, String> context) {
		StringBuilder sb = new StringBuilder();
		for (Expression expression: statement.getExpressions()) {
			for (Component component: expression.getComponents()) {
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
