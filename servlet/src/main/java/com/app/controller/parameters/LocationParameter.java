package com.app.controller.parameters;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class LocationParameter extends InputParameter {
	
	public LocationParameter(String value) {
		super(value);
	}

	public LocationParameter(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getName() {
		return "location";
	}
	
	@Override
	public List<InputError> getValidationErrors() {
		ArrayList<InputError> output = new ArrayList<>();
		if (_value == null || _value.trim().equals(""))
			output.add(new InputError("Location cannot be empty"));
		else if (_value.length() > 20)
			output.add(new InputError("Location must have no more than 20 chars"));
		return output;
	}
}
