package com.siirush.statement.builder;

import com.siirush.statement.builder.model.Evaluatable;
import com.siirush.statement.builder.model.Statement;

public interface StatementBuilder {
	StatementBuilder add(Evaluatable ... components);
	StatementBuilder optional(Evaluatable ... components);
	Statement build();
}
