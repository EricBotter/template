package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.db.SeminarMapper;
import com.app.view.CourseCreateLayout;

public class CourseCreateController extends Controller {
	
	@Override
	public boolean handles(String route) {
		return routeCheckWithSlashTolerance(route, "/course/create");
	}

	@Override
	public void execute(Context context) throws Exception {
		CourseCreationParameters params = new CourseCreationParameters(context.request());
		if (context.request().getMethod().equals("POST")) {
			if (params.isWholeInputValid()) {
				new SeminarMapper(context.connection()).addItem(params.getItem());
				context.response().sendRedirect("/course");
			} else {
				writeSimpleResponse(context, "text/html", new CourseCreateLayout().build(params).render());
			}
		} else
			writeSimpleResponse(context, "text/html", new CourseCreateLayout().buildEmpty().render());
	}
}
