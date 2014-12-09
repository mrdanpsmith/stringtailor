StringTailor
============
A Java string generation library for building complex statements.

Is not StringBuilder or String.format enough?
---------------------------------------------
I was writing a lot of code that had to deal with building complex
string statements.  A problem I encountered while doing so is that
the methods started to get out of control in both size and number.
At that point, I decided that there was probably a need for a 
string utility that reduced the complexity of creating statements 
with optional clauses and lists of variables.

StringBuilder and String.format are both great utilities, but this
library is a higher level abstraction that allows statements to be
built quickly and more understandably.

Installation
------------
StringTailor will be in maven central.  Simply add the following dependency:

```xml
<dependency>
    <groupId>com.siirush</groupId>
    <artifactId>stringtailor</artifactId>
    <version>0.1.3</version>
</dependency>
```

Changelog
---------
0.1.0 - Initial release.

0.1.1 - Change GitHub repository URL.

0.1.2 - Fix issue with optional clauses and empty lists.  Add test case for optional clause with an empty list.

0.1.3 - Add multi support for building Strings through multiplication.  Add better error messaging for failed evaluations.

Usage
-----
Great usage examples can be found in the test cases.  I included a couple of those
in text here for reference.  It is important to note that statically including
StringTailorDsl's methods is required in order to write code like the following.

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

With multi clauses:
```Java
EvaluatableStatement statement =
		statement()
			.add(multi("STARS","*"))
			.done();
Map<String,Object> context =
		context()
			.add("STARS",8)
			.done();
assertEquals("********",evaluator.evaluate(statement, context));

EvaluatableStatement statement = 
		statement()
			.add(multi("STARS","*",multiConfig(",")))
			.done();
Map<String,Object> context =
		context()
			.add("STARS",8)
			.done();
assertEquals("*,*,*,*,*,*,*,*",evaluator.evaluate(statement, context));

EvaluatableStatement statement =
		statement()
			.add(multi("STARS","*",multiConfig("(",",",")")))
			.done();
Map<String,Object> context =
		context()
			.add("STARS",8)
			.done();
assertEquals("(*,*,*,*,*,*,*,*)",evaluator.evaluate(statement, context));

EvaluatableStatement statement =
		statement()
			.optional(multi("STARS","*",multiConfig(",")))
			.done();
Map<String,Object> emptyContext =
		context()
			.done();
assertEquals("",evaluator.evaluate(statement, emptyContext));
```
