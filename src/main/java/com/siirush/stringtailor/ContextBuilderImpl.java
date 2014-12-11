package com.siirush.stringtailor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContextBuilderImpl implements ContextBuilder {
	private Map<String,Object> data = new HashMap<String,Object>();
	
	public Map<String,Object> done() {
		return data;
	}

	public ContextBuilder add(String name, Object ... values) {
		data.put(name, values.length == 1 ? values[0] : Arrays.asList(values));
		return this;
	}
}
