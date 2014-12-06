package com.siirush.statement.builder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatementContext {
	private Map<String,List<String>> data = new HashMap<String,List<String>>();
	
	public StatementContext add(String name, String value) {
		data.put(name, listOfOne(value));
		return this;
	}
	
	public StatementContext add(String name, String ... values) {
		return add(name,Arrays.asList(values));
	}
	
	public StatementContext add(String name, List<String> values) {
		data.put(name, values);
		return this;
	}
	
	public String getValue(String name) {
		List<String> values = data.get(name);
		return values == null || values.isEmpty() ? null : values.get(0); 
	}
	
	public List<String> getValues(String name) {
		return data.get(name);
	}

	private List<String> listOfOne(String value) {
		List<String> values = new ArrayList<String>();
		values.add(value);
		return values;
	}
}
