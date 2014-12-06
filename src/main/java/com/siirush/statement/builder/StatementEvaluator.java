package com.siirush.statement.builder;

import com.siirush.statement.builder.model.Statement;
import com.siirush.statement.builder.model.StatementContext;

public interface StatementEvaluator {
	String buildStatement(Statement statement, StatementContext context);
}
