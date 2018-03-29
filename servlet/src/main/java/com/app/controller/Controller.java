package com.app.controller;

public abstract class Controller {

	public abstract boolean handles(String route);
	public abstract void execute(Context context) throws Exception;
	
	protected void writeSimpleResponse(Context context, String contentType, String output) throws Exception {
		context.response().setContentType(contentType);
		context.response().setCharacterEncoding("UTF-8");
		context.response().getWriter().write(output);
	}
	
	protected boolean routeCheckWithSlashTolerance(String requestedRoute, String handledRoute) {
		String firstRoute = removeSlashIfPresent(requestedRoute);
		String secondRoute = removeSlashIfPresent(handledRoute);
		return firstRoute.equals(secondRoute);
	}

	private String removeSlashIfPresent(String route) {
		if (route.lastIndexOf('/') == route.length() - 1)
			return route.substring(0, route.length() - 1);
		return route;
	}
	
}
