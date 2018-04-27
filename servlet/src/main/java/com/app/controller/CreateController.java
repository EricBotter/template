package com.app.controller;

import com.app.controller.parameters.InputParametersForItem;
import com.app.db.Mapper;
import com.app.view.FormLayout;

public class CreateController<T> extends Controller {
	
	private final Creatable<T> _entity;
	
	public CreateController(Creatable<T> creatable) {
		_entity = creatable;
	}
	
	@Override
	public boolean handles(String route) {
		return ControllerHelper.routeCheckWithSlashTolerance(
				route, "/" + _entity.getName() + "/create");
	}

	@Override
	public void execute(Context context) throws Exception {
		FormLayout<T> createLayout = _entity.getFormLayout();
		Mapper<T> dataMapper = _entity.getMapper(context);
		InputParametersForItem<T> params = _entity.getParameters(context);
		
		if (context.request().getMethod().equals("POST")) {
			if (params.isWholeInputValid()) {
				dataMapper.addItem(params.getItem());
				context.response().sendRedirect("/" + _entity.getName());
			} else {
				ControllerHelper.writeSimpleResponse(
						context, "text/html", createLayout.build(params).render());
			}
		} else
			ControllerHelper.writeSimpleResponse(
					context, "text/html", createLayout.buildEmpty().render());
	}
}
