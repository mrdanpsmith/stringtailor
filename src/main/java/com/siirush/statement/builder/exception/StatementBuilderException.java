package com.siirush.statement.builder.exception;

public class StatementBuilderException extends RuntimeException {
	private static final long serialVersionUID = 383697262934373571L;

	public StatementBuilderException() {}

	public StatementBuilderException(String message) {
		super(message);
	}

	public StatementBuilderException(Throwable cause) {
		super(cause);
	}

	public StatementBuilderException(String message, Throwable cause) {
		super(message, cause);
	}

	public StatementBuilderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
