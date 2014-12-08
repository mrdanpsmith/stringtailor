package com.siirush.stringtailor.config;

import com.google.inject.AbstractModule;
import com.siirush.stringtailor.StatementEvaluator;
import com.siirush.stringtailor.StatementEvaluatorImpl;

public class TestModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(StatementEvaluator.class).to(StatementEvaluatorImpl.class);
	}
}
