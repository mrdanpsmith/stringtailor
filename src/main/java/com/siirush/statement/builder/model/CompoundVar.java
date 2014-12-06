package com.siirush.statement.builder.model;

import java.util.List;

public class CompoundVar implements Evaluatable {
	private final String name, prefix, suffix, delimiter;
	public CompoundVar(String name, String prefix, String delimiter, String suffix) {
		this.name = name;
		this.prefix = prefix;
		this.delimiter = delimiter;
		this.suffix = suffix;
	}
	public String evaluate(StatementContext context) {
		List<String> values = context.getValues(name);
		if (values == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		if (prefix != null) {
			sb.append(prefix);
		}
		for (int i = 0; i < values.size(); i++) {
			String fragment = values.get(i);
			sb.append(fragment);
			if (i+1 != values.size()) {
				sb.append(delimiter);
			}
		}
		if (suffix != null) {
			sb.append(suffix);
		}
		return sb.toString();
	}
	public String getName() {
		return name;
	}
	public String getPrefix() {
		return prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public String getDelimiter() {
		return delimiter;
	}
}
