package com.siirush.statement.builder;

import com.siirush.statement.builder.model.CompoundIdentifier;
import com.siirush.statement.builder.model.Identifier;
import com.siirush.statement.builder.model.Literal;
import com.siirush.statement.builder.model.StatementContext;

public class StatementDsl {
	public static StatementBuilder statementBuilder() {
		return new StatementBuilderImpl();
	}
	public static Identifier identifier(String name) {
		return new Identifier(name);
	}
	public static Literal literal(String text) {
		return new Literal(text);
	}
	public static CompoundIdentifier compoundIdentifier(String name, String prefix, String delimiter, String suffix) {
		return new CompoundIdentifier(name,prefix,delimiter,suffix);
	}
	public static CompoundIdentifier compoundIdentifier(String name, String delimiter) {
		return new CompoundIdentifier(name,null,delimiter,null);
	}
	public static StatementContext statementContext() {
		return new StatementContext();
	}
}
