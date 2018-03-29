package com.app.controller;

import seminar.Seminar;

public class CourseListController extends CourseController {

	@Override
	public boolean handles(String route) {
		return routeCheckWithSlashTolerance(route, "/course");
	}

	@Override
	public void execute(Context context) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><title>Course List</title></head>"
				+ "<body><h1>Course List</h1><ul>");
		for (Seminar s : getSeminars()) {
			sb.append("<li>" + s.getName() + "</li>");
		}
		sb.append("</ul></body></html>");
		
		writeSimpleResponse(context, "text/html", sb.toString());
	}

}
