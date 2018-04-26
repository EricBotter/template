package com.app.controller.parameters;

public class InputError {
	String _message;
	
	public InputError(String message) {
		_message = message;
	}
	
	public String getMessage() {
		return _message;
	}
}
