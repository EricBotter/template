package com.app.controller;

public class DeleteController extends Controller {

	@Override
	public boolean handles(String route) {
		EntityCollector collector = EntityCollectorFactory.getCollectorFromPath(route);
		return route.matches("^/" + collector.getName() + "/delete/[0-9]+$");
	}

	@Override
	public void execute(Context context) throws Exception {
		delete(context,
				EntityCollectorFactory.getCollectorFromPath(context.request().getServletPath()));
	}

	public <T> void delete(Context context, EntityCollector<T> entity) throws Exception {
		String path = context.request().getServletPath();
		String id = path.substring(path.lastIndexOf('/') + 1);
		entity.getMapper(context).deleteItemById(id);
		context.response().sendRedirect("/" + entity.getName());
	}

}
