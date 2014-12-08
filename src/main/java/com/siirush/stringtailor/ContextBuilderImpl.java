package com.siirush.stringtailor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContextBuilderImpl implements ContextBuilder {
	private Map<String,Object> data = new HashMap<String,Object>();
	
	public ContextBuilder add(String name, Object value) {
		data.put(name, value);
		return this;
	}
	
	public Map<String,Object> done() {
		return data;
	}

	public ContextBuilder add(String name, Object ... values) {
		data.put(name, Arrays.asList(values));
		return this;
	}
}
