package com.app.controller.course.create;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class NameParameter extends InputParameter {
	
	public NameParameter(HttpServletRequest request) {
		super(request);
	}
	
	public NameParameter() {
		super((String)null);
	}
	
	@Override
	public String getName() {
		return "name";
	}
	
	@Override
	public List<InputError> validate() {
		ArrayList<InputError> output = new ArrayList<>();
		if (_value == null || _value.trim().equals(""))
			output.add(new InputError("Name cannot be empty"));
		else if (_value.length() > 15)
			output.add(new InputError("Name must have no more than 15 chars"));
		return output;
	}
}
