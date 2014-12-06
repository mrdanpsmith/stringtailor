package com.siirush.statement.builder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatementContextBuilderImpl implements StatementContextBuilder {
	private Map<String,Object> data = new HashMap<String,Object>();
	
	public StatementContextBuilder add(String name, Object value) {
		data.put(name, value);
		return this;
	}
	
	public Map<String,Object> done() {
		return data;
	}

	public StatementContextBuilder add(String name, Object ... values) {
		data.put(name, Arrays.asList(values));
		return this;
	}

	public StatementContextBuilder add(String name, List<Object> values) {
		data.put(name, values);
		return this;
	}
}
