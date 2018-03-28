package com.app.controller;

import seminar.CsvRenderer;

public class CourseCsvController extends CourseController {

	@Override
	public boolean handles(String route) {
		return route.equals("/course/csv");
	}

	@Override
	public void execute(Context context) throws Exception {
		String contentType = "text/csv";
		String output = new CsvRenderer().output(getSeminar());
		
		writeBasicResponse(context, contentType, output);
	}
	
}
