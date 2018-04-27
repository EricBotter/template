package com.app.controller.student;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.controller.parameters.IdParameter;
import com.app.controller.parameters.InputParameter;
import com.app.controller.parameters.InputParametersForItem;
import com.app.controller.parameters.NameParameter;
import com.app.controller.parameters.SurnameParameter;

import seminar.Student;

public class StudentInputParameters implements InputParametersForItem<Student> {
	public final NameParameter name;
	public final SurnameParameter surname;
	public final IdParameter id;
	
	public StudentInputParameters(HttpServletRequest request) {
		name = new NameParameter(request);
		surname = new SurnameParameter(request);
		id = new IdParameter(request);
	}

	public StudentInputParameters(Student s) {
		name = new NameParameter(s.getName());
		surname = new SurnameParameter(s.getSurname());
		id = new IdParameter(String.valueOf(s.getId()));
	}

	@Override
	public Student getItem() {
		return new Student(
				id.getIntegerValue(),
				name.getValue(),
				surname.getValue()
		);
	}

	private List<InputParameter> getParameterList() {
		return Arrays.asList(id, name, surname);
	}

	@Override
	public boolean isWholeInputValid() {
		return getParameterList().stream()
				.allMatch(param -> param.getValidationErrors().isEmpty());
	}
}
