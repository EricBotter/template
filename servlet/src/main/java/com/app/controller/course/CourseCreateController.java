package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.controller.ControllerHelper;
import com.app.db.SeminarMapper;
import com.app.view.CourseCreateLayout;

public class CourseCreateController extends Controller {
	
	@Override
	public boolean handles(String route) {
		return ControllerHelper.routeCheckWithSlashTolerance(route, "/course/create");
	}

	@Override
	public void execute(Context context) throws Exception {
		CourseInputParameters params = new CourseInputParameters(context.request());
		if (context.request().getMethod().equals("POST")) {
			if (params.isWholeInputValid()) {
				new SeminarMapper(context.connection()).addItem(params.getItem());
				context.response().sendRedirect("/course");
			} else {
				ControllerHelper.writeSimpleResponse(
						context, "text/html", new CourseCreateLayout().build(params).render());
			}
		} else
			ControllerHelper.writeSimpleResponse(
					context, "text/html", new CourseCreateLayout().buildEmpty().render());
	}
}
