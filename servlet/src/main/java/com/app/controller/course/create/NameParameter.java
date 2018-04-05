package com.app.controller.course.create;

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
	public boolean isValid() {
		return _value != null && !_value.trim().equals("");
	}
}
