package com.app.controller.student;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.controller.ControllerHelper;
import com.app.db.StudentMapper;
import com.app.view.StudentListLayout;

public class StudentListController extends Controller {

	@Override
	public boolean handles(String route) {
		return ControllerHelper.routeCheckWithSlashTolerance(route, "/student");
	}

	@Override
	public void execute(Context context) throws Exception {
		ControllerHelper.writeSimpleResponse(context, "text/html",
				new StudentListLayout().buildAndRender(
						new StudentMapper(context.connection()).getAllItems()));
	}
}