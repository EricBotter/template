package com.app.controller;

import seminar.BasicRenderer;

public class CourseRawController extends CourseController {

	@Override
	public boolean handles(String route) {
		return route.equals("/course/raw");
	}

	@Override
	public void execute(Context context) throws Exception {
		String contentType = "text/plain";
		String output = new BasicRenderer().output(getSeminar());
		
		writeBasicResponse(context, contentType, output);
	}
}
