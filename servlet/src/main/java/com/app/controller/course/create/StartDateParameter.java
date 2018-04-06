package com.app.controller.course.create;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class StartDateParameter extends InputParameter {

	public StartDateParameter(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getName() {
		return "date";
	}
	
	public GregorianCalendar getCalendarValue() {
		return parseDate(_value);
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

	private GregorianCalendar parseDate(String startDate) {
		String[] dateElements = startDate.split("-");
		GregorianCalendar date = new GregorianCalendar(
				Integer.parseInt(dateElements[0]),
				Integer.parseInt(dateElements[1]),
				Integer.parseInt(dateElements[2])
			);
		return date;
	}
}
