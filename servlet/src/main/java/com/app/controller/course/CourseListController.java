package com.app.controller.course;

import com.app.controller.Context;
import com.app.view.CourseListLayout;

public class CourseListController extends CourseController {

	@Override
	public boolean handles(String route) {
		return routeCheckWithSlashTolerance(route, "/course") ||
			routeCheckWithSlashTolerance(route, "/");
	}

	@Override
	public void execute(Context context) throws Exception {
		writeSimpleResponse(context, "text/html",
				new CourseListLayout().buildAndRender(getSeminars()));
	}
}
