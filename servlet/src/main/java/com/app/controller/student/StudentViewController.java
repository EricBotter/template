package com.app.controller.student;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.db.StudentMapper;
import com.app.view.StudentCreateLayout;

import seminar.Student;

public class StudentViewController extends Controller {

	@Override
	public boolean handles(String route) {
		return route.matches("^/student/0*[1-9][0-9]*$");
	}

	@Override
	public void execute(Context context) throws Exception {
		String path = context.request().getServletPath();
		String id = path.substring(path.lastIndexOf('/') + 1);
		StudentInputParameters params;

		if (context.request().getMethod().equals("POST")) {
			params = new StudentInputParameters(context.request());
			
			if (params.isWholeInputValid()) {
				new StudentMapper(context.connection()).updateItem(params.getItem());
				context.response().sendRedirect("/student");
				return;
			}
		} else {
			Student s = new StudentMapper(context.connection()).getItemById(id);
			params = new StudentInputParameters(s);
		}
		
		writeSimpleResponse(context, "text/html", new StudentCreateLayout().build(params).render());
	}
}
