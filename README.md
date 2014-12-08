StringTailor
============
A Java string generation library for building complex statements.

Is not StringBuilder or String.format enough?
---------------------------------------------
I was writing a lot of code that had to deal with building complex
string statements.  A problem I encountered while doing so is that
the methods started to get out of control in both size and number.
At that point, I decided that there was probably for a string
utility that reduced the complexity of creating statements with
optional clauses and lists of variables.

StringBuilder and String.format are both great utilities, but this
library is a higher level abstraction that allows statements to be
built quickly and with great care given to make the declarations
understandable in code.

Installation
------------
StringTailor will be in maven central.  Simply add the following dependency:

```xml
<dependency>
    <groupId>com.siirush</groupId>
    <artifactId>stringtailor</artifactId>
    <version>0.1.0</version>
</dependency>
```

Usage
-----
Great usage examples can be found in the test cases.  I included a couple of those
in text here for reference.

Simple usage:
```Java
EvaluatableStatement statement = 
		statement()
			.add(literal("Hello, "),var("SUBJECT"),literal("!"))
			.done();
Map<String,Object> context = 
		context()
			.add("SUBJECT","World")
			.done();
assertEquals("Hello, World!",evaluator.evaluate(statement, context));
```

With an optional expression:
```Java
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
```

With a list:
```Java
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
```
