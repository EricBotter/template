package com.app.controller;

import com.app.view.Layout;

public class MainController extends Controller {

	@Override
	public boolean handles(String route) {
		return "/".equals(route);
	}

	@Override
	public void execute(Context context) throws Exception {
		String contentType = "text/html";
		String output = new Layout().build().render();
	
		writeSimpleResponse(context, contentType, output);
	}
}
