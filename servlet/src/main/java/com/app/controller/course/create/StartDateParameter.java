package com.app.controller.course.create;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class StartDateParameter extends InputParameter {
	
	StartDateParameter(String value) {
		super(value);
	}

	public StartDateParameter(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getName() {
		return "date";
	}
	
	public LocalDate getCalendarValue() {
		return LocalDate.parse(_value);
	}

	@Override
	public List<InputError> getValidationErrors() {
		ArrayList<InputError> output = new ArrayList<>();
		if (_value == null || _value.trim().equals(""))
			output.add(new InputError("Date cannot be empty"));
		else if (!_value.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))
			output.add(new InputError("Date must be in format YYYY-MM-DD"));
		return output;
	}
}
