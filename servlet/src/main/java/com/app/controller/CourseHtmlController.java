package com.app.controller;

import seminar.HtmlRenderer;

public class CourseHtmlController extends CourseController {

	@Override
	public boolean handles(String route) {
		return route.equals("/course/html");
	}

	@Override
	public void execute(Context context) throws Exception {
		String contentType = "text/html";
		String output = new HtmlRenderer().output(getSeminar());
		
		writeBasicResponse(context, contentType, output);
	}
	
}
