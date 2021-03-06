package com.app.controller.parameters;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public abstract class InputParameter {
	protected String _value;
	
	protected InputParameter(String value) {
		_value = value;
	}
	
	protected InputParameter(HttpServletRequest request) {
		_value = request.getParameter(getName());
	}
	
	public abstract String getName();
	
	public abstract List<InputError> getValidationErrors();
	
	public String getValue() {
		return _value;
	}
}