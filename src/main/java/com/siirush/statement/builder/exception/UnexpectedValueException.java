package com.siirush.statement.builder.exception;

public class UnexpectedValueException extends StatementBuilderException {
	private static final long serialVersionUID = -1041348846660360532L;

	public UnexpectedValueException() {
		super();
	}

	public UnexpectedValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnexpectedValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnexpectedValueException(String message) {
		super(message);
	}

	public UnexpectedValueException(Throwable cause) {
		super(cause);
	}
}
