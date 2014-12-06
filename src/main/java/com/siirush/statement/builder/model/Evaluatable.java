package com.siirush.statement.builder.model;


public interface Evaluatable {
	String getName();
	String evaluate(Object value);
}
