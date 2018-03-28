package com.app.controller;

public abstract class Controller {

	public abstract boolean handles(String route);
	public abstract void execute(Context context) throws Exception;
	
	protected void writeBasicResponse(Context context, String contentType, String output) throws Exception {
		context.response().setContentType(contentType);
		context.response().setCharacterEncoding("UTF-8");
		context.response().getWriter().write(output);
	}
	
}
