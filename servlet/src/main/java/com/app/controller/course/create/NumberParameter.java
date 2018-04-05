package com.app.controller.course.create;

import javax.servlet.http.HttpServletRequest;

public class NumberParameter extends InputParameter {

	private final TotalSeatsParameter _seats;

	public NumberParameter(HttpServletRequest request) {
		super(request);
		_seats = new TotalSeatsParameter(request);
	}
	
	@Override
	public String getName() {
		return "number";
	}
	
	@Override
	public String getValue() {
		return _value == null || _value.trim().equals("") ? "0" : _value;
	}
	
	@Override
	public boolean isValid() {
		return _value == null || _value.trim().equals("") || (
					_value.matches("^[0-9]+$") &&
					Integer.parseInt(_value) <= _seats.getIntegerValue()
				);
	}

}
