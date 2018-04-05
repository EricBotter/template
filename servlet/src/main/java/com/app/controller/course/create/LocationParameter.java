package com.app.controller.course.create;

import javax.servlet.http.HttpServletRequest;

public class LocationParameter extends InputParameter {

	public LocationParameter(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getName() {
		return "location";
	}
	
	@Override
	public boolean isValid() {
		return _value != null && !_value.trim().equals("");
	}
}
