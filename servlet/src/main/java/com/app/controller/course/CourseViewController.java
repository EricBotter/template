package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.db.SeminarMapper;
import com.app.view.CourseCreateLayout;

import seminar.Seminar;

public class CourseViewController extends Controller {

	@Override
	public boolean handles(String route) {
		return route.matches("^/course/0*[1-9][0-9]*$");
	}

	@Override
	public void execute(Context context) throws Exception {
		String path = context.request().getServletPath();
		String id = path.substring(path.lastIndexOf('/') + 1);
		CourseCreationParameters params;

		if (context.request().getMethod().equals("POST")) {
			params = new CourseCreationParameters(context.request());
			
			if (params.isWholeInputValid()) {
				new SeminarMapper(context.connection()).updateItem(params.getItem());
				context.response().sendRedirect("/course");
				return;
			}
		} else {
			Seminar s = new SeminarMapper(context.connection()).getItemById(id);
			params = new CourseCreationParameters(s);
		}
		
		writeSimpleResponse(context, "text/html", new CourseCreateLayout().build(params).render());
	}
}
