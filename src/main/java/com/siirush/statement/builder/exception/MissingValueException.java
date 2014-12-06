package com.siirush.statement.builder.exception;

public class MissingValueException extends RuntimeException {
	private static final long serialVersionUID = 3788308096553327790L;

	public MissingValueException() {
		super();
	}

	public MissingValueException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MissingValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingValueException(String message) {
		super(message);
	}

	public MissingValueException(Throwable cause) {
		super(cause);
	}
}
