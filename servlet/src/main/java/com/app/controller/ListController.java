package com.app.controller;

import com.app.db.Mapper;
import com.app.view.ListLayout;

public class ListController extends Controller {

	@Override
	public boolean handles(String route) {
		EntityCollector collector = EntityCollectorFactory.getCollectorFromPath(route);
		return routeCheckWithSlashTolerance(route, "/" + collector.getName());
	}

	@Override
	public void execute(Context context) throws Exception {
		list(context,
				EntityCollectorFactory.getCollectorFromPath(context.request().getServletPath()));
	}

	public <T> void list(Context context, EntityCollector<T> entity) throws Exception {
		ListLayout<T> listLayout = entity.getListLayout();
		Mapper<T> mapper = entity.getMapper(context);
		writeSimpleResponse(context, "text/html",
				listLayout.buildAndRender(mapper.getAllItems()));
	}
}
