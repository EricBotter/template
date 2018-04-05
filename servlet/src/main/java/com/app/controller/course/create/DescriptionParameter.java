package com.app.controller.course.create;

import javax.servlet.http.HttpServletRequest;

public class DescriptionParameter extends InputParameter {

	protected DescriptionParameter(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getName() {
		return "description";
	}
	
	@Override
	public String getValue() {
		return _value == null ? "" : _value;
	}
	
	@Override
	public boolean isValid() {
		return true;
	}

}
