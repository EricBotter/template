package com.app.controller.student;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.controller.create.IdParameter;
import com.app.controller.create.InputParameter;
import com.app.controller.create.InputParametersForItem;
import com.app.controller.create.NameParameter;
import com.app.controller.create.SurnameParameter;

import seminar.Student;

public class StudentParameters implements InputParametersForItem<Student> {
	public final NameParameter name;
	public final SurnameParameter surname;
	public final IdParameter id;
	
	public StudentParameters(HttpServletRequest request) {
		name = new NameParameter(request);
		surname = new SurnameParameter(request);
		id = new IdParameter(request);
	}

	public StudentParameters(Student s) {
		name = new NameParameter(s.getName());
		surname = new SurnameParameter(s.getName());
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
