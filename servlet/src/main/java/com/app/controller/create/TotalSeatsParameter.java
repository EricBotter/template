package com.app.controller.create;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class TotalSeatsParameter extends InputParameter {
	
	public TotalSeatsParameter(String value) {
		super(value);
	}

	public TotalSeatsParameter(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getName() {
		return "seats";
	}
	
	public int getIntegerValue() {
		return Integer.parseInt(_value);
	}

	@Override
	public List<InputError> getValidationErrors() {
		ArrayList<InputError> output = new ArrayList<>();
		if (_value == null || _value.trim().equals(""))
			output.add(new InputError("Number of seats cannot be empty"));
		else {
			if (!_value.matches("^0*[1-9][0-9]*$"))
				output.add(new InputError("Number of seats must be a number"));
			else if (Integer.parseInt(_value) > 100)
				output.add(new InputError("Number of seats must be lower than 100"));
			if (_value.length() > 3)
				output.add(new InputError("Number of seats must have no more than 3 chars"));
		}
		return output;
	}

}
