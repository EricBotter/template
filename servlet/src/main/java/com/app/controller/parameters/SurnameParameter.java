package com.app.controller.parameters;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class SurnameParameter extends InputParameter {
	
	public SurnameParameter(String value) {
		super(value);
	}
	
	public SurnameParameter(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getName() {
		return "surname";
	}
	
	@Override
	public List<InputError> getValidationErrors() {
		ArrayList<InputError> output = new ArrayList<>();
		if (_value == null || _value.trim().equals(""))
			output.add(new InputError("Surname cannot be empty"));
		else if (_value.length() > 15)
			output.add(new InputError("Surname must have no more than 15 chars"));
		return output;
	}
}
