package com.siirush.stringtailor.exception;

public class MissingValueException extends StringTailorException {
	private static final long serialVersionUID = 3788308096553327790L;

	public MissingValueException(String message) {
		super(message);
	}
}
