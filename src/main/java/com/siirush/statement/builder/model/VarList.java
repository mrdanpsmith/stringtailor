package com.siirush.statement.builder.model;

import java.util.List;

import com.siirush.statement.builder.exception.UnexpectedValueException;

public class VarList implements Evaluatable {
	private final String name;
	private final Config config;
	
	public VarList(String name) {
		this(name,Config.COMMA_DELIMITED);
	}
	public VarList(String name, Config config) {
		this.name = name;
		this.config = config;
	}
	public String getName() {
		return name;
	}
	public String evaluate(Object value) {
		if (value == null) {
			return null;
		}
		if (!(value instanceof List)) {
			throw new UnexpectedValueException(String.format("List required for variable named: %s, %s found instead.",name,value.getClass()));
		}
		return listToString((List<?>)value);
	}
	
	private String listToString(List<?> value) {
		StringBuilder sb = new StringBuilder();
		List<?> values = (List<?>)value;
		if (config.prefix != null) {
			sb.append(config.prefix);
		}
		boolean first = true;
		for (Object listValue: values) {
			if (!first) {
				sb.append(config.delimiter);
			} else {
				first = false;
			}
			sb.append(listValue);
		}
		if (config.suffix != null) {
			sb.append(config.suffix);
		}
		return sb.toString();
	}

	public static class Config {
		private static final Config COMMA_DELIMITED = new Config(",");
		
		private final String prefix, delimiter, suffix;
		
		public Config(String delimiter) {
			this(null,delimiter,null);
		}
		
		public Config(String prefix, String delimiter, String suffix) {
			this.prefix = prefix;
			this.delimiter = delimiter;
			this.suffix = suffix;
		}
	}
}
