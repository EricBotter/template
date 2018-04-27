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
import com.app.controller.course.SeminarEntity;
import com.app.controller.student.StudentEntity;

public class ControllerFactory {

	public List<Controller> create() {
		SeminarEntity seminarEntity = new SeminarEntity();
		StudentEntity studentEntity = new StudentEntity();
		
		return new ArrayList<>(asList(
				new HomeController(),
				new CreateController<>(seminarEntity),
				new CreateController<>(studentEntity),
				new ListController<>(seminarEntity),
				new ListController<>(studentEntity),
				new ViewController<>(seminarEntity),
				new ViewController<>(studentEntity),
				new DeleteController<>(seminarEntity),
				new DeleteController<>(studentEntity)
			));
	}
}
