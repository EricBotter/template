package com.app.controller;

public abstract class Controller {

	public abstract boolean handles(String route);
	public abstract void execute(Context context) throws Exception;

}
