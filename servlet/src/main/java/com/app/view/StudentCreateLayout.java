package com.app.view;

import com.app.controller.parameters.InputParametersForItem;
import com.app.controller.student.StudentInputParameters;
import com.github.manliogit.javatags.element.Element;

import seminar.Student;

public class StudentCreateLayout extends FormLayout<Student> {

	@Override
	public Element buildEmpty() {
		return compileForm(
			hiddenIdInput(),
			inputFieldEmpty("name", "text", "Name", "Student Name"),
			inputFieldEmpty("surname", "text", "Surname", "Student Surname")
		);
	}

	@Override
	public Element build(InputParametersForItem<Student> items) {
		StudentInputParameters params = (StudentInputParameters)items;
		return compileForm(
				hiddenIdInput(params.id),
				inputFieldWithData(params.name, "text", "Name", "Student Name"),
				inputFieldWithData(params.surname, "text", "Surname", "Student Surname")
			);
	}

	@Override
	public String getEntity() {
		return "Student";
	}
}
