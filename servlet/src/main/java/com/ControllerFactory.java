package com;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.CreateController;
import com.app.controller.DeleteController;
import com.app.controller.HomeController;
import com.app.controller.ListController;
import com.app.controller.ViewController;

public class ControllerFactory {

	public List<Controller> create() {
		return new ArrayList<>(asList(
				new HomeController(),
				new CreateController(),
				new ListController(),
				new ViewController(),
				new DeleteController()
			));
	}
}
