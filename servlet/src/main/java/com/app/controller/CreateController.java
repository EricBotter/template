package com.app.controller;

import com.app.controller.parameters.InputParametersForItem;
import com.app.db.Mapper;
import com.app.view.FormLayout;

public class CreateController extends Controller {
	
	@Override
	public boolean handles(String route) {
		EntityCollector collector = EntityCollectorFactory.getCollectorFromPath(route);
		return routeCheckWithSlashTolerance(route, "/" + collector.getName() + "/create");
	}

	@Override
	public void execute(Context context) throws Exception {
		create(context,
				EntityCollectorFactory.getCollectorFromPath(context.request().getServletPath()));
	}
	
	private <T> void create(Context context, EntityCollector<T> entity) throws Exception {
		FormLayout<T> createLayout = entity.getFormLayout();
		Mapper<T> dataMapper = entity.getMapper(context);
		InputParametersForItem<T> params = entity.getParameters(context);

		if (context.request().getMethod().equals("POST")) {
			if (params.isWholeInputValid()) {
				dataMapper.addItem(params.getItem());
				context.response().sendRedirect("/" + entity.getName());
			} else {
				writeSimpleResponse(context, "text/html", createLayout.build(params).render());
			}
		} else
			writeSimpleResponse(context, "text/html", createLayout.buildEmpty().render());
	}
}
