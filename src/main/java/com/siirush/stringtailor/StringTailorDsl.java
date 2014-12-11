package com.siirush.stringtailor;

import com.siirush.stringtailor.model.Evaluatable;
import com.siirush.stringtailor.model.Literal;
import com.siirush.stringtailor.model.Multi;
import com.siirush.stringtailor.model.Var;
import com.siirush.stringtailor.model.VarList;

/**
 * This class's methods can be statically included to allow for a simpler usage syntax.
 */
public class StringTailorDsl {
	public static StringTailor statement() {
		return new StringTailorImpl();
	}
	/**
	 * @since 0.1.4
	 */
	public static StringTailor statement(Evaluatable ... components) {
		StringTailor stringTailor = statement();
		return stringTailor.add(components);
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
	/**
	 * @since 0.1.3
	 * @param name
	 * @param text
	 * @return Multi
	 */
	public static Multi multi(String name, String text) {
		return new Multi(name,text);
	}
	/**
	 * @since 0.1.3
	 * @param name
	 * @param text
	 * @param config
	 * @return Multi
	 */
	public static Multi multi(String name, String text, Multi.Config config) {
		return new Multi(name,text,config);
	}
	/**
	 * @since 0.1.3
	 * @param prefix
	 * @param delimiter
	 * @param suffix
	 * @return Multi.Config
	 */
	public static Multi.Config multiConfig(String prefix, String delimiter, String suffix) {
		return new Multi.Config(prefix,delimiter,suffix);
	}
	/**
	 * @since 0.1.3
	 * @param delimiter
	 * @return Multi.Config
	 */
	public static Multi.Config multiConfig(String delimiter) {
		return new Multi.Config(delimiter);
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
	/**
	 * @since 0.1.4
	 */
	public static ContextBuilder context(String name, String ... values) {
		ContextBuilder contextBuilder = new ContextBuilderImpl();
		return contextBuilder.add(name, (Object[])values);
	}
}
