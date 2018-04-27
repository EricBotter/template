package com.app.controller;

import com.app.controller.parameters.InputParametersForItem;

public class ViewController<T> extends Controller {

	private final Creatable<T> _entity;
	
	public ViewController(Creatable<T> creatable) {
		_entity = creatable;
	}
	
	@Override
	public boolean handles(String route) {
		return route.matches("^/" + _entity.getName() + "/0*[1-9][0-9]*$");
	}

	@Override
	public void execute(Context context) throws Exception {
		String path = context.request().getServletPath();
		String id = path.substring(path.lastIndexOf('/') + 1);
		InputParametersForItem<T> params;

		if (context.request().getMethod().equals("POST")) {
			params = _entity.getParameters(context);
			
			if (params.isWholeInputValid()) {
				_entity.getMapper(context).updateItem(params.getItem());
				context.response().sendRedirect("/" + _entity.getName());
				return;
			}
		} else {
			T item = _entity.getMapper(context).getItemById(id);
			params = _entity.getParameters(item);
		}
		
		ControllerHelper.writeSimpleResponse(
				context, "text/html", _entity.getFormLayout().build(params).render());
	}
}
