package com.app.controller.course.create;

import javax.servlet.http.HttpServletRequest;

public class TotalSeatsParameter extends InputParameter {

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
	public boolean isValid() {
		return _value != null && _value.matches("^[0-9]+$");
	}

}
