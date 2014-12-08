package com.siirush.stringtailor;

import java.util.Map;

import com.siirush.stringtailor.model.EvaluatableStatement;

public interface StatementEvaluator {
	String evaluate(EvaluatableStatement evaluatableStatement, Map<String,Object> context);
}
