package com.app.controller.student;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.db.StudentMapper;
import com.app.view.StudentCreateLayout;

public class StudentCreateController extends Controller {
	
	@Override
	public boolean handles(String route) {
		return routeCheckWithSlashTolerance(route, "/student/create");
	}

	@Override
	public void execute(Context context) throws Exception {
		StudentInputParameters params = new StudentInputParameters(context.request());
		if (context.request().getMethod().equals("POST")) {
			if (params.isWholeInputValid()) {
				new StudentMapper(context.connection()).addItem(params.getItem());
				context.response().sendRedirect("/student");
			} else {
				writeSimpleResponse(context, "text/html", new StudentCreateLayout().build(params).render());
			}
		} else
			writeSimpleResponse(context, "text/html", new StudentCreateLayout().buildEmpty().render());
	}
}
