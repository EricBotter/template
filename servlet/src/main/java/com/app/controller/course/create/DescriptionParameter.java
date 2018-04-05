package com.app.controller.course.create;

import java.util.Collections;
import java.util.List;

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
	public List<InputError> validate() {
		return Collections.emptyList();
	}

}
