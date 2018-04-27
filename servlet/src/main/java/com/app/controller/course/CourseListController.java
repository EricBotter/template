package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.controller.ControllerHelper;
import com.app.db.SeminarMapper;
import com.app.view.CourseListLayout;

public class CourseListController extends Controller {

	@Override
	public boolean handles(String route) {
		return ControllerHelper.routeCheckWithSlashTolerance(route, "/course") ||
				ControllerHelper.routeCheckWithSlashTolerance(route, "/");
	}

	@Override
	public void execute(Context context) throws Exception {
		ControllerHelper.writeSimpleResponse(context, "text/html",
				new CourseListLayout().buildAndRender(
						new SeminarMapper(context.connection()).getAllItems()));
	}
}
