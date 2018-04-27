package com.app.controller;

public class HomeController extends Controller {

	@Override
	public boolean handles(String route) {
		return ControllerHelper.routeCheckWithSlashTolerance(route, "/");
	}

	@Override
	public void execute(Context context) throws Exception {
		context.response().sendRedirect("/course");
	}

}
