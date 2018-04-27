package com;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.course.CourseCreateController;
import com.app.controller.course.CourseDeleteController;
import com.app.controller.course.CourseListController;
import com.app.controller.course.CourseViewController;
import com.app.controller.student.StudentCreateController;
import com.app.controller.student.StudentDeleteController;
import com.app.controller.student.StudentListController;
import com.app.controller.student.StudentViewController;

public class ControllerFactory {

	public List<Controller> create() {
		return new ArrayList<>(asList(
				new CourseCreateController(),
				new CourseDeleteController(),
				new CourseListController(),
				new CourseViewController(),
				new StudentCreateController(),
				new StudentDeleteController(),
				new StudentListController(),
				new StudentViewController()
			));
	}
}
