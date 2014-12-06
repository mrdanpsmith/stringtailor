package com.siirush.statement.builder;

import com.siirush.statement.builder.model.Identifier;
import com.siirush.statement.builder.model.Literal;

public class StatementBuilderHelper {
	public static StatementBuilder statementBuilder() {
		return new StatementBuilderImpl();
	}
	public static Identifier identifier(String name) {
		return new Identifier(name);
	}
	public static Literal literal(String text) {
		return new Literal(text);
	}
}
