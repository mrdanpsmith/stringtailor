package com.siirush.statement.builder;

import com.siirush.statement.builder.model.Component;
import com.siirush.statement.builder.model.Statement;

public interface StatementBuilder {
	StatementBuilder add(Component ... components);
	StatementBuilder optional(Component ... components);
	Statement build();
}
