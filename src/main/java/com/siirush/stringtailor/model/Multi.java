package com.siirush.stringtailor.model;

import com.siirush.stringtailor.exception.UnexpectedValueException;

/**
 * @since 0.1.3
 */
public class Multi implements Evaluatable {
	private final String text, name;
	private final Config config;
	
	public Multi(String name, String text) {
		this(name,text,Config.NO_DELIMITER);
	}
	public Multi(String name, String text, Config config) {
		this.text = text;
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
		if (!(value instanceof Integer)) {
			throw new UnexpectedValueException(String.format("Integer required for variable named: %s, %s found instead.",name,value.getClass()));
		}
		return multiplyText((Integer)value);
	}
	private String multiplyText(Integer amount) {
		if (amount == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < amount; i++) {
			if (i == 0 && config.prefix != null) {
				sb.append(config.prefix);
			}
			sb.append(text);
			if (i+1 < amount && config.delimiter != null) {
				sb.append(config.delimiter);
			} else if (config.suffix != null) {
				sb.append(config.suffix);
			}
		}
		return sb.toString();
	}
	public static class Config {
		private static final Config NO_DELIMITER = new Config();	
		private final String prefix, delimiter, suffix;
		public Config() {
			this(null,null,null);
		}
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