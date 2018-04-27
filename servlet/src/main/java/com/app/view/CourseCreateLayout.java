package com.app.view;

import com.app.controller.course.CourseInputParameters;
import com.app.controller.parameters.InputParametersForItem;
import com.github.manliogit.javatags.element.Element;

import seminar.Seminar;

public class CourseCreateLayout extends FormLayout<Seminar> {

	@Override
	public Element buildEmpty() {
		return compileForm(
			hiddenIdInput(),
			inputFieldEmpty("name", "text", "Name", "Introductory Seminar"),
			inputFieldEmpty("description", "text", "Description", "Introduction to the Academy"),
			inputFieldEmpty("date", "date", "Start Date", "2018-03-21"),
			inputFieldEmpty("location", "text", "Location", "Room 3, main building"),
			inputFieldEmpty("seats", "number", "Tot. seats", "50")
		);
	}

	@Override
	public Element build(InputParametersForItem<Seminar> items) {
		CourseInputParameters params = (CourseInputParameters)items;
		return compileForm(
			hiddenIdInput(params.id),
			inputFieldWithData(params.name, "text", "Name", "Introductory Seminar"),
			inputFieldWithData(params.description, "text", "Description", "Introduction to the Academy"),
			inputFieldWithData(params.date, "date", "Start Date", "2018-03-21"),
			inputFieldWithData(params.location, "text", "Location", "Room 3, main building"),
			inputFieldWithData(params.seats, "number", "Tot. seats", "50")
		);
	}

	@Override
	public String getEntity() {
		return "Course";
	}
}
