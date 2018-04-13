package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.view.CourseListLayout;
import com.db.SeminarMapper;

public class CourseListController extends Controller {

	@Override
	public boolean handles(String route) {
		return routeCheckWithSlashTolerance(route, "/course") ||
			routeCheckWithSlashTolerance(route, "/");
	}

	@Override
	public void execute(Context context) throws Exception {
		writeSimpleResponse(context, "text/html",
				new CourseListLayout().buildAndRender(
						new SeminarMapper(context.connection()).getSeminars()
		));
	}
}
