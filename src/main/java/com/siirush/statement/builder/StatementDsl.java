package com.siirush.statement.builder;

import com.siirush.statement.builder.model.Literal;
import com.siirush.statement.builder.model.Var;
import com.siirush.statement.builder.model.VarList;

public class StatementDsl {
	public static StatementBuilder statement() {
		return new StatementBuilderImpl();
	}
	public static Var var(String name) {
		return new Var(name);
	}
	public static Literal literal(String text) {
		return new Literal(text);
	}
	public static VarList list(String name) {
		return new VarList(name);
	}
	public static VarList list(String name, VarList.Config config) {
		return new VarList(name,config);
	}
	public static VarList.Config listConfig(String prefix, String delimiter, String suffix) {
		return new VarList.Config(prefix,delimiter,suffix);
	}
	public static VarList.Config listConfig(String delimiter) {
		return new VarList.Config(delimiter);
	}
	public static StatementContextBuilder context() {
		return new StatementContextBuilderImpl();
	}
}
