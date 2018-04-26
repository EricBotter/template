package com.app.controller;

import java.io.IOException;

import com.app.controller.parameters.InputParametersForItem;

public class ViewController extends Controller {

	@Override
	public boolean handles(String route) {
		EntityCollector collector = EntityCollectorFactory.getCollectorFromPath(route);
		return route.matches("^/" + collector.getName() + "/0*[1-9][0-9]*$");
	}

	@Override
	public void execute(Context context) throws Exception {
		view(context,
				EntityCollectorFactory.getCollectorFromPath(context.request().getServletPath()));
	}

	public <T> void view(Context context, EntityCollector<T> entity) throws IOException, Exception {
		String path = context.request().getServletPath();
		String id = path.substring(path.lastIndexOf('/') + 1);
		InputParametersForItem<T> params;

		if (context.request().getMethod().equals("POST")) {
			params = entity.getParameters(context);
			
			if (params.isWholeInputValid()) {
				entity.getMapper(context).updateItem(params.getItem());
				context.response().sendRedirect("/" + entity.getName());
				return;
			}
		} else {
			T item = entity.getMapper(context).getItemById(id);
			params = entity.getParameters(item);
		}
		
		writeSimpleResponse(context, "text/html", entity.getFormLayout().build(params).render());
	}
}
