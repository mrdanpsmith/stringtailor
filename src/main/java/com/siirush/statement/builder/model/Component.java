package com.siirush.statement.builder.model;

import java.util.Map;

public interface Component {
	String evaluate(Map<String,String> context);
}
