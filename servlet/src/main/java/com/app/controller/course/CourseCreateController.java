package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.course.create.CourseCreationParameters;
import com.app.view.CourseCreateLayout;

public class CourseCreateController extends CourseController {
	
	@Override
	public boolean handles(String route) {
		return routeCheckWithSlashTolerance(route, "/course/create");
	}

	@Override
	public void execute(Context context) throws Exception {
		if (context.request().getMethod().equals("POST")) {
			CourseCreationParameters params = new CourseCreationParameters(context.request());
			
			if (params.isWholeInputValid()) {
				addSeminar(params.getSeminar());
				context.response().sendRedirect("/course");
			} else {
				writeSimpleResponse(context, "text/html", new CourseCreateLayout().build(params).render());
			}
		} else
			writeSimpleResponse(context, "text/html", new CourseCreateLayout().buildEmpty().render());
	}
}
