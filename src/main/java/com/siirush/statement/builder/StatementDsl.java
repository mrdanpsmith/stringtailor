package com.siirush.statement.builder;

import com.siirush.statement.builder.model.CompoundVar;
import com.siirush.statement.builder.model.Var;
import com.siirush.statement.builder.model.Literal;
import com.siirush.statement.builder.model.StatementContext;

public class StatementDsl {
	public static StatementBuilder statementBuilder() {
		return new StatementBuilderImpl();
	}
	public static Var var(String name) {
		return new Var(name);
	}
	public static Literal literal(String text) {
		return new Literal(text);
	}
	public static CompoundVar compoundVar(String name, String prefix, String delimiter, String suffix) {
		return new CompoundVar(name,prefix,delimiter,suffix);
	}
	public static CompoundVar compoundVar(String name, String delimiter) {
		return new CompoundVar(name,null,delimiter,null);
	}
	public static StatementContext statementContext() {
		return new StatementContext();
	}
}
