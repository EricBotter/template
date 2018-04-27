package com.app.controller;

public class DeleteController<T> extends Controller {

	private final DbSerializable<T> _entity;
	
	public DeleteController(DbSerializable<T> entity) {
		_entity = entity;
	}
	
	@Override
	public boolean handles(String route) {
		return route.matches("^/" + _entity.getName() + "/delete/[0-9]+$");
	}

	@Override
	public void execute(Context context) throws Exception {
		String path = context.request().getServletPath();
		String id = path.substring(path.lastIndexOf('/') + 1);
		_entity.getMapper(context).deleteItemById(id);
		context.response().sendRedirect("/" + _entity.getName());
	}
}
