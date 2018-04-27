package com.app.controller;

public class ListController<T> extends Controller {

	private final Listable<T> _entity;
	
	public ListController(Listable<T> listable) {
		_entity = listable;
	}
	
	@Override
	public boolean handles(String route) {
		return ControllerHelper.routeCheckWithSlashTolerance(route, "/" + _entity.getName());
	}

	@Override
	public void execute(Context context) throws Exception {
		ControllerHelper.writeSimpleResponse(context, "text/html",
				_entity.getListLayout().buildAndRender(
						_entity.getMapper(context).getAllItems()));
	}
}
