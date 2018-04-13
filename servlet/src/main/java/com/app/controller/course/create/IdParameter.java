package com.app.controller.course.create;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class IdParameter extends InputParameter {

	public IdParameter(String value) {
		super(value);
	}
	
	public IdParameter(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getName() {
		return "id";
	}

	public int getIntegerValue() {
		return Integer.parseInt(_value);
	}

	@Override
	public List<InputError> getValidationErrors() {
		ArrayList<InputError> output = new ArrayList<>();
		if (_value == null || _value.trim().equals(""))
			output.add(new InputError("Id cannot be empty"));
		else if (!_value.matches("^0*[1-9][0-9]*$"))
			output.add(new InputError("Id must be a number"));
		return output;
	}

}
