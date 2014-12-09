package com.siirush.stringtailor;

import java.util.Map;

import com.siirush.stringtailor.exception.MissingValueException;
import com.siirush.stringtailor.model.Evaluatable;
import com.siirush.stringtailor.model.Expression;
import com.siirush.stringtailor.model.EvaluatableStatement;

public class StatementEvaluatorImpl implements StatementEvaluator {
	public String evaluate(EvaluatableStatement evaluatableStatement, Map<String,Object> context) {
		StringBuilder sb = new StringBuilder();
		for (Expression expression: evaluatableStatement.getExpressions()) {
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
				throw new MissingValueException(String.format("Missing value for: %s found while evaluating a required expression.",component.getName()));
			}
			if (evaluated == null) {
				return new StringBuilder();
			}
			sb.append(evaluated);
		}
		return sb;
	}
}
