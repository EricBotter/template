package com.app.controller.course.create;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class NumberParameter extends InputParameter {

	public NumberParameter(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getName() {
		return "number";
	}
	
	@Override
	public List<InputError> validate() {
		ArrayList<InputError> output = new ArrayList<>();
		if (_value == null || _value.trim().equals(""))
			output.add(new InputError("Number cannot be empty"));
		return output;
	}

}
