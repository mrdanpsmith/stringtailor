package com.siirush.stringtailor;

import com.siirush.stringtailor.model.Literal;
import com.siirush.stringtailor.model.Var;
import com.siirush.stringtailor.model.VarList;

public class StringTailorDsl {
	public static StringTailor statement() {
		return new StringTailorImpl();
	}
	public static Var var(String name) {
		return new Var(name);
	}
	public static Literal literal(String text) {
		return new Literal(text);
	}
	public static VarList list(String name) {
		return new VarList(name);
	}
	public static VarList list(String name, VarList.Config config) {
		return new VarList(name,config);
	}
	public static VarList.Config listConfig(String prefix, String delimiter, String suffix) {
		return new VarList.Config(prefix,delimiter,suffix);
	}
	public static VarList.Config listConfig(String delimiter) {
		return new VarList.Config(delimiter);
	}
	public static ContextBuilder context() {
		return new ContextBuilderImpl();
	}
}
