package com.siirush.statement.builder;

import java.util.Map;

import com.siirush.statement.builder.model.Statement;

public interface StatementEvaluator {
	String buildStatement(Statement statement, Map<String,Object> context);
}
