package com;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.MainController;
import com.app.controller.course.CourseCreateController;
import com.app.controller.course.CourseListController;

public class ControllerFactory {

	public List<Controller> create() {
		return new ArrayList<>(asList(
				new MainController(),
				new CourseCreateController(),
				new CourseListController()
			));
	}
}
