package com.app.controller.course;

import com.app.controller.Context;
import com.app.controller.EntityCollector;
import com.app.controller.parameters.InputParametersForItem;
import com.app.db.Mapper;
import com.app.db.SeminarMapper;
import com.app.view.CourseCreateLayout;
import com.app.view.CourseListLayout;
import com.app.view.FormLayout;
import com.app.view.ListLayout;

import seminar.Seminar;

public class SeminarCollector implements EntityCollector<Seminar> {

	@Override
	public String getName() {
		return "course";
	}

	@Override
	public Mapper<Seminar> getMapper(Context context) {
		return new SeminarMapper(context.connection());
	}

	@Override
	public FormLayout<Seminar> getFormLayout() {
		return new CourseCreateLayout();
	}

	@Override
	public ListLayout<Seminar> getListLayout() {
		return new CourseListLayout();
	}

	@Override
	public InputParametersForItem<Seminar> getParameters(Context context) {
		return new CourseCreationParameters(context.request());
	}

	@Override
	public InputParametersForItem<Seminar> getParameters(Seminar item) {
		return new CourseCreationParameters(item);
	}

}
