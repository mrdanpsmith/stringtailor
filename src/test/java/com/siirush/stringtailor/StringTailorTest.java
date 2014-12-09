package com.siirush.stringtailor;

import static com.siirush.stringtailor.StringTailorDsl.context;
import static com.siirush.stringtailor.StringTailorDsl.list;
import static com.siirush.stringtailor.StringTailorDsl.listConfig;
import static com.siirush.stringtailor.StringTailorDsl.literal;
import static com.siirush.stringtailor.StringTailorDsl.multi;
import static com.siirush.stringtailor.StringTailorDsl.multiConfig;
import static com.siirush.stringtailor.StringTailorDsl.statement;
import static com.siirush.stringtailor.StringTailorDsl.var;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.siirush.stringtailor.config.TestModule;
import com.siirush.stringtailor.exception.MissingValueException;
import com.siirush.stringtailor.exception.UnexpectedValueException;
import com.siirush.stringtailor.model.EvaluatableStatement;

public class StringTailorTest {
	public StringTailorTest() {
		Injector injector = Guice.createInjector(new TestModule());
		injector.injectMembers(this);
	}
	
	@Inject
	private StatementEvaluator evaluator;
	
	@Test
	public void testLiteralsAndVars() {
		EvaluatableStatement statement = 
				statement()
					.add(literal("Hello, "),var("SUBJECT"),literal("!"))
					.done();
		Map<String,Object> context = 
				context()
					.add("SUBJECT","World")
					.done();
		assertEquals("Hello, World!",evaluator.evaluate(statement, context));
	}
	
	@Test
	public void testLiteralsAndList() {
		List<String> groceryList = new ArrayList<String>();
		groceryList.add("Milk");
		groceryList.add("Eggs");
		groceryList.add("Bread");
		EvaluatableStatement statement =
				statement()
					.add(literal("Grocery list: "),list("GROCERY LIST"))
					.done();
		Map<String,Object> context =
				context()
					.add("GROCERY LIST","Milk","Eggs","Bread")
					.done();
		Map<String,Object> contextWithList =
				context()
					.add("GROCERY LIST",groceryList)
					.done();
		assertEquals("Grocery list: Milk,Eggs,Bread",evaluator.evaluate(statement, context));
		assertEquals("Grocery list: Milk,Eggs,Bread",evaluator.evaluate(statement, contextWithList));
	}
	
	@Test
	public void testListWithDelimiterConfiguration() {
		EvaluatableStatement statement =
				statement()
					.add(literal("Grocery list: "),list("GROCERY LIST",listConfig(", ")))
					.done();
		Map<String,Object> context =
				context()
					.add("GROCERY LIST","Milk","Eggs","Bread")
					.done();
		assertEquals("Grocery list: Milk, Eggs, Bread",evaluator.evaluate(statement, context));
	}
	
	@Test
	public void testListWithCompleteConfiguration() {
		EvaluatableStatement statement =
				statement()
					.add(literal("Grocery list"),list("GROCERY LIST",listConfig(": (",", ",")")))
					.done();
		Map<String,Object> context =
				context()
					.add("GROCERY LIST","Milk","Eggs","Bread")
					.done();
		assertEquals("Grocery list: (Milk, Eggs, Bread)",evaluator.evaluate(statement, context));
	}
	
	@Test
	public void testOptionalExpression() {
		EvaluatableStatement statement =
				statement()
					.add(literal("Hello"))
					.optional(literal(", "),var("SUBJECT"))
					.add(literal("!"))
					.done();
		Map<String,Object> context =
				context()
					.add("SUBJECT", "World")
					.done();
		Map<String,Object> emptyContext =
				context()
					.done();
		assertEquals("Hello, World!",evaluator.evaluate(statement, context));
		assertEquals("Hello!",evaluator.evaluate(statement, emptyContext));
	}
	
	@Test
	public void testOptionalListExpressionWithEmptyList() {
		EvaluatableStatement statement = 
				statement()
					.add(literal("Grocery list"))
					.optional(literal(":"),list("GROCERY LIST"))
					.done();
		Map<String,Object> context =
				context()
					.add("GROCERY LIST",Collections.<String>emptyList())
					.done();
		assertEquals("Grocery list",evaluator.evaluate(statement,context));
	}
	
	@Test
	public void testOptionalListExpressionWithNullList() {
		EvaluatableStatement statement = 
				statement()
					.add(literal("Grocery list"))
					.optional(literal(":"),list("GROCERY LIST"))
					.done();
		List<String> nullList = null;
		Map<String,Object> context =
				context()
					.add("GROCERY LIST",nullList)
					.done();
		assertEquals("Grocery list",evaluator.evaluate(statement,context));
	}
	
	@Test
	public void testMultiExpression() {
		EvaluatableStatement statement =
				statement()
					.add(multi("STARS","*"))
					.done();
		Map<String,Object> context =
				context()
					.add("STARS",8)
					.done();
		assertEquals("********",evaluator.evaluate(statement, context));
	}
	
	@Test
	public void testMultiExpressionWithDelimiter() {
		EvaluatableStatement statement = 
				statement()
					.add(multi("STARS","*",multiConfig(",")))
					.done();
		Map<String,Object> context =
				context()
					.add("STARS",8)
					.done();
		assertEquals("*,*,*,*,*,*,*,*",evaluator.evaluate(statement, context));
	}
	
	@Test
	public void testMultiExpressionWithFullConfiguration() {
		EvaluatableStatement statement =
				statement()
					.add(multi("STARS","*",multiConfig("(",",",")")))
					.done();
		Map<String,Object> context =
				context()
					.add("STARS",8)
					.done();
		assertEquals("(*,*,*,*,*,*,*,*)",evaluator.evaluate(statement, context));
	}
	
	@Test
	public void testOptionalMultiExpression() {
		EvaluatableStatement statement =
				statement()
					.optional(multi("STARS","*",multiConfig(",")))
					.done();
		Map<String,Object> emptyContext =
				context()
					.done();
		assertEquals("",evaluator.evaluate(statement, emptyContext));
	}
	
	@Test
	public void testMissingRequiredVariable() {
		EvaluatableStatement statement = 
				statement()
					.add(literal("Hello, "),var("SUBJECT"),literal("!"))
					.done();
		Map<String,Object> context =
				context()
					.done();
		MissingValueException thrown = null;
		try {
			evaluator.evaluate(statement, context);
		} catch (MissingValueException e) {
			thrown = e;
		}
		assertNotNull(thrown);
	}
	
	@Test
	public void testNonListPassedWhereListRequired() {
		EvaluatableStatement statement =
				statement()
					.add(literal("Grocery list: "),list("GROCERY LIST"))
					.done();
		Map<String,Object> context =
				context()
					.add("GROCERY LIST",new HashMap<String,String>())
					.done();
		UnexpectedValueException thrown = null;
		try {
			evaluator.evaluate(statement, context);
		} catch (UnexpectedValueException e) {
			thrown = e;
		}
		assertNotNull(thrown);
	}
	
	@Test
	public void testNullValuePassed() {
		EvaluatableStatement statement =
				statement()
					.add(literal("Hello, "), var("SUBJECT"), literal("!"))
					.done();
		Object nullObject = null;
		Map<String,Object> context =
				context()
					.add("SUBJECT",nullObject)
					.done();
		MissingValueException thrown = null;
		try {
			evaluator.evaluate(statement, context);
		} catch (MissingValueException e) {
			thrown = e;
		}
		assertNotNull(thrown);
	}
}
