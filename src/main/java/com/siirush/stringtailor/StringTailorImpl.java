package com.siirush.stringtailor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.siirush.stringtailor.model.Evaluatable;
import com.siirush.stringtailor.model.Expression;
import com.siirush.stringtailor.model.EvaluatableStatement;

public class StringTailorImpl implements StringTailor {
	private List<Expression> expressions = new ArrayList<Expression>();
	
	public StringTailor add(Evaluatable ... components) {
		Expression expression = new Expression(true);
		expression.setComponents(Arrays.asList(components));
		expressions.add(expression);
		return this;
	}

	public StringTailor optional(Evaluatable ... components) {
		Expression expression = new Expression(false);
		expression.setComponents(Arrays.asList(components));
		expressions.add(expression);
		return this;
	}

	public EvaluatableStatement done() {
		return new EvaluatableStatement(expressions);
	}
}
