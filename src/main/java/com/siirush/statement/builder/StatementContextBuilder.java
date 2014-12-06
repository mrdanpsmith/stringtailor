package com.siirush.statement.builder;

import java.util.List;
import java.util.Map;

public interface StatementContextBuilder {
	StatementContextBuilder add(String name, Object value);
	StatementContextBuilder add(String name, Object ... values);
	StatementContextBuilder add(String name, List<Object> values);
	Map<String,Object> done();
}