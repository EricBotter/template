package com.app.controller.student;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.db.StudentMapper;

public class StudentDeleteController extends Controller {

	@Override
	public boolean handles(String route) {
		return route.matches("^/student/delete/[0-9]+$");
	}

	@Override
	public void execute(Context context) throws Exception {
		String path = context.request().getServletPath();
		String id = path.substring(path.lastIndexOf('/') + 1);
		new StudentMapper(context.connection()).deleteItemById(id);
		context.response().sendRedirect("/student");
	}

}