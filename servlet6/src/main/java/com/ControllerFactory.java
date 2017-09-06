package com;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.MainController;

public class ControllerFactory {

	public List<Controller> create() {
		return new ArrayList<Controller>(asList(new MainController()));
	}
}
