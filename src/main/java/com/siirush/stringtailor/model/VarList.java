package com.siirush.stringtailor.model;

import java.util.List;

import com.siirush.stringtailor.exception.UnexpectedValueException;

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
	
	private String listToString(List<?> values) {
		if (values.size() == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		if (config.prefix != null) {
			sb.append(config.prefix);
		}
		for (int i = 0; i < values.size(); i++) {
			if (i != 0) {
				sb.append(config.delimiter);
			}
			sb.append(values.get(i));
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
