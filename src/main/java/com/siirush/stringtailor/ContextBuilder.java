package com.siirush.stringtailor;

import java.util.Map;

public interface ContextBuilder {
	ContextBuilder add(String name, Object value);
	ContextBuilder add(String name, Object ... values);
	Map<String,Object> done();
}