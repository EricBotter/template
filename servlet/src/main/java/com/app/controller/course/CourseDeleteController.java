package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.db.SeminarMapper;

public class CourseDeleteController extends Controller {

	@Override
	public boolean handles(String route) {
		return route.matches("^/course/delete/[0-9]+$");
	}

	@Override
	public void execute(Context context) throws Exception {
		String path = context.request().getServletPath();
		String id = path.substring(path.lastIndexOf('/') + 1);
		new SeminarMapper(context.connection()).deleteSeminar(id);
		context.response().sendRedirect("/course");
	}

}
