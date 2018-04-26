package com.app.controller.student;

import com.app.controller.Context;
import com.app.controller.EntityCollector;
import com.app.controller.parameters.InputParametersForItem;
import com.app.db.Mapper;
import com.app.db.StudentMapper;
import com.app.view.FormLayout;
import com.app.view.ListLayout;
import com.app.view.StudentCreateLayout;
import com.app.view.StudentListLayout;

import seminar.Student;

public class StudentCollector implements EntityCollector<Student> {

	@Override
	public String getName() {
		return "student";
	}

	@Override
	public Mapper<Student> getMapper(Context context) {
		return new StudentMapper(context.connection());
	}

	@Override
	public FormLayout<Student> getFormLayout() {
		return new StudentCreateLayout();
	}

	@Override
	public ListLayout<Student> getListLayout() {
		return new StudentListLayout();
	}

	@Override
	public InputParametersForItem<Student> getParameters(Context context) {
		return new StudentCreationParameters(context.request());
	}

	@Override
	public InputParametersForItem<Student> getParameters(Student item) {
		return new StudentCreationParameters(item);
	}

}
